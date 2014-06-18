package za.ac.wits.eie.ELEN7045.aps.test;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.service.APSUserAccountService;
import za.ac.wits.eie.ELEN7045.aps.test.base.BaseTest;

@RunWith(Arquillian.class)
public class APSUserAccountTest extends BaseTest {

	@Inject
	Logger log;

    @Inject
	APSUserAccountService aPSUserAccountCreationService;
    
    @Test
    public void testCreateAccount() throws Exception {
    	
    	APSUser apsUser = new APSUser();
    	apsUser.setPassword("peter");
    	apsUser.setUsername("peter");
    	aPSUserAccountCreationService.createAccount(apsUser);
        assertNotNull(apsUser.getId());
        log.info(apsUser.getUsername() + " was persisted with id " + apsUser.getId());
        System.out.println(apsUser.getUsername() + " was persisted with id " + apsUser.getId());
    	
    }
}
