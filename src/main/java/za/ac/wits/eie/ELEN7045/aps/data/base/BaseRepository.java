package za.ac.wits.eie.ELEN7045.aps.data.base;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class BaseRepository {
    
    @Inject
    protected EntityManager em;
    
}