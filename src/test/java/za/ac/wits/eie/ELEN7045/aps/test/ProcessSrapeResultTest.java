package za.ac.wits.eie.ELEN7045.aps.test;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logging.Logger;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import za.ac.wits.eie.ELEN7045.aps.scrape.CreditCardScrape;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeSession;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeSessionMapper;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeUnmarshaller;
import za.ac.wits.eie.ELEN7045.aps.test.base.BaseTest;

@RunWith(Arquillian.class)
public class ProcessSrapeResultTest extends BaseTest{

	@Inject
	Logger log;

	@Test
	public void parseScrapeResult() {
		String exampleFileName = "temp/input/creditcard_softbank_20140601.xml";
		ScrapeSession ss = ScrapeUnmarshaller.domUnmarshaller(exampleFileName);
		assertNotNull(ss);

		CreditCardScrape ccs = new CreditCardScrape();
		try {
			ScrapeSessionMapper.map(ss, ccs);
		} catch (Exception e) {
			log.error(e);
			assertTrue(false);
		}
		log.info(">>> TEST >>> Scraped: " + ccs.toString());
	}
}
