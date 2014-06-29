package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class ScraperInfo extends BaseDomainEntity<Long> {

	@ManyToOne
	private APSUser apsUser;

	private String url;

	private String xmlResultFile;

	public APSUser getApsUser() {
		return apsUser;
	}

	public String getUrl() {
		return url;
	}

	public String getXmlResultFile() {
		return xmlResultFile;
	}

	public void setApsUser(APSUser apsUser) {
		this.apsUser = apsUser;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setXmlResultFile(String xmlResultFile) {
		this.xmlResultFile = xmlResultFile;
	}
}
