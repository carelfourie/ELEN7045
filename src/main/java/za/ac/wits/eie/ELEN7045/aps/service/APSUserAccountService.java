package za.ac.wits.eie.ELEN7045.aps.service;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import za.ac.wits.eie.ELEN7045.aps.model.APSUser;

@Stateless
public class APSUserAccountService {

	@Inject
    private Logger log;
	
	@Inject
    private Event<APSUser> userEventSrc;
	
	@PersistenceContext EntityManager userDatabase;
	
	/**
	 * Create account for user
	 * @param aPSUser
	 */
	public void createAccount(APSUser aPSUser) {
		log.info("Creating account for " + aPSUser.getUsername());
		userDatabase.persist(aPSUser);
		userEventSrc.fire(aPSUser);
	}
}