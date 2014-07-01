package za.ac.wits.eie.ELEN7045.aps.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import za.ac.wits.eie.ELEN7045.aps.repository.FindByCriteriaRepository;
import za.ac.wits.eie.ELEN7045.aps.service.base.BaseService;

@Stateless
public class SchedulerService extends BaseService {

	@Inject
	private FindByCriteriaRepository findByCriteriaRepo;

}
