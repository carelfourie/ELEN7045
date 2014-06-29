package za.ac.wits.eie.ELEN7045.aps.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.service.APSUserAccountService;

@Model
public class AccountController {

	@Produces
	@Named
	private AccountInfo accountInfo;

	@Inject
	APSUserAccountService aPSUserAccountService;

	@Inject
	private FacesContext facesContext;

	@Inject
	private Logger log;

	/**
	 * Create account for user
	 * 
	 * @return
	 */
	public String createAccount() {
		// logic to create account
		log.info("Creating account for user:  " + accountInfo.getUsername());
		APSUser aPSUser = new APSUser();
		if ((accountInfo.getUsername() != null) && (accountInfo.getPassword1().equals(accountInfo.getPassword2()))) {
			aPSUser.setPassword(accountInfo.getPassword1());
			aPSUser.setUsername(accountInfo.getUsername());
			aPSUser.setCompanyAccounts(null);
			aPSUserAccountService.createAccount(aPSUser);
		} else {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Can't create account!", "Can't create account");
			facesContext.addMessage(null, m);
		}
		return "success";
	}

	@PostConstruct
	public void initCredentials() {
		accountInfo = new AccountInfo();
	}
}
