package pse.mainTracker;

import pse.common.*;
import pse.devices.*;

import pse.eventTracker.*;

import pse.serial.*;

import pse.sendJSON.*;

public class EventTracker extends BasicEventLoopController {

	private static String MSG_ALARM = "ALLARME";
	private static String MSG_RESET = "RESET";

	private Send sendFile;

	private Light ledOnOff;
	private Light ledAlarm;
	private ObservableButton resetButton;

	private ObservableTimer timer;
	private CommChannel inputDev;

	private String evData;
	
	public EventTracker(Light ledOnOff, Light ledAlarm, ObservableButton resetButton, CommChannel inputDev) throws Exception{
		this.ledOnOff = ledOnOff;
		this.ledAlarm = ledAlarm;
		this.resetButton = resetButton;

		timer = new ObservableTimer();
		timer.addObserver(this);

		resetButton.addObserver(this);

		this.inputDev = inputDev;

		try {
			ledOnOff.switchOn();
			ledAlarm.switchOff();
		} catch (Exception e) {
			System.out.println("Eccezione: " + e);
		}
		sendFile = new SendImpl();
	}

	protected void processEvent(Event ev){

		try {
			if (ev instanceof DataEvent) {
				DataEvent dataEvent = (DataEvent) ev;
				evData = dataEvent.getData();
				sendFile.collectData(evData);

				System.out.println("EventTracker dati: " + evData);
			} else if (ev instanceof PresenceEvent) {
				PresenceEvent presenceEvent = (PresenceEvent) ev;
				evData = presenceEvent.getDate();

				System.out.println("EventTracker presenza: " + evData);

				if (presenceEvent.getName().equals(MSG_ALARM)) {
					ledAlarm.switchOn();
					ledOnOff.switchOff();
				}
				
				sendFile.collectData(evData);
			} else if (ev instanceof ButtonPressed) {
				ledAlarm.switchOff();
				ledOnOff.switchOn();
				inputDev.sendMsg(MSG_RESET+"\n");

				System.out.println("Bottone premuto");
			}
			
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
