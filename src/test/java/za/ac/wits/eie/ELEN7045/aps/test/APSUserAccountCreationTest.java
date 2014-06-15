package za.ac.wits.eie.ELEN7045.aps.test;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.service.APSUserAccountCreationService;
import za.ac.wits.eie.ELEN7045.aps.test.base.BaseTest;

@RunWith(Arquillian.class)
public class APSUserAccountCreationTest extends BaseTest {

	@Inject
    Logger log;

    @Inject
	APSUserAccountCreationService aPSUserAccountCreationService;
    
    @Test
    public void testCreateAccount() throws Exception {
    	
    	APSUser apsUser = new APSUser();
    	apsUser.setPassword("john");
    	apsUser.setUsername("john");
    	aPSUserAccountCreationService.createAccount(apsUser);
        assertNotNull(apsUser.getId());
        log.info(apsUser.getUsername() + " was persisted with id " + apsUser.getId());
    	
    }
}
