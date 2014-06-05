package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;

@Entity
public class CreditCardStatement extends Statement {

    public CreditCardStatement() {
        super();
    }

    public CreditCardStatement(Long id) {
        super(id);
    }
}
