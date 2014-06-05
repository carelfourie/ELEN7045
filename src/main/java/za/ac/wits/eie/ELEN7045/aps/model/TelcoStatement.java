package za.ac.wits.eie.ELEN7045.aps.model;

import javax.persistence.Entity;

@Entity
public class TelcoStatement extends Statement {

    public TelcoStatement() {
        super();
    }

    public TelcoStatement(Long id) {
        super(id);
    }
}
