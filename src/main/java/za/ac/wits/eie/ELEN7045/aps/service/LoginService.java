package za.ac.wits.eie.ELEN7045.aps.service;

import java.util.List;

import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;

public interface LoginService {
	
	/**
	 * Load CompanyAccount object for the record that
	 * is return with the same username and password
	 * 
	 * @parameter username
	 * @parameter password
	 * @return CompanyAccount
	 */
	
	List<CompanyAccount> loadAPUserByUsernameAndPassword(String password, String username);

}
