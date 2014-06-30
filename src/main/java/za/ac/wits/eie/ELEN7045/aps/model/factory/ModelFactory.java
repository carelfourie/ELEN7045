package za.ac.wits.eie.ELEN7045.aps.model.factory;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;

public class ModelFactory {

	public static <T extends BaseDomainEntity<Long>> T create(Class<T> entityClass) throws APSException {
		try {
			T entity = entityClass.newInstance();
			return entity;
		} catch (Exception e) {
			throw new APSException(e.getMessage());
		}
	}
}