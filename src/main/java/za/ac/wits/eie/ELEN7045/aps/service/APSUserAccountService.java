package za.ac.wits.eie.ELEN7045.aps.service;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.repository.SaveRepository;
import za.ac.wits.eie.ELEN7045.aps.service.base.BaseService;

@Stateless
public class APSUserAccountService extends BaseService {

	@Inject
	private SaveRepository saveRepo;

	@Inject
	private Event<APSUser> userEventSrc;

	public void createAccount(APSUser apsUser) {
		log.info(String.format("creating account for: [%s]", apsUser.getUsername()));
		saveRepo.save(apsUser);
		userEventSrc.fire(apsUser);
	}
}