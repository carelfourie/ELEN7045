package za.ac.wits.eie.ELEN7045.aps.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        
        Map<String, String> msgVal = new LinkedHashMap<String, String>(2);
        msgVal.put("Code not found: [%s]", code);
        msgVal.put("Duplicate code found: [%s]", code);
       
        listCheck(codes, msgVal);
        
        return codes.get(0).getApsdescription();
    }
}
