package za.ac.wits.eie.ELEN7045.aps.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import za.ac.wits.eie.ELEN7045.aps.dto.CredentialsDTO;
import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;
import za.ac.wits.eie.ELEN7045.aps.service.LoginService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;

@Model
public class Login {

	private List<CompanyAccount> companyAccountList = new ArrayList<CompanyAccount>();

	@Produces
	@Named
	private CredentialsDTO credentials;

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

	@PostConstruct
	public void initCredentials() {
		credentials = new CredentialsDTO();
	}

	/**
	 * Login a user to retrieve scraped accounts
	 * 
	 * @return
	 * @throws APSException
	 */
	public String login() throws APSException {

		List<CompanyAccount> results;
		try {
			log.info("login to get scraped accounts for ........ " + credentials.getUsername());
			results = loginService.loadAPSUserAccounts(credentials.getPassword(), credentials.getUsername());
			log.info("account size ........ " + results.size());
			if (results.size() != 0) {
				setCompanyAccountList(results);
				new ListDataModel<CompanyAccount>(results);
				initCredentials();
				return "success";
			} else {
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

}
