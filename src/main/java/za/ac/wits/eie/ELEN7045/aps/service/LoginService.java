package za.ac.wits.eie.ELEN7045.aps.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.hibernate.criterion.Restrictions;

import za.ac.wits.eie.ELEN7045.aps.data.FindByCriteriaRepository;
import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;
import za.ac.wits.eie.ELEN7045.aps.service.base.BaseService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;

@Stateless
public class LoginService extends BaseService {

    @Inject
    private FindByCriteriaRepository findByCriteriaRepo;

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
        
        Map<String, String> msgVal = new LinkedHashMap<String, String>(2);
        msgVal.put("User not found: [%s]", username);
        msgVal.put("Duplicate user found: [%s]", username);
       
        listCheck(users, msgVal);
        
        //if (users.size() < 1) {
        //    throw new APSException(String.format("User not found: [%s]", username));
        //}
        //if (users.size() > 1) {
        //    throw new APSException(String.format("Duplicate user found: [%s]", username));
        //}

        return users.get(0);
    }

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
}