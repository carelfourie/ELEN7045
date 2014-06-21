package za.ac.wits.eie.ELEN7045.aps.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.criterion.Restrictions;

import za.ac.wits.eie.ELEN7045.aps.data.FindByCriteriaRepository;
import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;
import za.ac.wits.eie.ELEN7045.aps.service.base.BaseService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;

@Stateless
public class LoginService extends BaseService {
    
    @Inject
    protected EntityManager entityManager;

    @Inject
    private FindByCriteriaRepository findByCriteriaRepo;
    
    
	/**
     * Load CompanyAccount object for the record that
     * is return with the same username and password
     * 
     * @parameter username
     * @parameter password
     * @return CompanyAccount
     * @throws APSException 
     */
	public List<CompanyAccount> loadAPSUserAccounts(String password, String username) throws APSException {
		APSUser user = null;
		
		try {
			user = getAPSUser(password, username);
		} catch (APSException e) {
			throw new APSException(e.getMessage());
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
			throw new APSException("Invalid Login");
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
		    Map<String, String> map = new HashMap<String, String>(2);
            map.put("username", username);
            map.put("password", password);

            List<APSUser> users = findByCriteriaRepo.findByCriteria(APSUser.class, Restrictions.allEq(map));
            if (users.size() < 1) {
                throw new APSException(String.format("User not found: [%s]", username));
            }

            if (users.size() > 1) {
                throw new APSException(String.format("Duplicate user found: [%s]", username));
            }
            
            return users.get(0);
            
            
		    /*
			return (APSUser) entityManager.createQuery("SELECT u FROM APSUser u where u.password=:password and "
			           + "u.username=:username")
			           .setParameter("password", password)
			           .setParameter("username", username)
			           .getSingleResult();
			
			
			*/
		} catch (Exception e) {
			throw new APSException("Invalid Login");
		}
	}
}