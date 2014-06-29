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

@ManagedBean(name = "scraper")
@SessionScoped
public class Scraper {

	private String accountNumber;
	private String callCharges;

	private String closingBalance;
	private DataModel<CompanyAccount> companyAccountModel;
	private List<CompanyAccount> companyAccounts;
	private String creditAvailable;

	// credit card statement
	private String creditCardType;
	private String creditLimit;
	private String discount;
	private String electricityCharges;

	private String interestRate;
	@Inject
	private Logger log;
	@Inject
	LoginController login;

	private String minimumAmountDue;
	private String openingBalance;
	private boolean renderCredit;
	private boolean renderMunicpal;
	// render
	private boolean renderTelco;

	private String serviceCharges;

	@Inject
	private StatementService statementService;

	// telco statement
	private String telNo;

	@Produces
	@Named
	public String getAccountNumber() {
		return accountNumber;
	}

	@Produces
	@Named
	public String getCallCharges() {
		return callCharges;
	}

	@Produces
	@Named
	public String getClosingBalance() {
		return closingBalance;
	}

	@Produces
	@Named
	public DataModel<CompanyAccount> getCompanyAccountModel() {
		return companyAccountModel;
	}

	public List<CompanyAccount> getCompanyAccounts() {
		return companyAccounts;
	}

	@Produces
	@Named
	public String getCreditAvailable() {
		return creditAvailable;
	}

	@Produces
	@Named
	public String getCreditCardType() {
		return creditCardType;
	}

	@Produces
	@Named
	public String getCreditLimit() {
		return creditLimit;
	}

	@Produces
	@Named
	public String getDiscount() {
		return discount;
	}

	@Produces
	@Named
	public String getElectricityCharges() {
		return electricityCharges;
	}

	@Produces
	@Named
	public String getInterestRate() {
		return interestRate;
	}

	@Produces
	@Named
	public String getMinimumAmountDue() {
		return minimumAmountDue;
	}

	@Produces
	@Named
	public String getOpeningBalance() {
		return openingBalance;
	}

	@Produces
	@Named
	public String getServiceCharges() {
		return serviceCharges;
	}

	@Produces
	@Named
	public String getTelNo() {
		return telNo;
	}

	@PostConstruct
	public void init() {
		companyAccounts = login.getCompanyAccountList();
		companyAccountModel = new ListDataModel<CompanyAccount>(companyAccounts);
	}

	@Produces
	@Named
	public boolean isRenderCredit() {
		return renderCredit;
	}

	@Produces
	@Named
	public boolean isRenderMunicpal() {
		return renderMunicpal;
	}

	@Produces
	@Named
	public boolean isRenderTelco() {
		return renderTelco;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setCallCharges(String callCharges) {
		this.callCharges = callCharges;
	}

	public void setClosingBalance(String closingBalance) {
		this.closingBalance = closingBalance;
	}

	public void setCompanyAccountModel(DataModel<CompanyAccount> companyAccountModel) {
		this.companyAccountModel = companyAccountModel;
	}

	public void setCompanyAccounts(List<CompanyAccount> companyAccounts) {
		this.companyAccounts = companyAccounts;
	}

	public void setCreditAvailable(String creditAvailable) {
		this.creditAvailable = creditAvailable;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public void setElectricityCharges(String electricityCharges) {
		this.electricityCharges = electricityCharges;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	public void setMinimumAmountDue(String minimumAmountDue) {
		this.minimumAmountDue = minimumAmountDue;
	}

	public void setOpeningBalance(String openingBalance) {
		this.openingBalance = openingBalance;
	}

	public void setRenderCredit(boolean renderCredit) {
		this.renderCredit = renderCredit;
	}

	public void setRenderMunicpal(boolean renderMunicpal) {
		this.renderMunicpal = renderMunicpal;
	}

	public void setRenderTelco(boolean renderTelco) {
		this.renderTelco = renderTelco;
	}

	public void setServiceCharges(String serviceCharges) {
		this.serviceCharges = serviceCharges;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String view() {

		List<Statement> results = new ArrayList<Statement>();
		CompanyAccount companyAccount = companyAccountModel.getRowData();
		if (companyAccount != null) {
			try {
				results.clear();
				results = statementService.loadAccountStatement(companyAccount.getAccountNumber());
				log.info("List of statements for account number: " + companyAccount.getAccountNumber() + " are : " + results.size());
				if (results.size() != 0) {
					log.info("companyAccountModel.getRowCount() ------------ " + companyAccountModel.getRowCount());
					for (Statement st : results) {
						// check the type of statement before setting the fields
						if (st instanceof TelcoStatement) {
							log.info("-------Telco statement--------");
							setRenderTelco(true);
							setRenderCredit(false);
							setRenderMunicpal(false);
							TelcoStatement tel = (TelcoStatement) st;
							setTelNo(tel.getTelephoneNumber());
							setCallCharges(tel.getCallCharges());
							setServiceCharges(tel.getServiceCharges());
						} else if (st instanceof CreditCardStatement) {
							log.info("-------Credit statement--------");
							setRenderCredit(true);
							setRenderMunicpal(false);
							setRenderTelco(false);
							CreditCardStatement crd = (CreditCardStatement) st;
							setCreditCardType(crd.getCardType());
							setMinimumAmountDue(crd.getMinimumAmountDue());
							setCreditAvailable(crd.getCreditAvailable());
							setCreditLimit(crd.getCreditLimit());
							setInterestRate(crd.getInterestRate());

						} else if (st instanceof MunicipalityStatement) {
							setRenderMunicpal(true);
							setRenderCredit(false);
							setRenderTelco(false);
							log.info("-------Municipal statement--------");
							MunicipalityStatement mun = (MunicipalityStatement) st;
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
}
