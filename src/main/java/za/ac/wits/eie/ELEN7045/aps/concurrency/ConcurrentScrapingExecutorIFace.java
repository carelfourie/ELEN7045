package za.ac.wits.eie.ELEN7045.aps.concurrency;

import java.util.concurrent.Future;

public interface ConcurrentScrapingExecutorIFace {

	Future<?> submit(ScrapingSession session);

}
