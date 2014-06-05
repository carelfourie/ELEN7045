package za.ac.wits.eie.ELEN7045.aps.model.statement;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;

@Entity
public class TelcoStatement extends Statement {

    public TelcoStatement() {
        super();
    }

    public TelcoStatement(Long id) {
        super(id);
    }
}
