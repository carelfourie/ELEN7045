package za.ac.wits.eie.ELEN7045.aps.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.hibernate.criterion.Restrictions;
import org.hibernate.jpa.criteria.CriteriaBuilderImpl;

import za.ac.wits.eie.ELEN7045.aps.controller.ScraperInfo;
import za.ac.wits.eie.ELEN7045.aps.data.FindByCriteriaRepository;
import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;
import za.ac.wits.eie.ELEN7045.aps.model.statement.CreditCardStatement;
import za.ac.wits.eie.ELEN7045.aps.model.statement.TelcoStatement;
import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeSession;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeSessionMapper;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeUnmarshaller;
import za.ac.wits.eie.ELEN7045.aps.service.base.BaseService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;

@Stateless
public class LoginService extends BaseService {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION, unitName = "primary")
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
	private APSUser getAPSUser(String password, String username)
			throws APSException {
		log.info("Retrieving user with username " + username);
		try {
			Map<String, String> map = new HashMap<String, String>(2);
			map.put("username", username);
			map.put("password", password);

			List<APSUser> users = findByCriteriaRepo.findByCriteria(
					APSUser.class, Restrictions.allEq(map));
			if (users.size() < 1) {
				throw new APSException(String.format("User not found: [%s]",
						username));
			}

			if (users.size() > 1) {
				throw new APSException(String.format(
						"Duplicate user found: [%s]", username));
			}

			return users.get(0);

			/*
			 * return (APSUser) entityManager.createQuery(
			 * "SELECT u FROM APSUser u where u.password=:password and " +
			 * "u.username=:username") .setParameter("password", password)
			 * .setParameter("username", username) .getSingleResult();
			 */
		} catch (Exception e) {
			throw new APSException("Invalid Login");
		}
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
	@Deprecated
	public List<CompanyAccount> loadAPSUserAccounts(String password,
			String username) throws APSException {
		APSUser user = null;

		try {
			user = getAPSUser(password, username);
		} catch (APSException e) {
			throw new APSException(e.getMessage());
		}

		if (user != null) {
			log.info("Loading scraped accounts for " + username);
			@SuppressWarnings("unchecked")
			List<CompanyAccount> results = entityManager
					.createQuery(
							"SELECT c FROM CompanyAccount c "
									+ "join c.company join c.status join c.apsUser where c.apsUser.password=:password and "
									+ "c.apsUser.username=:username")
					.setParameter("password", password)
					.setParameter("username", username).getResultList();
			return results;
		} else {
			throw new APSException("Invalid Login");
		}

	}

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
}