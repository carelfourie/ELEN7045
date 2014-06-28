package za.ac.wits.eie.ELEN7045.aps.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import za.ac.wits.eie.ELEN7045.aps.model.Member;
import za.ac.wits.eie.ELEN7045.aps.service.MemberRegistration;

// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
@Model
public class MemberController {

	@Inject
	private FacesContext facesContext;

	@Inject
	private MemberRegistration memberRegistration;

	@Produces
	@Named
	private Member newMember;

	private String getRootErrorMessage(Exception e) {
		// default to general error message that registration failed.
		String errorMessage = "Registration failed. See server log for more information";
		if (e == null) {
			// this shouldn't happen, but return the default messages
			return errorMessage;
		}

		// start with the exception and recurse to find the root cause
		Throwable t = e;
		while (t != null) {
			// get the message from the Throwable class instance
			errorMessage = t.getLocalizedMessage();
			t = t.getCause();
		}
		// this is the root cause message
		return errorMessage;
	}

	@PostConstruct
	public void initNewMember() {
		newMember = new Member();
	}

	public void register() throws Exception {
		try {
			memberRegistration.register(newMember);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewMember();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
		}
	}
}
