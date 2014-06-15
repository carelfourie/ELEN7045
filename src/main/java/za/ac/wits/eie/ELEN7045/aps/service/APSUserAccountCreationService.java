package za.ac.wits.eie.ELEN7045.aps.service;

import javax.ejb.Remote;

import za.ac.wits.eie.ELEN7045.aps.model.APSUser;

@Remote
public interface APSUserAccountCreationService {

	/**
	 * Create APSUser object 
	 * @parameter aPSUser
	 * 
	 */
	void createAccount(APSUser aPSUser);
}
