package za.ac.wits.eie.ELEN7045.aps.repository;

import javax.enterprise.context.ApplicationScoped;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;
import za.ac.wits.eie.ELEN7045.aps.repository.base.BaseRepository;

@ApplicationScoped
public class FindByIdRepository extends BaseRepository {

	public <T extends BaseDomainEntity<Long>> T findById(Class<T> entity, Long id) {
		return entityManager.find(entity, id);
	}
}
