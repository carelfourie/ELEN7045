package za.ac.wits.eie.ELEN7045.aps.test;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.ac.wits.eie.ELEN7045.aps.model.statement.CreditCardStatement;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeSession;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeSessionMapper;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeUnmarshaller;
import za.ac.wits.eie.ELEN7045.aps.test.base.BaseTest;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class ProcessScrapeResultTest extends BaseTest{
	
	@Inject 
	Logger logger;
	
	@Test
	public void parseScrapeResult() {
		String exampleFileName = "temp/InputData/creditcard.xml";
		ScrapeSession ss = ScrapeUnmarshaller.domUnmarshaller(exampleFileName);
		assertNotNull(ss);
		
		CreditCardStatement ccs = new CreditCardStatement();
		
		try {
			ScrapeSessionMapper.map(ss, ccs);
		} catch(Exception e) {
			logger.error(e);
			assertTrue(false);
		}
		logger.info(">>> TEST >>> Scraped: " + ccs.toString());
	}
	
}
