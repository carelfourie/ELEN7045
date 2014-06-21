package za.ac.wits.eie.ELEN7045.aps.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

@Model
public class Scraper {

	@Inject
    private Logger log;
	
	@Produces
    @Named
	private ScraperInfo scraperInfo;
	
	@PostConstruct
    public void initScraperInfo() {
		scraperInfo = new ScraperInfo();
    }
	
	public void scrape() {
        //logic to scrape account
		log.info("In the scraper logic ------------- bean");
    }
}
