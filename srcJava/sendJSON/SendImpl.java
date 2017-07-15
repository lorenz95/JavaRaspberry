package pse.sendJSON;

import java.lang.Exception;

import org.json.simple.JSONObject;

import org.json.simple.JSONArray;

import java.util.HashMap;

import java.io.*;

public class SendImpl implements Send {

	private HashMap<String, PrintWriter> mapPrinter;
	private HashMap<String, Counter> mapCounter;

	private final static String TEMP_NAME = "TEMP";
	private final static String PRESENZA_NAME = "PRES";

	public static final String PATH_FILE_TEMP = "/var/www/html/prova/temp.json";
	public static final String PATH_FILE_PRESENZA = "/var/www/html/prova/presence.json";

	private JSONArray jsonArrayTemp;
	private JSONArray jsonArrayAllarme;

	public SendImpl() throws Exception {
		mapPrinter = new HashMap<>();
		mapCounter = new HashMap<>();

		initMap();

		this.jsonArrayTemp = new JSONArray();
		this.jsonArrayAllarme = new JSONArray();
	}

	private void initMap() throws Exception {
		mapPrinter.put(TEMP_NAME, createPrinter(PATH_FILE_TEMP));
		mapPrinter.put(PRESENZA_NAME, createPrinter(PATH_FILE_PRESENZA));

		mapCounter.put(TEMP_NAME, new Counter());
		mapCounter.put(PRESENZA_NAME, new Counter());
	}

	private PrintWriter createPrinter(String pathFile) throws Exception {
		File fileServer = new File(pathFile);
		FileWriter writer = new FileWriter(fileServer);
		BufferedWriter fileBuf = new BufferedWriter(writer);
		return new PrintWriter(fileBuf);
	}

	public void collectData(String stringaDati) {

          //System.out.println("SendImpl stringaDati: " + stringaDati);

	if (stringaDati.contains(TEMP_NAME) || stringaDati.contains(PRESENZA_NAME)) {
	   String key = (stringaDati.contains(TEMP_NAME)) ? TEMP_NAME : PRESENZA_NAME;
	   JSONArray jsonArray = (stringaDati.contains(TEMP_NAME)) ? jsonArrayTemp : jsonArrayAllarme;

	   insertToArray(stringaDati, jsonArray);
	   mapCounter.get(key).incCount();
           checkSend(key, jsonArray);
	}
	}

	private void insertToArray(String dati, JSONArray jsonArray) {
	 try {
	  jsonArray.add(dati);
	 } catch (Exception ex) {
	   System.out.println("Eccezione: " + ex);
	 }
	}

	private void checkSend(String key, JSONArray jsonArray) {
	 if (mapCounter.get(key).getSend()) {
	     sendToFile(mapPrinter.get(key), jsonArray);
	     mapCounter.get(key).resetCount();
	     //System.out.println("Send manda i dati sul file: " + TEMP_NAME);
	 }
	}

	private void sendToFile(PrintWriter printWriter, JSONArray jsonArray) {
		try {
			//printWriter.append("INFO: ");
			printWriter.append(jsonArray.toJSONString());
			printWriter.flush();
			//printWriter.close();

			for (int i = 0; i < jsonArray.size(); i++) {
				jsonArray.remove(i);
			}
		} catch (Exception ex) {
			System.out.println("Eccezione : " + ex);
		}
	}

}