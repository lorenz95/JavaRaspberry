package pse.blinker_with_msg;

import pse.devices.*;
import pse.serial.*;

public class ControllableBlinking {
	public static void main(String[] args) {
		Light led = new pse.devices.p4j_impl.Led(0);
		
		try {
		CommChannel inputDev = new pse.serial.SerialCommChannel(args[0], 9600);
		
		Blinker blinker = new Blinker(led);
		InputMsgReceiver rec = new InputMsgReceiver(blinker,inputDev);
		blinker.start();
		rec.start();
		} catch (Exception e) {
			System.out.println("Exception = " + e);
		}
	}

}
