package za.ac.wits.eie.ELEN7045.aps.scrape;



import javax.inject.Inject;

import org.jboss.logging.Logger;

import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;

public abstract class ScrapeSessionMapper {

	@Inject
	private static Logger log;

	public static void map(ScrapeSession scrapeSession,
			Statement statement) throws Exception {

		//TODO: Cast ScrapeSessionInfo object to extending class.
		statement.setBaseUrl(scrapeSession.getBaseurl());
		statement.setDate(scrapeSession.getDate());
		statement.setTime(scrapeSession.getTime());
		statement.setReturnCode(scrapeSession.getReturncode());

		for (Datapair datapair : scrapeSession.getDatapairs()) {
			try {

				ScrapeSessionData ssd = ScrapeSessionData
						.getScrapeSessionData(datapair.getText());

				//TODO: Complete setters
				log.info(String.format(">>> SCRAPE-SESSION-MAPPER: %s = '%s'",
						datapair.getText(), datapair.getValue()));
				if (ssd == null) {
					continue;
				}
				log.info(String.format(">>> SCRAPE-SESSION-MAPPER: Will call %s(\"%s\")",
						ssd.getSetterMethodName(), datapair.getValue()));
			} catch (NullPointerException npe) {
			}
		}
	}
}
