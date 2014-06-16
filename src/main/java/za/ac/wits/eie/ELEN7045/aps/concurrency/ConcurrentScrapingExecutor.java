package za.ac.wits.eie.ELEN7045.aps.concurrency;

import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Named;

@Named
public class ConcurrentScrapingExecutor {
    
    /**
     * Container managed thread pool.
     * 5 core threads, 25 max.
     */
    @Resource(name = "java:jboss/ee/concurrency/executor/default")
    private ManagedExecutorService managedExecutorService;
    
    public Future<?> submit(ScrapingSession session) {
        return managedExecutorService.submit(session);
    }
}
