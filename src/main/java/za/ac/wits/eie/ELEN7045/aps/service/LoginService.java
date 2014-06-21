package za.ac.wits.eie.ELEN7045.aps.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.hibernate.criterion.Restrictions;

import za.ac.wits.eie.ELEN7045.aps.data.FindByCriteriaRepository;
import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;
import za.ac.wits.eie.ELEN7045.aps.service.base.BaseService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;

@Stateless
public class LoginService extends BaseService {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION, unitName = "primary")
    protected EntityManager entityManager;

    @Inject
    private FindByCriteriaRepository findByCriteriaRepo;

    /**
     * Load CompanyAccount object for the record that is return with the same username and password
     * 
     * @parameter username
     * @parameter password
     * @return CompanyAccount
     * @throws APSException
     */
    public List<CompanyAccount> loadAPSUserAccounts(String password, String username) throws APSException {
        APSUser user = getAPSUser(password, username);
        log.info("Loading scraped accounts for " + user.getUsername());
        return user.getCompanyAccounts();
    }

    /**
     * Retrieve APS User
     * 
     * @param password
     * @param username
     * @return {@link APSUser}
     */
    private APSUser getAPSUser(String password, String username) throws APSException {
        log.info("Retrieving user with username " + username);

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
    }
}