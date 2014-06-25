package za.ac.wits.eie.ELEN7045.aps.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;
import za.ac.wits.eie.ELEN7045.aps.model.statement.CreditCardStatement;
import za.ac.wits.eie.ELEN7045.aps.model.statement.MunicipalityStatement;
import za.ac.wits.eie.ELEN7045.aps.model.statement.TelcoStatement;
import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;
import za.ac.wits.eie.ELEN7045.aps.service.StatementService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;

@ManagedBean(name="scraper")
@SessionScoped
public class Scraper {
	
	private List<CompanyAccount> companyAccounts;     
	private DataModel<CompanyAccount> companyAccountModel;
	
	private String accountNumber;
	private String openingBalance;
	private String closingBalance;
	private String discount;
	
	//telco statement
	private String telNo;
	private String electricityCharges;
	private String serviceCharges;
	private String callCharges;
	
	//render 
	private boolean renderTelco;
	private boolean renderMunicpal;
	private boolean renderCredit;
	
	//credit card statement
	private String creditCardType;
    private String creditAvailable;
    private String creditLimit;
    private String interestRate;
    private String minimumAmountDue;
	
	
	@Inject
    private Logger log;
	
	@Inject
    private StatementService statementService;
	
	@Inject
	Login login;
	
	@PostConstruct   public void init() {
		companyAccounts = login.getCompanyAccountList();         
		companyAccountModel = new ListDataModel<CompanyAccount>(companyAccounts);
	}
	
	@Produces
    @Named
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Produces
    @Named
	public String getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(String openingBalance) {
		this.openingBalance = openingBalance;
	}

	@Produces
    @Named
	public String getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(String closingBalance) {
		this.closingBalance = closingBalance;
	}

	@Produces
    @Named
	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	@Produces
    @Named
	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	
	@Produces
    @Named
	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}
	
	@Produces
    @Named
	public String getElectricityCharges() {
		return electricityCharges;
	}

	public void setElectricityCharges(String electricityCharges) {
		this.electricityCharges = electricityCharges;
	}

	@Produces
    @Named
	public String getServiceCharges() {
		return serviceCharges;
	}

	public void setServiceCharges(String serviceCharges) {
		this.serviceCharges = serviceCharges;
	}
	
	@Produces
    @Named
	public String getCallCharges() {
		return callCharges;
	}

	public void setCallCharges(String callCharges) {
		this.callCharges = callCharges;
	}

	@Produces
    @Named
	public String getCreditAvailable() {
		return creditAvailable;
	}

	public void setCreditAvailable(String creditAvailable) {
		this.creditAvailable = creditAvailable;
	}

	@Produces
    @Named
	public String getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	@Produces
    @Named
	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	@Produces
    @Named
	public String getMinimumAmountDue() {
		return minimumAmountDue;
	}

	public void setMinimumAmountDue(String minimumAmountDue) {
		this.minimumAmountDue = minimumAmountDue;
	}

	public List<CompanyAccount> getCompanyAccounts() {
		return companyAccounts;
	}

	public void setCompanyAccounts(List<CompanyAccount> companyAccounts) {
		this.companyAccounts = companyAccounts;
	}

	@Produces
    @Named
	public DataModel<CompanyAccount> getCompanyAccountModel() {
		return companyAccountModel;
	}

	public void setCompanyAccountModel(DataModel<CompanyAccount> companyAccountModel) {
		this.companyAccountModel = companyAccountModel;
	} 
	
	public String view() {
		
		List<Statement> results = new ArrayList<Statement>();
		CompanyAccount companyAccount = companyAccountModel.getRowData();
		if(companyAccount != null) {
			try {
				results.clear();
				results = statementService.loadAccountStatement(companyAccount.getAccountNumber());
				log.info("List of statements for account number: "+companyAccount.getAccountNumber() +" are : "+results.size());
				if(results.size() != 0) {
					log.info("companyAccountModel.getRowCount() ------------ "+companyAccountModel.getRowCount());
					for(Statement st : results){
						//check the type of statement before setting the fields
						if(st instanceof TelcoStatement ){
							log.info("-------Telco statement--------");
							setRenderTelco(true);
							setRenderCredit(false);
							setRenderMunicpal(false);
							TelcoStatement tel = (TelcoStatement)st;
							setTelNo(tel.getTelephoneNumber());
							setCallCharges(tel.getCallCharges());
							setServiceCharges(tel.getServiceCharges());
						}else if(st instanceof CreditCardStatement){
							log.info("-------Credit statement--------");
							setRenderCredit(true);
							setRenderMunicpal(false);
							setRenderTelco(false);
							CreditCardStatement crd = (CreditCardStatement)st;
							setCreditCardType(crd.getCardType());
							setMinimumAmountDue(crd.getMinimumAmountDue());
							setCreditAvailable(crd.getCreditAvailable());
							setCreditLimit(crd.getCreditLimit());
							setInterestRate(crd.getInterestRate());
							
						}else if(st instanceof MunicipalityStatement){
							setRenderMunicpal(true);
							setRenderCredit(false);
							setRenderTelco(false);
							log.info("-------Municipal statement--------");
							MunicipalityStatement mun = (MunicipalityStatement)st;
							setElectricityCharges(mun.getElectrictyCharges());
						}
						
						setAccountNumber(st.getAccountNumber());
						setOpeningBalance(st.getOpeningBalance());
						setClosingBalance(st.getClosingBalance());
						setDiscount(st.getDiscount());
					}
					
					return "success";
				}
				
			} catch (APSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "failure";
	}

	@Produces
    @Named
	public boolean isRenderTelco() {
		return renderTelco;
	}

	public void setRenderTelco(boolean renderTelco) {
		this.renderTelco = renderTelco;
	}

	@Produces
    @Named
	public boolean isRenderMunicpal() {
		return renderMunicpal;
	}

	public void setRenderMunicpal(boolean renderMunicpal) {
		this.renderMunicpal = renderMunicpal;
	}

	@Produces
    @Named
	public boolean isRenderCredit() {
		return renderCredit;
	}

	public void setRenderCredit(boolean renderCredit) {
		this.renderCredit = renderCredit;
	}	
}
