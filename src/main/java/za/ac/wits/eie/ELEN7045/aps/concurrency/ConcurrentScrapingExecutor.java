package za.ac.wits.eie.ELEN7045.aps.concurrency;

import java.util.concurrent.Future;

import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ConcurrentScrapingExecutor implements ConcurrentScrapingExecutorIFace {

	@Inject
	private ManagedExecutorService managedExecutorService;

	@Override
	public Future<?> submit(ScrapingSession session) {
		return managedExecutorService.submit(session);
	}
}
