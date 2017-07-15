package pse.provaDb;

public enum Config {
	PRESENZA("Presenza"), TEMPERATURA("Temperatura"), JDBC_DRIVER("com.mysql.jdbc.Driver"),
	DBMS_URL("jdbc:mysql://localhost/"), USER("root"), PASS("lorenzo"),
	
	DB_NAME("Temp_Pres_Db"), DB_URL(DBMS_URL.getName()+DB_NAME.getName()), 
	TB_NAME_PRES("Pres"), TB_NAME_TEMP("Temp"),
	
	CREATE_DB("CREATE DATABASE IF NOT EXISTS " + DB_NAME.getName()), 
	CREATE_TABLE_FORMULA("CREATE TABLE IF NOT EXISTS "),
	
	FORMULA_TABLE("(ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, Valore VARCHAR(40), Data VARCHAR(40))"),
	
	CREATE_TABLE_PRES(CREATE_TABLE_FORMULA.getName() + TB_NAME_PRES.getName() + FORMULA_TABLE.getName()),
	CREATE_TABLE_TEMP(CREATE_TABLE_FORMULA.getName() + TB_NAME_TEMP.getName() + FORMULA_TABLE.getName()),
	
	NAME_MODIFY("(Valore, Data) values (?,?)"),
	INSERT_IN_TO("insert into ");
	
	private String name;
	
	private Config(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
