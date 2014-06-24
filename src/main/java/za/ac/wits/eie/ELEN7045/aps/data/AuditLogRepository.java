package za.ac.wits.eie.ELEN7045.aps.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import za.ac.wits.eie.ELEN7045.aps.data.base.BaseRepository;
import za.ac.wits.eie.ELEN7045.aps.model.ScrapingEventAuditLog;

@ApplicationScoped
public class AuditLogRepository  extends BaseRepository {
	
	@SuppressWarnings("unchecked")
    public List<ScrapingEventAuditLog> findByAPSUser(String name) {
		Session session = (Session) em.getDelegate();
		List<ScrapingEventAuditLog> users = null;
		 
		users = session.createCriteria(ScrapingEventAuditLog.class).createAlias("apsUser", "user").add(Restrictions.eq("user.username", name)).list();
		
		return users;
	}
	
//    public ScrapingEventAuditLog findByMember(String name) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<ScrapingEventAuditLog> criteria = cb.createQuery(ScrapingEventAuditLog.class);
//        Root<ScrapingEventAuditLog> log = criteria.from(ScrapingEventAuditLog.class);
//        criteria.select(log).where(cb.equal(log.get("name"), name)).orderby();
//        return em.createQuery(criteria).getSingleResult();
//    }
    
}
