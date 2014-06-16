package za.ac.wits.eie.ELEN7045.aps.concurrency;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Named;

@Named
public class ScrapingSessionRunner {
    
    @Resource(name = "java:jboss/ee/concurrency/executor/default")
    private ManagedExecutorService managedExecutorService;
    
    public void submit(ScrapingSession session) {
        managedExecutorService.submit(session);
    }
}
