package za.ac.wits.eie.ELEN7045.aps.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import za.ac.wits.eie.ELEN7045.aps.model.ScrapingEventAuditLog;
import za.ac.wits.eie.ELEN7045.aps.repository.base.BaseRepository;

@ApplicationScoped
public class AuditLogRepository extends BaseRepository {

	@SuppressWarnings("unchecked")
	public List<ScrapingEventAuditLog> findByAPSUser(String name) {
		Session session = (Session) entityManager.getDelegate();
		List<ScrapingEventAuditLog> users = session.createCriteria(ScrapingEventAuditLog.class).createAlias("apsUser", "user").add(Restrictions.eq("user.username", name)).list();
		return users;
	}
}
