package za.ac.wits.eie.ELEN7045.aps.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;
import za.ac.wits.eie.ELEN7045.aps.service.LoginService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;
import static org.mockito.Mockito.*;

public class APSUserLoginMockTest {
	
	@Test
	public void testUserLogin() throws APSException {
		LoginService loginService = mock(LoginService.class);
		List<CompanyAccount> list = new ArrayList<CompanyAccount>();
		
		when(loginService.loadAPSUserAccounts("John", "john")).thenReturn(list);
		verify(loginService, times(1));
	}

}
