package za.ac.wits.eie.ELEN7045.aps.service;

import java.util.ArrayList;
import java.util.List;

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
		Statement statement = companyAccount.getStatement();
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
		List<CompanyAccount> companyAccounts = findByCriteriaRepo.findByCriteria(CompanyAccount.class, Restrictions.eq("accountNumber", accountNumber));
		if (companyAccounts.size() < 1) {
			throw new APSException(String.format("Company Account number not found: [%s]", accountNumber));
		}
		log.info(String.format("loaded account statements for: [%s]", accountNumber));
		return companyAccounts.get(0);
	}
}
