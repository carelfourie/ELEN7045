package za.ac.wits.eie.ELEN7045.aps.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.hibernate.criterion.Restrictions;

import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;
import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;
import za.ac.wits.eie.ELEN7045.aps.repository.FindByCriteriaRepository;
import za.ac.wits.eie.ELEN7045.aps.service.base.BaseService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;

@Stateless
public class StatementService extends BaseService {

	@Inject
	private FindByCriteriaRepository findByCriteriaRepo;

	/**
	 * Load Statement object for the record that is return with the account
	 * number
	 * 
	 * @parameter accountNumber
	 * @parameter password
	 * @return CompanyAccount
	 * @throws APSException
	 */
	public List<Statement> loadAccountStatement(String accountNumber) throws APSException {
		CompanyAccount companyAccount = getCompanyAccount(accountNumber);
		log.info("Loading account statements for " + companyAccount.getAccountNumber());
		Statement statement = companyAccount.getStatement();
		log.info("statement for " + statement);
		List<Statement> list = new ArrayList<Statement>();
		list.add(statement);
		return list;
	}

	/**
	 * Retrieve Company Account
	 * 
	 * @param accountNumber
	 * @return {@link CompanyAccount}
	 */
	private CompanyAccount getCompanyAccount(String accountNumber) throws APSException {
		log.info("Retrieving statement for account number " + accountNumber);

		Map<String, String> map = new HashMap<String, String>(1);
		map.put("accountNumber", accountNumber);
		List<CompanyAccount> companyAccounts = findByCriteriaRepo.findByCriteria(CompanyAccount.class, Restrictions.allEq(map));
		if (companyAccounts.size() < 1) {
			throw new APSException(String.format("Company Accounts not found: [%s]", accountNumber));
		}
		return companyAccounts.get(0);
	}
}
