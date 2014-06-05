package za.ac.wits.eie.ELEN7045.aps.model.statement;

import javax.persistence.Entity;

import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;

@Entity
public class CreditCardStatement extends Statement {

    public CreditCardStatement() {
        super();
    }

    public CreditCardStatement(Long id) {
        super(id);
    }
}
