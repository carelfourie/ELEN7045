package za.ac.wits.eie.ELEN7045.aps.concurrency;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class ScrapingSessionInvocationHandler implements InvocationHandler {
	private Object scrapingSession;

	public ScrapingSessionInvocationHandler(Object scrapingSession) {
	   this.scrapingSession = scrapingSession;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	  //log the scrape
	   return method.invoke(scrapingSession, args);
	}
}

