package za.ac.wits.eie.ELEN7045.aps.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.hibernate.criterion.Restrictions;

import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;
import za.ac.wits.eie.ELEN7045.aps.repository.FindByCriteriaRepository;
import za.ac.wits.eie.ELEN7045.aps.service.base.BaseService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;

@Stateless
public class LoginService extends BaseService {

	@Inject
	private FindByCriteriaRepository findByCriteriaRepo;

	public List<CompanyAccount> loadAPSUserAccounts(String password, String username) throws APSException {
		APSUser user = null;

		try {
			user = getAPSUser(password, username);
		} catch (APSException e) {
			throw new APSException(e.getMessage());
		}

		if (user != null) {
			log.info("Loading scraped accounts for " + username);
			return user.getCompanyAccounts();
		} else {
			throw new APSException("Invalid Login");
		}
	}

	private APSUser getAPSUser(String password, String username) throws APSException {
		log.info("Retrieving user with username " + username);
		try {
			Map<String, String> map = new HashMap<String, String>(2);
			map.put("username", username);
			map.put("password", password);

			List<APSUser> users = findByCriteriaRepo.findByCriteria(APSUser.class, Restrictions.allEq(map));

			Map<String, String> msgVal = new LinkedHashMap<String, String>(2);
			msgVal.put("User not found: [%s]", username);
			msgVal.put("Duplicate user found: [%s]", username);

			listCheck(users, msgVal);

			return users.get(0);
		} catch (Exception e) {
			throw new APSException("Invalid Login");
		}
	}
}