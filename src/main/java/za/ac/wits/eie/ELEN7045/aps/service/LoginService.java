package za.ac.wits.eie.ELEN7045.aps.service;

import java.util.List;

import javax.ejb.Local;

import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;

@Local
public interface LoginService {
	
	/**
	 * Load CompanyAccount object for the record that
	 * is return with the same username and password
	 * 
	 * @parameter username
	 * @parameter password
	 * @return CompanyAccount
	 * @throws InvalidUserException 
	 */
	
	List<CompanyAccount> loadAPSUserAccounts(String password, String username) throws InvalidUserException;

}
