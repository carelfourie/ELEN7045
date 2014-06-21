package za.ac.wits.eie.ELEN7045.aps.scrape;

public enum ScrapeSessionData {

	BASE_URL("base-url", "setBaseUrl", "getBaseUrl"),
	DATE("date","setDate","getDate"),
	TIME("time", "setTime", "getTime"),
	RETURN_CODE("return-code","setReturnCode","getReturnCode"),
	ACCOUNT_NUMBER("Account Number","setAccountNumber", "getAccountNumber"),
	ACCOUNT_HOLDER_NAME("Account Holder Name","setAccountHolderName","getAccountHolderName"),
	STATEMENT_DATE("Statement Date","setStatementDate","getStatementDate"),
	STATEMENT_NUMBER("Statement Number","setStatementNumber","getStatementNumber");
	

	private String setterMethodName;
	private String getterMethodName;
	private String xmlElementName;

	private ScrapeSessionData(String xmlElementName, String setterMethodName,
			String getterMethodName) {
		this.xmlElementName = xmlElementName;
		this.setterMethodName = setterMethodName;
		this.getterMethodName = getterMethodName;
	}

	public String getGetterMethodName() {
		return getterMethodName;
	}

	public String getSetterMethodName() {
		return setterMethodName;
	}

	public String getXmlElementName() {
		return xmlElementName;
	}
	
	public static ScrapeSessionData getScrapeSessionData(String xmlElementName){
		for(ScrapeSessionData ssd : ScrapeSessionData.values()){
			if(ssd.xmlElementName.equalsIgnoreCase(xmlElementName)){
				return ssd;
			}
		}
		return null;
	}
}
