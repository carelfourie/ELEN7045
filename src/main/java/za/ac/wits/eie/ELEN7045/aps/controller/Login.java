package za.ac.wits.eie.ELEN7045.aps.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;
import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;
import za.ac.wits.eie.ELEN7045.aps.service.LoginService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;

@Model
public class Login {

	private List<CompanyAccount> companyAccountList = new ArrayList<CompanyAccount>();
	
	private List<Statement> statementList = new ArrayList<Statement>();
	
	@Produces
    @Named
	private Credentials credentials;
	
	@Inject
    private FacesContext facesContext;
	
	@Inject
    private Logger log;
    
    @Inject
    private LoginService loginService;
    		
    @Produces
    @Named
	public List<CompanyAccount> getCompanyAccountList() {
		return companyAccountList;
	}
    
    @Produces
    @Named
	public List<Statement> getStatementList() {
		return statementList;
	}
    
    @PostConstruct
    public void initCredentials() {
    	credentials = new Credentials();
    }

	/**
     * Login a user to retrieve scraped accounts
     * @return
     * @throws APSException 
     */
    public String login() throws APSException {
    	
    	 //List<CompanyAccount> results;
    	List<Statement> results;
		try {
			log.info("login to get scraped accounts for ........ "+credentials.getUsername());
			results = loginService.loadAccountStatements(credentials.getPassword(), credentials.getUsername());
			//results = loginService.loadAPSUserAccounts(credentials.getPassword(), credentials.getUsername());
			if( results.size() != 0) {
//				setCompanyAccountList(results);
				setStatementList(results);
				initCredentials();
				return "success";
			}
			else {
				return "success";
			}
		} catch (APSException e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
	           facesContext.addMessage(null, m);
		}
		return "failure";
    }

	public void setCompanyAccountList(List<CompanyAccount> companyAccountList) {
		this.companyAccountList = companyAccountList;
	}
	
	public void setStatementList(List<Statement> statementList){
		this.statementList = statementList;
	}
    
}
