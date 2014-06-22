package za.ac.wits.eie.ELEN7045.aps.scrape;

public enum ScrapeSessionData {

	ACCOUNT_HOLDER_NAME("Account Holder Name","setAccountHolderName","getAccountHolderName"),
	ACCOUNT_NUMBER("Account Number","setAccountNumber", "getAccountNumber"),
	BASE_URL("base-url", "setBaseUrl", "getBaseUrl"),
	DATE("date","setDate","getDate"),
	RETURN_CODE("return-code","setReturnCode","getReturnCode"),
	STATEMENT_DATE("Statement Date","setStatementDate","getStatementDate"),
	STATEMENT_NUMBER("Statement Number","setStatementNumber","getStatementNumber"),
	TIME("time", "setTime", "getTime");
	

	public static ScrapeSessionData getScrapeSessionData(String xmlElementName){
		for(ScrapeSessionData ssd : ScrapeSessionData.values()){
			if(ssd.xmlElementName.equalsIgnoreCase(xmlElementName)){
				return ssd;
			}
		}
		return null;
	}
	private String getterMethodName;
	private String setterMethodName;

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
}
