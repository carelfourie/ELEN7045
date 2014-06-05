package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;

@Entity
public class MunicipalityStatement extends Statement {

    public MunicipalityStatement() {
        super();
    }

    public MunicipalityStatement(Long id) {
        super(id);
    }
}
