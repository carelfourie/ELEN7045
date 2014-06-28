package za.ac.wits.eie.ELEN7045.aps.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class APSUser extends BaseDomainEntity<Long> {

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "apsUser")
	@Fetch(FetchMode.SELECT)
	private List<CompanyAccount> companyAccounts;

	@NotNull
	@NotEmpty
	private String password;

	@NotNull
	@NotEmpty
	private String username;

	public APSUser() {
		super();
	}

	public APSUser(Long id) {
		super(id);
	}

	public List<CompanyAccount> getCompanyAccounts() {
		companyAccounts = constructListIfNull(companyAccounts);
		return companyAccounts;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setCompanyAccounts(List<CompanyAccount> companyAccounts) {
		this.companyAccounts = companyAccounts;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
