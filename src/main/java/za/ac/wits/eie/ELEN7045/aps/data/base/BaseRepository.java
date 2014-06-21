package za.ac.wits.eie.ELEN7045.aps.data.base;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public abstract class BaseRepository {
    
    @Produces
    @PersistenceContext(type = PersistenceContextType.TRANSACTION, unitName = "primary")
    protected EntityManager em;
    
}