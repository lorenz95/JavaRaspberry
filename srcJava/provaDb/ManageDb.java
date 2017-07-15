package pse.provaDb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManageDb {
	
	private final static int POS_INDEX = 12;
	private final DateFormat dateFormat;
	private Connection conn;
	private Statement stmt;
	
	public ManageDb() throws ClassNotFoundException, SQLException {
		this.executeQueryCreate(Config.DBMS_URL.getName(), Config.CREATE_DB.getName());
		this.executeQueryCreate(Config.DB_URL.getName(), Config.CREATE_TABLE_PRES.getName());
		this.executeQueryCreate(Config.DB_URL.getName(), Config.CREATE_TABLE_TEMP.getName());
		
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	
	private Connection StartconnDb(String nameConnTo) throws ClassNotFoundException, SQLException {
		Class.forName(Config.JDBC_DRIVER.getName());
		return DriverManager.getConnection(nameConnTo, Config.USER.getName(), Config.PASS.getName());
	}
	
	private void executeQueryCreate(String nameConnTo, String query) throws SQLException, ClassNotFoundException {
		conn = StartconnDb(nameConnTo);
		stmt = conn.createStatement();
	    stmt.executeUpdate(query);
	    conn.close();
	}
	
	private void executeQueryUpdate(final String nameTab, final String nameModify, final String[] values) throws SQLException, ClassNotFoundException {
		conn = StartconnDb(Config.DB_URL.getName());
		PreparedStatement prepared = conn.prepareStatement(Config.INSERT_IN_TO.getName() + nameTab + nameModify);
		prepared.setString(1, values[0]);
		prepared.setString(2, values[1]);
		prepared.executeUpdate();
		conn.close();
	}
	
	public void insertDb(final String dato) throws NotTempOrPresException, IOException, ClassNotFoundException {
		String alarm;

		if (dato.contains(Config.PRESENZA.getName())) {
			alarm = dato.substring(dato.indexOf(':') + 1);
			try {
				executeQueryUpdate(Config.TB_NAME_PRES.getName(), Config.NAME_MODIFY.getName(), new String[]{alarm, dateFormat.format(new Date()).toString()});
				
			} catch (SQLException e) {
				System.out.print("Eccezione: " + e);
			}
		} else if (dato.contains(Config.TEMPERATURA.getName())) {
			try {
				executeQueryUpdate(Config.TB_NAME_TEMP.getName(), Config.NAME_MODIFY.getName(), new String[]{dato.substring(POS_INDEX), dateFormat.format(new Date()).toString()});
				
			} catch (SQLException e) {
				System.out.print("Eccezione: " + e);
			}
		}
	}
}
