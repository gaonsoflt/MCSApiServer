package com.gaonsoft.mcs.common.util.gaonnova;

/**
 * 
 *  
 * @author  
 */
public enum ConstType {
	PGM_ID("_PGM_ID", "Session Program ID"),	
	REPORT_ID("_REPORT_ID", "REPORT_ID "),	
	USER_ID("_USER_ID", "Session User ID"),	
	USER_SEQ("_USER_SEQ", "Session User SEQ"),	
	TR_DT("_TR_DT", "transaction date time"),	
	BIZ_SRV_ID("BIZ_SRV_ID", "Biziness Service ID"),		
	SRV_ID("SVID", "Service ID"),		
	TURN_OVER_KEYS("TURN_OVER_KEYS", "TURN_OVER_KEYS"),	// 2016.02.19 kim jy
	
	RELATION_DETAILS("_DETAILS", "D1,D2,D3"),	// 2016.02.19 kim jy
	
	TOP_KEY("COMP_SEQ", "COMP_SEQ"),
	
	EVENT_TYPE("EVENT_TYPE", "Event Type"),		
	COMMON_SEARCH("COMMON_SEARCH", "Common Search"), 
	COMMON_SAVE("COMMON_SAVE", "COMMON_SAVE"),	
	COMMON_DELETE("COMMON_DELETE", "COMMON_DELETE"),	
	COMMON_PROC("COMMON_PROC", "COMMON_PROC"),	
	
	CODE_COLUMN("CODE", "CODE"),  // combo 
	DATA_COLUMN("VALUE", "VALUE"),// combo 
	CHECK_COLUMN("CHK", "CHK"),   // check column id 
			  
	IN_DATASET("IN_DATASET", "IN_DATASET" ),
	OUT_DATASET("OUT_DATASET", "OUT_DATASET" ),	
	PREFIX_DATASETID("RS", "Dataset" ),		
	
	DATASET_ID("DATASET_ID", "DATASET_ID" ),
	DATASET_NAME("DATASET_NAME", "DATASET_NAME" ),	
	ROW_ID("_ROW_ID", "ROW_ID" ),	
	ROW_TYPE("ROW_TYPE", "ROW_TYPE" ),		
	PK_SEQ("PK_SEQ", "PK_SEQ" ),	
	PK_SERL("PK_SERL", "PK_SERL" ),
	
	STATUS("_STATUS", "寃곌낵肄붾뱶" ),	
	RESULT("_RESULT", "寃곌낵硫붿꽭吏�" ),	
	ROWCOUNT("ROWCOUNT", "ROWCOUNT" ),
	RESULT_DATASET("dsResult", "RESULTDATASET" ),
	SAVET_TYPE_POSTFIX(":U", "SAVE_TR_FLAG" ), 

	ROW_TYPE_INSERT("I", "insert" ), 
	ROW_TYPE_UPDATE("U", "update" ), 
	ROW_TYPE_DELETE("D", "delete" ), 

	RETURN_VALUE("RETURN_VALUE", "RETURN_VALUE" ),	
	RETURN_VALUE_SET("RETURN_VALUE_SET", "RETURN_VALUE_SET" ),	

	COMMIT_MODE("COMMIT_MODE", "COMMIT_MODE" ),	
	COMMIT_MODE_ONCE("ONCE", "ONCE" ),	
	COMMIT_MODE_EACH("EACH", "EACH" ),		
	
	BLANK("", "blank" ),
	SPACE(" ", "space" ),
	SPLITER(";", "SPLITER" ),
	SUBSPLITER("@", "SUBSPLITER" ),

	QUOTES("\"", "QUOTES" ),	
	SMALL_QUOTES("'", "SMALL_QUOTES" ),	
	QUOTES2("&quto", "&quto" ),		
	
	SQLMAP_ID("SQLMAP_ID", "SQLMAP_ID" ),		
	SQLMAP_INSERT("-insert", "insert" ), 
	SQLMAP_UPDATE("-update", "update" ), 
	SQLMAP_DELETE("-delete", "delete" ), 
	SQLMAP_SELECT("-select", "select" ), 
	
	COMBO_VALUE_COL("VALUE", "VALUE" ),	
	COMBO_CODE_COL("CODE", "CODE" ),	
	COMBO_ISAUTH_COL("AUTH_YN", "AUTH_YN" ),	
	
	COMBO_VALUE_WHOLE("�쟾泥�", "WHOLE" ),	
	COMBO_CODE_WHOLE("", "�쟾泥�" ),	
	COMBO_EMPTYROW("EMPTYROW", "EMPTYROW" ),	
	
	ADD_COL("ADD_COL", "ADD_COL"),

	AUTH_ALLOWED("1", "1" ),	
	AUTH_NOT_ALLOWED("0", "0" ),
	
	TRUE("true", "true" ),	
	FALSE("false", "false" ),	
	
	OK("OK", "OK" ),	
	SUCESS("0", "0" ),	
	FAIL("-1", "-1" ),	
	
	VCURSOR("vcursor", "vcursor" ),	
	CLIENT_IP("CLIENT_IP", "CLIENT_IP" ),	
	ACCESS_MODE("_ACCESS_MODE", "_ACCESS_MODE" ),	
	
	TR_PROC_METHOD("TR_PROC_METHOD", "TR_PROC_METHOD") ,
	TR_PROC_SP("sp", "stored procedure") ,
	TR_PROC_MAP("sqlmap", "mybitis") ,
	
	RETREIVE_SP_ID("RETREIVE_SP_ID", "RETREIVE_SP_ID") , 
	RETREIVE_SP_ID_PREFIX("PR_", "PR_") , 
	RETREIVE_SP_ID_POSTFIX("_RET", "_RET") , 
	
	PRINT_SP_ID("PRINT_SP_ID", "PRINT_SP_ID") , 
	PRINT_SP_ID_PREFIX("PR_", "PR_") , 
	PRINT_SP_ID_POSTFIX("_PRT", "_PRT") , 

	SAVE_SP_ID("SAVE_SP_ID", "SAVE_SP_ID") , 
	SAVE_SP_ID_PREFIX("PR_", "PR_") , 
	SAVE_SP_ID_POSTFIX("_IUD", "_IUD") , 
	XML_DOC("XML_DOC", "XML_DOC") , 

	STRING_TOKEN1("&", "&"),
	STRING_TOKEN1_1("#", "#"),
	STRING_TOKEN2("=", "="),
	
	AESKEY("AESKEY", "aeskey"),
	AESKEY_LOGIN("AESKEY", "login"),
	AESKEY_USER("AESKEY", "user"),
	DES("DES", "des");
	
	
	

	public final String key;
	public final String value;
	
	ConstType(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 *  
	 * @param
	 * @return
	 * @throws
	 */
	public String getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
}

 