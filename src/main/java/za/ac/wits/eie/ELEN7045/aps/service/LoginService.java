package za.ac.wits.eie.ELEN7045.aps.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.criterion.Restrictions;

import za.ac.wits.eie.ELEN7045.aps.controller.ScraperInfo;
import za.ac.wits.eie.ELEN7045.aps.data.FindByCriteriaRepository;
import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;
import za.ac.wits.eie.ELEN7045.aps.model.statement.CreditCardStatement;
import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeSession;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeSessionMapper;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeUnmarshaller;
import za.ac.wits.eie.ELEN7045.aps.service.base.BaseService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;

@Stateless
public class LoginService extends BaseService {

	@Inject
	protected EntityManager entityManager;

	@Inject
	private FindByCriteriaRepository findByCriteriaRepo;

	@Inject
	private ScrapeSessionMapper scrapeSessionMapper;

	/**
	 * Retrieve user
	 * 
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
			
			Map<String, String> msgVal = new LinkedHashMap<String, String>(2);
	        msgVal.put("User not found: [%s]", username);
	        msgVal.put("Duplicate user found: [%s]", username);
	       
	        listCheck(users, msgVal);

			return users.get(0);
		} catch (Exception e) {
			throw new APSException("Invalid Login");
		}
	}

	@Deprecated
	public List<Statement> loadAccountStatements(String password,
			String username) throws APSException {
		APSUser user = null;
		List<Statement> statements = new ArrayList<Statement>();
		try {
			user = getAPSUser(password, username);
		} catch (APSException e) {
			throw new APSException(e.getMessage());
		}

		if (user != null) {

			@SuppressWarnings("unchecked")
			List<ScraperInfo> scraperInfoList = entityManager
					.createQuery(
							"select s from ScraperInfo s where apsUser_id=:id")
					.setParameter("id", user.getId()).getResultList();
			try {
				log.info(">>>>> scraperInfoList size = " + scraperInfoList.size());

				for (ScraperInfo si : scraperInfoList) {
					log.info(">>>> XmlResultFile = " + si.getXmlResultFile());

					ScrapeSession ss = ScrapeUnmarshaller.domUnmarshaller(si
							.getXmlResultFile());

					CreditCardStatement statement = new CreditCardStatement();
					
					

					try {
						scrapeSessionMapper.map(ss, statement);
						statements.add(statement);
					} catch (Exception e) {
						log.error("[-1] ScrapeSession error", e);
					}
				}
			} catch (Exception e) {
				log.error("[-2] ScraperInfo error", e);
			}
		} else {
		}
		return statements;
	}

	/**
	 * Load CompanyAccount object for the record that is return with the same
	 * username and password
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

		if (user != null) {
			log.info("Loading scraped accounts for " + username);
			return user.getCompanyAccounts();			
		} else {
			throw new APSException("Invalid Login");
		}
	}
}