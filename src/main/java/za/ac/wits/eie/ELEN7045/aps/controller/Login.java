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

import za.ac.wits.eie.ELEN7045.aps.exceptions.InvalidUserException;
import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;
import za.ac.wits.eie.ELEN7045.aps.service.APSUserAccountService;
import za.ac.wits.eie.ELEN7045.aps.service.LoginService;

@Model
public class Login {

	@Produces
    @Named
	private Credentials credentials;
	
	@Produces
    @Named
	private Account account;
	
	@Inject
    private FacesContext facesContext;
	
	@Inject
    private LoginService loginService;

	@Inject
	APSUserAccountService aPSUserAccountCreationService;
	
	private boolean register;
	
	private boolean validLogin;
    
    private List<CompanyAccount> companyAccountList = new ArrayList<CompanyAccount>();
    		
    @PostConstruct
    public void initCredentials() {
    	credentials = new Credentials();
    	account = new Account();
    }
        
    public void login() {
    	
    	 List<CompanyAccount> results;
		try {
			results = loginService.loadAPSUserAccounts(credentials.getPassword(), credentials.getUsername());
			if( !results.isEmpty()) {
				setCompanyAccountList(results);
				initCredentials();
			}
			else {
				validLogin = true;
			}
		} catch (InvalidUserException e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
	           facesContext.addMessage(null, m);
		}
    }
    
    public void createAccount() {
        //logic to create account
    	APSUser aPSUser = new APSUser();
    	if(account.getUsername() != null && (account.getPassword1().equals(account.getPassword1()))) {
    		aPSUser.setPassword(account.getPassword1());
        	aPSUser.setUsername(account.getUsername());
        	aPSUser.setCompanyAccounts(null);
        	aPSUserAccountCreationService.createAccount(aPSUser);
    	}
    	else{
    		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Can't create account!", "Can't create account");
            facesContext.addMessage(null, m);
    	}
    	
    }
    
    public void scrape() {
        //logic to create account
    }
    
    public boolean isAboutToScrape() {
    	for(CompanyAccount ca : companyAccountList) {
    		if(ca.getApsUser() != null) {
    			if(ca.getApsUser().getUsername() != null) {
    				return true;
    			}
    		}
    	}
    	if(validLogin)
    		return true;
        return false;
    }
    
    public void registerAccount() {
        setRegister(true);
    }
    
    public boolean isLoggedIn() {
    	if(!companyAccountList.isEmpty() && !isRegister()) {
    		return true;
    	} else if(companyAccountList.isEmpty() && !isRegister()) {
    		return false;
    	}else if(companyAccountList.isEmpty() && isRegister()) {
    		return true;
    	}else if(validLogin) {
    		return true;
    	}
       return false; 
    }

    public boolean isRegister() {
		return register;
	}

	public void setRegister(boolean register) {
		this.register = register;
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
