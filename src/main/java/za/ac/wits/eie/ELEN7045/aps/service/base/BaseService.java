package za.ac.wits.eie.ELEN7045.aps.service.base;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

public abstract class BaseService {
    
    @Inject
    protected EntityManager entityManager;

    @Inject
    protected Logger log;

}
