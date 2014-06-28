package za.ac.wits.eie.ELEN7045.aps.concurrency;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;

public class ScrapingSession implements Runnable {

	private CompanyAccount companyAccount;

	@Inject
	private Logger log;

	@Inject
	public ScrapingSession(CompanyAccount companyAccount) {
		this.companyAccount = companyAccount;
	}

	public CompanyAccount getCompanyAccount() {
		return companyAccount;
	}

	@Override
	public void run() {
		log.info(String.format("scraping: [%s]", companyAccount.getUrl()));
		// now pass companyAccount this to the scraper...
	}
}
