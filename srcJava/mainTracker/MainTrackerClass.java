package pse.mainTracker;

import pse.devices.*;
import pse.serial.*;

import pse.blinker_with_msg.Blinker;

import pse.devices.ObservableButton;
import pse.devices.p4j_impl.Button;
import pse.devices.p4j_impl.Led;

public class MainTrackerClass {

	public final static int LED_VERDE = 2;
	public final static int LED_ROSSO = 0;
	public final static int LED_GIALLO = 7;

	public final static int BOTTONE_RESET = 3;

	public final static int PERIOD = 500;

	public static void main(String[] args) {
		try {
		Light ledAlarm = new pse.devices.p4j_impl.Led(LED_ROSSO);
		Light ledBlink = new pse.devices.p4j_impl.Led(LED_GIALLO);
		Light ledOnOff = new pse.devices.p4j_impl.Led(LED_VERDE);

		ObservableButton resetButton = new pse.devices.p4j_impl.Button(BOTTONE_RESET);
		CommChannel inputDev = new pse.serial.SerialCommChannel(args[0], 9600);

		Blinker blinker = new Blinker(ledBlink);
		
		EventTracker eventTracker = new EventTracker(ledOnOff, ledAlarm, resetButton, inputDev);
		InputMsgReceiver msgReceiver = new InputMsgReceiver(eventTracker, blinker, inputDev);

		blinker.start();
		eventTracker.start();
		msgReceiver.start();
		} catch (Exception e) {
			System.out.println("Exception = " + e);
		}
	}

}
