package pse.provaDb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LetturaDati {
	
	private static BufferedReader variabile;
	private static LetturaDati istanza;
	
	private LetturaDati() {
		LetturaDati.variabile = new BufferedReader(new InputStreamReader(System.in));
	}

	public static synchronized LetturaDati getInstance() {
		if (istanza == null) {
			istanza = new LetturaDati();
		}
		return istanza;
	}
	
	public String leggiDati() throws NotTempOrPresException, IOException {
		
		String strRead = variabile.readLine();
		
		if (strRead.contains(Config.PRESENZA.getName()) || strRead.contains(Config.TEMPERATURA.getName())) {
			return strRead;
		} else {
			throw new NotTempOrPresException();
		}
	}
}
