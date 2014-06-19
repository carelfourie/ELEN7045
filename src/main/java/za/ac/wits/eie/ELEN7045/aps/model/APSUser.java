package za.ac.wits.eie.ELEN7045.aps.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Entity
public class APSUser extends BaseDomainEntity<Long> implements java.io.Serializable
{
	final static long serialVersionUID = 1L;
    @OneToMany(mappedBy = "apsUser")
    private List<CompanyAccount> companyAccounts;
    
    @NotNull
    @NotEmpty
    private String username;
    
    @NotNull
    @NotEmpty
    private String password;

    public APSUser() {
        super();
    }

    public APSUser(Long id) {
        super(id);
    }

	public List<CompanyAccount> getCompanyAccounts() {
		return companyAccounts;
	}

	public void setCompanyAccounts(List<CompanyAccount> companyAccounts) {
		this.companyAccounts = companyAccounts;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
