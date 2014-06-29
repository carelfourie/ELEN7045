package za.ac.wits.eie.ELEN7045.aps.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class BaseRepository {

	@Inject
	protected EntityManager entityManager;

}