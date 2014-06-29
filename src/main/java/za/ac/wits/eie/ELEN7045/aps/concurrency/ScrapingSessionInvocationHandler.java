package za.ac.wits.eie.ELEN7045.aps.concurrency;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

import javax.inject.Inject;

import za.ac.wits.eie.ELEN7045.aps.model.ScrapingEventAuditLog;
import za.ac.wits.eie.ELEN7045.aps.repository.SaveRepository;

public class ScrapingSessionInvocationHandler implements InvocationHandler {

	private Object concurrentScrapingExecutor;

	@Inject
	private SaveRepository saveRepository;

	public ScrapingSessionInvocationHandler(Object concurrentScrapingExecutor) {
		this.concurrentScrapingExecutor = concurrentScrapingExecutor;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// log the scrape
		ScrapingSession scrapingSession = (ScrapingSession) args[0];
		ScrapingEventAuditLog eventLog = new ScrapingEventAuditLog();

		eventLog.setApsUser(scrapingSession.getCompanyAccount().getApsUser());
		eventLog.setCompany(scrapingSession.getCompanyAccount().getCompany());
		eventLog.setReturnCode(null);
		eventLog.setScrapeDate(new Date());

		// save
		saveRepository.save(eventLog);

		// invoke the method
		return method.invoke(concurrentScrapingExecutor, args);
	}
}
