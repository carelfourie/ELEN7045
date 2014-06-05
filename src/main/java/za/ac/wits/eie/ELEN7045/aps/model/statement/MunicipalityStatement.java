package za.ac.wits.eie.ELEN7045.aps.model.statement;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;

@Entity
public class MunicipalityStatement extends Statement {

    public MunicipalityStatement() {
        super();
    }

    public MunicipalityStatement(Long id) {
        super(id);
    }
}
