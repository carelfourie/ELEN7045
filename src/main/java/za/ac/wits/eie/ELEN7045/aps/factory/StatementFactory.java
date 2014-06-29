package za.ac.wits.eie.ELEN7045.aps.factory;

import za.ac.wits.eie.ELEN7045.aps.model.statement.CreditCardStatement;
import za.ac.wits.eie.ELEN7045.aps.model.statement.MunicipalityStatement;
import za.ac.wits.eie.ELEN7045.aps.model.statement.TelcoStatement;
import za.ac.wits.eie.ELEN7045.aps.model.statement.base.Statement;

public abstract class StatementFactory {

	public static Statement createCreditCardStatement() {
		return new CreditCardStatement();
	}
	
	public static Statement createMunicipalityStatement() {
		return new MunicipalityStatement();
	}
	
	public static Statement createTelcoStatement() {
		return new TelcoStatement();
	}
}
