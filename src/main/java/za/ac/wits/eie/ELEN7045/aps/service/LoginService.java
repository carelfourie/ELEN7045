package za.ac.wits.eie.ELEN7045.aps.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;
import za.ac.wits.eie.ELEN7045.aps.service.base.BaseService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;
import za.ac.wits.eie.ELEN7045.aps.service.exception.InvalidUserException;

@Stateless
public class LoginService extends BaseService {
	
	/**
     * Load CompanyAccount object for the record that
     * is return with the same username and password
     * 
     * @parameter username
     * @parameter password
     * @return CompanyAccount
     * @throws InvalidUserException 
     */
	public List<CompanyAccount> loadAPSUserAccounts(String password,
			String username) throws InvalidUserException {
		APSUser user = null;
		try {
			user = getAPSUser(password, username);
		} catch (InvalidUserException e) {
			throw new InvalidUserException(e.getMessage());
		}
		
		if(user != null) {
			log.info("Loading scraped accounts for " + username);
			@SuppressWarnings("unchecked")
	        List<CompanyAccount> results = entityManager.createQuery(
			           "SELECT c FROM CompanyAccount c "
			           + "join c.company join c.status join c.apsUser where c.apsUser.password=:password and "
			           + "c.apsUser.username=:username")
			           .setParameter("password", password)
			           .setParameter("username", username)
			           .getResultList();
			return results;
		}
		else{
			throw new InvalidUserException("Invalid Login");
		}
		
	}
	
	/**
	 * Retrieve user
	 * @param password
	 * @param username
	 * @return {@link APSUser}
	 */
	private APSUser getAPSUser(String password, String username) throws APSException {
		log.info("Retrieving user with username " + username);
		try {
			return (APSUser) entityManager.createQuery("SELECT u FROM APSUser u where u.password=:password and "
			           + "u.username=:username")
			           .setParameter("password", password)
			           .setParameter("username", username)
			           .getSingleResult();
			
		} catch (Exception e) {
			throw new APSException("Invalid Login");
		}
	}
}