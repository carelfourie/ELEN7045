package za.ac.wits.eie.ELEN7045.aps.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import za.ac.wits.eie.ELEN7045.aps.data.base.BaseRepository;
import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@ApplicationScoped
public class FindAllRepository extends BaseRepository {
    
    public <T extends BaseDomainEntity<Long>> List<T> findAll(Class<T> entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> criteria = cb.createQuery(entity);
        Root<T> root = criteria.from(entity);
        criteria.select(root);
        return em.createQuery(criteria).getResultList();
    }
}
