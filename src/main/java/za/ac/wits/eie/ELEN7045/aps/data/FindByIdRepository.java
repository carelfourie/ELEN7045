package za.ac.wits.eie.ELEN7045.aps.data;

import javax.enterprise.context.ApplicationScoped;

import za.ac.wits.eie.ELEN7045.aps.data.base.BaseRepository;
import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@ApplicationScoped
public class FindByIdRepository extends BaseRepository {

    public <T extends BaseDomainEntity<Long>> T findById(Class<T> entity, Long id) {
        return entityManager.find(entity, id);
    }
}
