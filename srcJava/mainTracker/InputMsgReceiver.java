package pse.mainTracker;

import pse.common.*;
import pse.devices.*;
import pse.serial.*;

import pse.blinker_with_msg.Blinker;
import pse.blinker_with_msg.StartMsg;
import pse.blinker_with_msg.StopMsg;

import pse.eventTracker.*;

public class InputMsgReceiver extends BasicController {
 public static enum MessaggiSeriale {
  MSG_READY("READY"), MSG_STOP("STOP"), MSG_SEND("SEND"), MSG_DATA("DATA:"), MSG_ALARM("ALLARME"), MSG_NO_ALARM("NO ALLARME");
  
  private String name;
  
	MessaggiSeriale(String name) {
	   this.name = name;
	}

	public String getName() {
	   return this.name;
	}

 }

 private EventTracker eventTracker;
 private Blinker blinker;
 private CommChannel serialDevice;
	
 public InputMsgReceiver(EventTracker eventTracker, Blinker blinker, CommChannel serialDevice){
	this.eventTracker = eventTracker;
	this.blinker = blinker;
	this.serialDevice = serialDevice;
 }
 
 @Override
 public void run() {
	while (true){
		try {
			manageSerialEvent();
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
 }

 private void manageSerialEvent() {
	 if (serialDevice.isMsgAvailable()) {
	    try {
	 	String msg = serialDevice.receiveMsg();

	 	//System.out.println("Input riceve: " + msg);
		
	 	if (msg.equals(MessaggiSeriale.MSG_READY.getName())){
 	 		blinker.notifyEvent(new StartMsg());
 	 		serialDevice.sendMsg(MessaggiSeriale.MSG_SEND.getName()+"\n");
 	 	} else if (msg.equals(MessaggiSeriale.MSG_STOP.getName())){
 	 		blinker.notifyEvent(new StopMsg());
 	 	} else if (msg.equals(MessaggiSeriale.MSG_ALARM.getName())) {
			eventTracker.notifyEvent(new PresenceEvent(MessaggiSeriale.MSG_ALARM.getName()));
			//System.out.println("Riceve: " + msg);
         	} else if (msg.equals(MessaggiSeriale.MSG_NO_ALARM.getName())) {
			eventTracker.notifyEvent(new PresenceEvent(MessaggiSeriale.MSG_NO_ALARM.getName()));
			//System.out.println("Riceve: " + msg);
	 	} else if (msg.indexOf(MessaggiSeriale.MSG_DATA.getName()) >= 0) {
			String tempValue = msg.substring(msg.indexOf(":")+1);
			//System.out.println("Riceve temperatura");
			eventTracker.notifyEvent(new DataEvent(tempValue));
	 	}
	    } catch (Exception ex){
		ex.printStackTrace();
	   }
	}
 }
}
