package za.ac.wits.eie.ELEN7045.aps.concurrency;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;

public class ScrapingSession implements Runnable {
    
    private CompanyAccount account;
    
    @Inject
    private Logger log;
    
    @Inject
    public ScrapingSession(CompanyAccount account) {
        this.account = account;
    }
    
    @Override
    public void run() {
        log.info(String.format("scraping: [%s]", account.getUrl()));
        // now pass this to the "already developed scraper..."
    }
}
