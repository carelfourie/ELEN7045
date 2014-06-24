package za.ac.wits.eie.ELEN7045.aps.controller;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class ScraperInfo  extends BaseDomainEntity<Long>{

	private String url;
	private String xmlResultFile;
	@ManyToOne
	private APSUser apsUser;
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getXmlResultFile() {
		return xmlResultFile;
	}

	public void setXmlResultFile(String xmlResultFile) {
		this.xmlResultFile = xmlResultFile;
	}

	public APSUser getApsUser() {
		return apsUser;
	}

	public void setApsUser(APSUser apsUser) {
		this.apsUser = apsUser;
	}

	

}
