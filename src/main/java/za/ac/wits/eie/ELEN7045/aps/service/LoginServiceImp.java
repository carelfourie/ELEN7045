package za.ac.wits.eie.ELEN7045.aps.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import za.ac.wits.eie.ELEN7045.aps.exceptions.InvalidUserException;
import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;

@Stateless
public class LoginServiceImp implements LoginService{

	@Inject
    private Logger log;
	
	@PersistenceContext EntityManager userDatabase;
	
	@Override
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
	        List<CompanyAccount> results = userDatabase.createQuery(
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
	
	private APSUser getAPSUser(String password, String username) throws InvalidUserException {
		try {
			return (APSUser) userDatabase.createQuery("SELECT u FROM APSUser u where u.password=:password and "
			           + "u.username=:username")
			           .setParameter("password", password)
			           .setParameter("username", username)
			           .getSingleResult();
			
		} catch (Exception e) {
			throw new InvalidUserException("Invalid Login");
		}
		
	}
}