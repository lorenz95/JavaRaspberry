package pse.eventTracker;

import java.util.Calendar;
import java.util.GregorianCalendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import pse.common.Event;

public class PresenceEvent implements Event {

	private final String PRESENZA = "PRES: ";

	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String name;	

	public PresenceEvent(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getDate() {
		//System.out.println("Date: " + dateFormat.format(new Date()).toString());
		return PRESENZA + this.name + " " + dateFormat.format(new Date()).toString();
	}
}