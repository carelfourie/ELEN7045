package za.ac.wits.eie.ELEN7045.aps.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.ac.wits.eie.ELEN7045.aps.model.statement.CreditCardStatement;
import za.ac.wits.eie.ELEN7045.aps.model.statement.MunicipalityStatement;
import za.ac.wits.eie.ELEN7045.aps.model.statement.TelcoStatement;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeSession;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeSessionMapper;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeUnmarshaller;
import za.ac.wits.eie.ELEN7045.aps.test.base.BaseTest;

@RunWith(Arquillian.class)
public class ProcessScrapeResultTest extends BaseTest{
	
	@Inject 
	private Logger logger;
	
	@Inject
	private ScrapeSessionMapper scrapeSessionMapper;
	
	@Test
	public void parseScrapeResult() {
		assertTrue(testCreditCard());
		assertTrue(testMunicipality());
		assertTrue(testTelco());
	}
	
	private boolean testCreditCard(){
		boolean result = true;
		String exampleFileName = "temp/InputData/creditcard.xml";
		ScrapeSession ss = ScrapeUnmarshaller.domUnmarshaller(exampleFileName);
		assertNotNull(ss);
		
		CreditCardStatement ccs = new CreditCardStatement();
		
		try {
			scrapeSessionMapper.map(ss, ccs);
			logger.info(">>> TEST >>> Scraped: " + ccs.toString());
		} catch(Exception e) {
			logger.error(e);
			result = false;
		}
		return result;
	}
	
	private boolean testMunicipality(){
		boolean result = true;
		String exampleFileName = "temp/InputData/municipality.xml";
		ScrapeSession ss = ScrapeUnmarshaller.domUnmarshaller(exampleFileName);
		assertNotNull(ss);
		
		MunicipalityStatement ccs = new MunicipalityStatement();
		
		try {
			scrapeSessionMapper.map(ss, ccs);
			logger.info(">>> TEST >>> Scraped: " + ccs.toString());
		} catch(Exception e) {
			logger.error(e);
			result = false;
		}
		return result;
	}

	private boolean testTelco(){
		boolean result = true;
		String exampleFileName = "temp/InputData/telco.xml";
		ScrapeSession ss = ScrapeUnmarshaller.domUnmarshaller(exampleFileName);
		assertNotNull(ss);
		
		TelcoStatement ccs = new TelcoStatement();
		
		try {
			scrapeSessionMapper.map(ss, ccs);
			logger.info(">>> TEST >>> Scraped: " + ccs.toString());
		} catch(Exception e) {
			logger.error(e);
			result = false;
		}
		return result;
	}

}