package za.ac.wits.eie.ELEN7045.aps.concurrency;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import za.ac.wits.eie.ELEN7045.aps.model.ScrapingEvent;

public class ScrapingSession implements Runnable {
    
    @Inject
    private Logger log;

    //private ScrapingEvent event;

    public ScrapingSession(ScrapingEvent event) {
        //this.event = event;
    }
    
    @Override
    public void run() {
        log.info("run...");
    }
}
