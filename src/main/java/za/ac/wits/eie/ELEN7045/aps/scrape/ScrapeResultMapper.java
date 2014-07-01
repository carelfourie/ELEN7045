package za.ac.wits.eie.ELEN7045.aps.scrape;

import java.lang.reflect.Method;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import za.ac.wits.eie.ELEN7045.aps.dto.ScrapeResultDTO;
import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;

@Stateless
public class ScrapeResultMapper {

	@Inject
	private Logger log;

	private Object invoke(Statement statement, String methodName, Object parameter) throws Exception {
		Class<?> cls = statement.getClass();
		Method method = cls.getMethod(methodName, parameter.getClass());
		return method.invoke(statement, parameter);
	}

	public void map(ScrapeResultDTO scrapeResult, Statement statement) throws Exception {
		statement.setBaseUrl(scrapeResult.getBaseurl());
		statement.setDate(scrapeResult.getDate());
		statement.setTime(scrapeResult.getTime());
		statement.setReturnCode(scrapeResult.getReturncode());

		for (Datapair datapair : scrapeResult.getDatapairs()) {
			try {
				String methodName = AttributeTranslator.translate("set", datapair.getText());
				if (methodName == null) {
					continue;
				}
				log.debug(String.format(">>>> SCRAPE-SESSION-MAPPER >>>> %s(%s)", methodName, datapair.getValue()));
				invoke(statement, methodName, datapair.getValue());
			} catch (NullPointerException npe) {
				log.error("Error mapping field: " + npe.getMessage());
			} catch (Exception e) {
				log.error(e);
			}
		}
	}
}
