package za.ac.wits.eie.ELEN7045.aps.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import za.ac.wits.eie.ELEN7045.aps.data.AuditLogRepository;
import za.ac.wits.eie.ELEN7045.aps.model.ScrapingEventAuditLog;
import za.ac.wits.eie.ELEN7045.aps.service.base.BaseService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;

@Stateless
public class AuditLogService extends BaseService {

	@Inject
	private AuditLogRepository auditLogRepo;
	
    public List<ScrapingEventAuditLog> getScrapingEvent(String username) throws APSException {
        log.info("Retrieving auditlog with username " + username);

        List<ScrapingEventAuditLog> auditLog = auditLogRepo.findByAPSUser(username);
        if (auditLog.size() < 1) {
            throw new APSException(String.format("User not found: [%s]", username));
        }
        
        return auditLog;
    }
}
