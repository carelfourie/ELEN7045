package za.ac.wits.eie.ELEN7045.aps.controller;

import java.util.ArrayList;
import java.util.List;














import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;
import za.ac.wits.eie.ELEN7045.aps.model.Member;
import za.ac.wits.eie.ELEN7045.aps.service.LoginService;

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
        
    public void login() {
    	
    	 List<CompanyAccount> results = loginService.loadAPUserByUsernameAndPassword(credentials.getPassword(), credentials.getUsername());
        if ( !results.isEmpty() ) {
        	setCompanyAccountList(results);   
           FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login successful!", "Login successful");
           facesContext.addMessage(null, m);
           initCredentials();
        }
        else {
        	FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login unsuccessful!", "Login unsuccessful");
            facesContext.addMessage(null, m);
        }
    }
    
    public void createAccount() {
        //logic to create account
    }
    
    public void scrape() {
        //logic to create account
    }
    
    public boolean isLoggedIn() {
       return !companyAccountList.isEmpty();
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
