package za.ac.wits.eie.ELEN7045.aps.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import za.ac.wits.eie.ELEN7045.aps.model.ScrapingEventAuditLog;
import za.ac.wits.eie.ELEN7045.aps.service.AuditLogService;
import za.ac.wits.eie.ELEN7045.aps.service.exception.APSException;

@Model
public class ScrapingEventAuditLogController {

	private List<ScrapingEventAuditLog> scrapingEventList;

	@Produces
	@Named
	public List<ScrapingEventAuditLog> getScrapingEventList() {
		return scrapingEventList;
	}

	@Inject
	private AuditLogService auditLogService;

	@Inject
	private FacesContext facesContext;

	@Inject
	private Logger log;

	// public List<ScrapingEventAuditLog> getAuditLog() throws APSException {
	public String getAuditLog() throws APSException {

		List<ScrapingEventAuditLog> results = null;
		try {
			log.info("Retrieving audit log for user: " + "");
			results = auditLogService.getScrapingEvent("john");
			initLog();
			setScrapingEventList(results);
			return "success";
		} catch (APSException e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
		}
		return "failure";

	}

	@PostConstruct
	public void initLog() {
		scrapingEventList = new ArrayList<ScrapingEventAuditLog>();
	}

	public void setScrapingEventList(List<ScrapingEventAuditLog> scrapingEventList) {
		this.scrapingEventList = scrapingEventList;
	}
}
