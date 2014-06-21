package za.ac.wits.eie.ELEN7045.aps.model.statement.base;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Statement extends BaseDomainEntity<Long> {

	private String statement;
	
	private String xmlResult;
	
	
	
    public String getXmlResult() {
		return xmlResult;
	}

	public void setXmlResult(String xmlResult) {
		this.xmlResult = xmlResult;
	}

	public Statement() {
        super();
    }

    public Statement(Long id) {
        super(id);
    }

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}
}
