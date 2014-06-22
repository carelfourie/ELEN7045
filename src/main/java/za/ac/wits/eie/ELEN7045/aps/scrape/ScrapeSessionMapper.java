package za.ac.wits.eie.ELEN7045.aps.scrape;

import java.lang.reflect.Method;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import za.ac.wits.eie.ELEN7045.aps.model.statement.CreditCardStatement;
import za.ac.wits.eie.ELEN7045.aps.model.statement.MunicipalityStatement;
import za.ac.wits.eie.ELEN7045.aps.model.statement.TelcoStatement;
import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;

@Stateless
public class ScrapeSessionMapper {

	@Inject
	private Logger log;


	public void map(ScrapeSession scrapeSession,
			Statement statement) throws Exception {
		statement.setBaseUrl(scrapeSession.getBaseurl());
		statement.setDate(scrapeSession.getDate());
		statement.setTime(scrapeSession.getTime());
		statement.setReturnCode(scrapeSession.getReturncode());

		for (Datapair datapair : scrapeSession.getDatapairs()) {
			try {

				String methodName = AttributeTranslator.translate("set", datapair.getText());
				if(methodName == null){
					continue;
				}
				log.debug(String.format(">>>> SCRAPE-SESSION-MAPPER >>>> %s(%s)", methodName, datapair.getValue()));
				invoke(statement, methodName, datapair.getValue());
			} catch (NullPointerException npe) {
				log.error("Error mapping field: " + npe.getMessage());
			}
		}
	}
	
	private Object invoke(Statement statement, String methodName, Object parameter) throws Exception{
		Class<?> c = statement.getClass();
		Method m = c.getMethod(methodName, parameter.getClass());
		return m.invoke(statement, parameter);
	}
}