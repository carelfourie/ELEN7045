package za.ac.wits.eie.ELEN7045.aps.resource;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.jboss.logging.Logger;

public class Producer {
    
    /**
     * Container managed thread pool.
     * 5 core threads, 25 max.
     */
    @Produces
    @Resource(name = "java:jboss/ee/concurrency/executor/default")
    private ManagedExecutorService managedExecutorService;

    @Produces
    @PersistenceContext(type = PersistenceContextType.TRANSACTION, unitName = "primary")
    protected EntityManager em;
    
    @Produces
    @RequestScoped
    public FacesContext produceFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    @Produces
    public Logger produceLog(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
