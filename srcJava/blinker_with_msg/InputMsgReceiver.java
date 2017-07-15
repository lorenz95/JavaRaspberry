package pse.blinker_with_msg;

import pse.common.*;
import pse.devices.*;
import pse.serial.*;

public class InputMsgReceiver extends BasicController {

	private static final String START = "Start";
	private static final String STOP = "Stop";
	private static final String GO = "Go";

	private Blinker blinker;
	private CommChannel serialDevice;
	
	public InputMsgReceiver(Blinker blinker, CommChannel serialDevice){
		this.blinker = blinker;
		this.serialDevice = serialDevice;
	}
	
	@Override
	public void run() {
		while (true){
			try {
				String msg = serialDevice.receiveMsg();

				System.out.println("Messaggio = " + msg);

				if (msg.equals(START)){
					blinker.notifyEvent(new StartMsg());
					serialDevice.sendMsg(GO+"\n");
				} else if (msg.equals(STOP)){
					blinker.notifyEvent(new StopMsg());
				}
				else if (msg.indexOf("Temp:") >= 0) {
					String tempValue = msg.substring(msg.indexOf(":")+1);
					System.out.println("Temp="+tempValue);
				}
			} catch (Exception ex){
				ex.printStackTrace();
			}
		}
	}

}
