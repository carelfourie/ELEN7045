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
import za.ac.wits.eie.ELEN7045.aps.service.LoginService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;
import za.ac.wits.eie.ELEN7045.aps.service.exception.InvalidUserException;

@Model
public class Login {

	@Produces
    @Named
	private Credentials credentials;
	
	@Inject
    private FacesContext facesContext;
	
	@Inject
    private LoginService loginService;
	
	@Inject
    private Logger log;
    
    private List<CompanyAccount> companyAccountList = new ArrayList<CompanyAccount>();
    		
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
    	
    	 List<CompanyAccount> results;
		try {
			log.info("login to get scraped accounts for ........ "+credentials.getUsername());
			results = loginService.loadAPSUserAccounts(credentials.getPassword(), credentials.getUsername());
			if( results.size() != 0) {
				setCompanyAccountList(results);
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

	@Produces
    @Named
	public List<CompanyAccount> getCompanyAccountList() {
		return companyAccountList;
	}

	public void setCompanyAccountList(List<CompanyAccount> companyAccountList) {
		this.companyAccountList = companyAccountList;
	}
    
}
