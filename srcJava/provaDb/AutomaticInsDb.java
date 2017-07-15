package pse.provaDb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

public class AutomaticInsDb {

	private static Random random;
	
	public static final String PRESENZA = "Presenza: ";
	public static final String TEMPERATURA = "Temperatura: ";
	
	public static final String ALARM = "ALARM";
	public static final String NOT_ALARM = "NOT_ALARM";
	
	public static final int INS_ALARM = 2;
	public static final int MAX = 40;
	public static final int MIN = 20;
	
	private static int initRand() {
		return (MAX-MIN) + 1;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		   String alarm;
		   final ManageDb manageDb = new ManageDb();
		   
		   int range, temp, i;
		   
		   range = initRand();
		   i = 0;
		   random = new Random();
		   
		   while (true) {
			   
			   temp = random.nextInt(range) + MIN;
			   alarm = ((i % INS_ALARM) == 0) ? ALARM : NOT_ALARM;

			   try {
				manageDb.insertDb(TEMPERATURA + temp);
				manageDb.insertDb(PRESENZA + alarm);
			   } catch (NotTempOrPresException | IOException e) {
				System.out.println("Eccezione: " + e);
			   }
			   i++;
			   temp = (int) Math.random();
		   }
		   
	   }//end main
}
