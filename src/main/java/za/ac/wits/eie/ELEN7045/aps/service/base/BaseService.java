package za.ac.wits.eie.ELEN7045.aps.service.base;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;

public abstract class BaseService {
    
    @Inject
    protected Logger log;
    
    protected void listCheck(List<?> list,  Map<String, String> msgVal) throws APSException {
        if (list == null) {
            throw new APSException("List cannot be null.");
        }
       
        String[] keys = msgVal.keySet().toArray(new String[msgVal.keySet().size()]);
        
        if (list.size() < 1) {
            throw new APSException(String.format(keys[0], msgVal.get(keys[0])));
        }

        if (list.size() > 1) {
            throw new APSException(String.format(keys[1], msgVal.get(keys[1])));
        }
    }
}
