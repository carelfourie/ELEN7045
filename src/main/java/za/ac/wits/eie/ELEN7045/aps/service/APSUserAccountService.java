package za.ac.wits.eie.ELEN7045.aps.service;

import javax.ejb.Local;

import za.ac.wits.eie.ELEN7045.aps.model.APSUser;

@Local
public interface APSUserAccountCreationService {

	/**
	 * Create APSUser object 
	 * @parameter aPSUser
	 * 
	 */
	void createAccount(APSUser aPSUser);
}
