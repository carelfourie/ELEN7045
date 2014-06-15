package za.ac.wits.eie.ELEN7045.aps.service;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;

public class LoginServiceImp implements LoginService{

	@Inject
    private Logger log;
	
	@PersistenceContext EntityManager userDatabase;
	
	@Override
	public List<CompanyAccount> loadAPUserByUsernameAndPassword(String password,
			String username) {
		log.info("Loading scraped accounts for " + username);
		List<CompanyAccount> results = userDatabase.createQuery(
		           "SELECT c FROM CompanyAccount c "
		           + "join c.company join c.status join c.apsUser where c.apsUser.password=:password and "
		           + "c.apsUser.username=:username")
		           .setParameter("password", password)
		           .setParameter("username", username)
		           .getResultList();
		return results;
	}
}