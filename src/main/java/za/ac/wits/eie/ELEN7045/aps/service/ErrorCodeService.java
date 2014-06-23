package za.ac.wits.eie.ELEN7045.aps.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.hibernate.criterion.Restrictions;

import za.ac.wits.eie.ELEN7045.aps.data.FindByCriteriaRepository;
import za.ac.wits.eie.ELEN7045.aps.model.ReturnCode;
import za.ac.wits.eie.ELEN7045.aps.service.base.BaseService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;

@Stateless
public class ErrorCodeService extends BaseService {
    
    @Inject
    private FindByCriteriaRepository findByCriteriaRepo;
    
    public String getDescriptionForCode(String code) throws APSException {
        List<ReturnCode> codes = findByCriteriaRepo.findByCriteria(ReturnCode.class, Restrictions.eq("code", code));
        
        if (codes.size() < 1) {
            throw new APSException(String.format("Code not found: [%s]", code));
        }

        if (codes.size() > 1) {
            throw new APSException(String.format("Duplicate code found: [%s]", code));
        }
        
        return codes.get(0).getApsdescription();
    }
}
