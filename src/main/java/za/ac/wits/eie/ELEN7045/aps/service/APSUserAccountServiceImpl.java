package za.ac.wits.eie.ELEN7045.aps.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;

@Stateless
public class APSUserAccountServiceImpl implements APSUserAccountService{

	@Inject
    private Logger log;
	
	@Inject
    private Event<APSUser> userEventSrc;
	
	@PersistenceContext EntityManager userDatabase;
	
	/**
	 * Create account for user
	 * @param aPSUser
	 */
	@Override
	public void createAccount(APSUser aPSUser) {
		log.info("Creating account for " + aPSUser.getUsername());
		userDatabase.persist(aPSUser);
		userEventSrc.fire(aPSUser);
	}

}