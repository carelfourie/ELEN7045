package za.ac.wits.eie.ELEN7045.aps.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;
import za.ac.wits.eie.ELEN7045.aps.service.APSUserAccountService;
import za.ac.wits.eie.ELEN7045.aps.service.LoginService;
import za.ac.wits.eie.ELEN7045.aps.test.base.BaseTest;

@RunWith(Arquillian.class)
public class APSUserLoginTest extends BaseTest {

	@Inject
	APSUserAccountService aPSUserAccountCreationService;

	@Inject
	Logger log;

	@Inject
	LoginService loginService;

	@Test
	public void testCreateAccount() throws Exception {

		APSUser apsUser = new APSUser();
		apsUser.setPassword("peter");
		apsUser.setUsername("peter");
		aPSUserAccountCreationService.createAccount(apsUser);
		log.info(apsUser.getUsername() + " was persisted with id " + apsUser.getId());

		List<CompanyAccount> list = loginService.loadAPSUserAccounts(apsUser.getPassword(), apsUser.getUsername());
		assertEquals(0, list.size());
	}

}
