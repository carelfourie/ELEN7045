package za.ac.wits.eie.ELEN7045.aps.service;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import za.ac.wits.eie.ELEN7045.aps.data.SaveRepository;
import za.ac.wits.eie.ELEN7045.aps.model.Member;
import za.ac.wits.eie.ELEN7045.aps.service.base.BaseService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;

@Stateless
public class MemberRegistration extends BaseService {

	@Inject
	private Event<Member> memberEventSrc;

	@Inject
	private SaveRepository saveRepo;

	public void register(Member member) throws APSException {
		log.info("Registering " + member.getName());
		saveRepo.save(member);
		memberEventSrc.fire(member);
	}
}
