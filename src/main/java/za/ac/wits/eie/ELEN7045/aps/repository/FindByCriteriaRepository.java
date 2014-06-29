package za.ac.wits.eie.ELEN7045.aps.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;
import za.ac.wits.eie.ELEN7045.aps.repository.base.BaseRepository;

@ApplicationScoped
public class FindByCriteriaRepository extends BaseRepository {

	public <T extends BaseDomainEntity<Long>> List<T> findByCriteria(Class<T> entity, final Criterion... criterion) {
		return findByCriteria(entity, -1, -1, criterion);
	}

	@SuppressWarnings("unchecked")
	public <T extends BaseDomainEntity<Long>> List<T> findByCriteria(Class<T> entity, final int firstResult, final int maxResults, final Criterion... criterion) {
		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(entity);
		for (final Criterion c : criterion) {
			criteria.add(c);
		}
		if (firstResult > 0) {
			criteria.setFirstResult(firstResult);
		}
		if (maxResults > 0) {
			criteria.setMaxResults(maxResults);
		}
		return criteria.list();
	}
}
