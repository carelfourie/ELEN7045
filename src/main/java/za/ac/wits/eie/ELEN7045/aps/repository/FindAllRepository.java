package za.ac.wits.eie.ELEN7045.aps.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;
import za.ac.wits.eie.ELEN7045.aps.repository.base.BaseRepository;

@ApplicationScoped
public class FindAllRepository extends BaseRepository {

	public <T extends BaseDomainEntity<Long>> List<T> findAll(Class<T> entity) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteria = cb.createQuery(entity);
		Root<T> root = criteria.from(entity);
		criteria.select(root);
		return entityManager.createQuery(criteria).getResultList();
	}
}
