package pse.provaDb;

import java.io.IOException;
import java.sql.SQLException;

public class InsDb {
	   public static void main(String[] args) throws ClassNotFoundException, SQLException {
		   
		   final ManageDb manageDb = new ManageDb();
		   final LetturaDati letturaDati = LetturaDati.getInstance();
		   
		   while (true) {
			   try {
				manageDb.insertDb(letturaDati.leggiDati());
			} catch (NotTempOrPresException | IOException e) {
				System.out.println("Eccezione: " + e);
			}
		   }
	   }
}
