package za.ac.wits.eie.ELEN7045.aps.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.ac.wits.eie.ELEN7045.aps.dto.ScrapeResultDTO;
import za.ac.wits.eie.ELEN7045.aps.factory.StatementFactory;
import za.ac.wits.eie.ELEN7045.aps.model.statement.MunicipalityStatement;
import za.ac.wits.eie.ELEN7045.aps.model.statement.TelcoStatement;
import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeResultMapper;
import za.ac.wits.eie.ELEN7045.aps.scrape.ScrapeUnmarshaller;
import za.ac.wits.eie.ELEN7045.aps.test.base.BaseTest;

@RunWith(Arquillian.class)
public class ProcessScrapeResultTest extends BaseTest {

	@Inject
	private Logger logger;

	@Inject
	private ScrapeResultMapper scrapeResultMapper;

	@Test
	public void parseScrapeResult() {
		assertTrue(testCreditCard());
		assertTrue(testMunicipality());
		assertTrue(testTelco());
	}

	private boolean testCreditCard() {
		boolean result = true;
		String exampleFileName = "temp/InputData/creditcard.xml";
		ScrapeResultDTO scrapeResult = ScrapeUnmarshaller.domUnmarshaller(exampleFileName);
		assertNotNull(scrapeResult);

		Statement creditCardStatement = StatementFactory.createCreditCardStatement();

		try {
			scrapeResultMapper.map(scrapeResult, creditCardStatement);
			logger.info(">>> TEST >>> Scraped: " + creditCardStatement.toString());
		} catch (Exception e) {
			logger.error(e);
			result = false;
		}
		return result;
	}

	private boolean testMunicipality() {
		boolean result = true;
		String exampleFileName = "temp/InputData/municipality.xml";
		ScrapeResultDTO scrapeResult = ScrapeUnmarshaller.domUnmarshaller(exampleFileName);
		assertNotNull(scrapeResult);

		Statement municipleStatement = StatementFactory.createMunicipalityStatement();

		try {
			scrapeResultMapper.map(scrapeResult, municipleStatement);
			logger.info(">>> TEST >>> Scraped: " + municipleStatement.toString());
		} catch (Exception e) {
			logger.error(e);
			result = false;
		}
		return result;
	}

	private boolean testTelco() {
		boolean result = true;
		String exampleFileName = "temp/InputData/telco.xml";
		ScrapeResultDTO scrapeResult = ScrapeUnmarshaller.domUnmarshaller(exampleFileName);
		assertNotNull(scrapeResult);

		Statement telcoStatement = StatementFactory.createTelcoStatement();

		try {
			scrapeResultMapper.map(scrapeResult, telcoStatement);
			logger.info(">>> TEST >>> Scraped: " + telcoStatement.toString());
		} catch (Exception e) {
			logger.error(e);
			result = false;
		}
		return result;
	}

}