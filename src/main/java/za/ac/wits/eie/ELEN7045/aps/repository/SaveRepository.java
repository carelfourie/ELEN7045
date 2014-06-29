package za.ac.wits.eie.ELEN7045.aps.repository;

import javax.enterprise.context.ApplicationScoped;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;
import za.ac.wits.eie.ELEN7045.aps.repository.base.BaseRepository;

@ApplicationScoped
public class SaveRepository extends BaseRepository {

	public <T extends BaseDomainEntity<Long>> T save(T entity) {
		return entityManager.merge(entity);
	}
}
