package pse.eventTracker;

import java.util.Calendar;
import java.util.GregorianCalendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import pse.common.Event;

public class DataEvent implements Event {
	private final static String TEMP_EVENT = "TEMP: ";
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String data;
	
	public DataEvent(String data) {
		this.data = data;
	}
	
	public String getData() {
		return TEMP_EVENT + this.data + " " + dateFormat.format(new Date()).toString();
	}
}
