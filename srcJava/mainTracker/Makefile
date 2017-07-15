PathCommon=/home/pi/Development/workspace/ProgettoComunicazione
Devices=$(PathCommon)/src/pse/devices/
Pi4jImpl=$(Devices)p4j_impl/
Common=$(PathCommon)/src/pse/common/
BlinkingMsg=$(PathCommon)/src/pse/blinker_with_msg/
Serial=$(PathCommon)/src/pse/serial/
BasicSerial=$(PathCommon)/src/pse/basicSerial/
EventTracker=$(PathCommon)/src/pse/eventTracker/
SendJSON=$(PathCommon)/src/pse/sendJSON/
MainTracker=$(PathCommon)/src/pse/mainTracker/

bin=/home/pi/Development/workspace/ProgettoComunicazione/bin
JCC=javac -Xlint
JPATH=-cp $(bin):$(PathCommon)/lib/javax.json-api-1.0.jar:$(PathCommon)/lib/json-simple-1.1.1.jar:/usr/share/java/RXTXcomm.jar:/opt/pi4j/lib/'*'
JFLAGS=-d $(bin)

default: Event.class Tick.class DataEvent.class PresenceEvent.class StopMsg.class StartMsg.class \
Light.class Config.class Led.class Button.class \
CommChannel.class SerialCommChannel.class \
ButtonPressed.class ButtonReleased.class Observer.class Observable.class \
ObservableTimer.class ObservableButton.class ButtonAdvanced.class \
BasicController.class BasicEventLoopController.class \
Blinker.class Counter.class Send.class SendImpl.class EventTracker.class InputMsgReceiver.class \
ShowSerialPorts.class MainTrackerClass.class

Event.class: $(Common)Event.java
		sudo $(JCC) $(JFLAGS) $(Common)Event.java

Tick.class: $(Devices)Tick.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Devices)Tick.java

DataEvent.class: $(EventTracker)DataEvent.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(EventTracker)DataEvent.java
		
PresenceEvent.class: $(EventTracker)PresenceEvent.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(EventTracker)PresenceEvent.java

StopMsg.class: $(BlinkingMsg)StopMsg.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(BlinkingMsg)StopMsg.java

StartMsg.class: $(BlinkingMsg)StartMsg.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(BlinkingMsg)StartMsg.java

Light.class: $(Devices)Light.java
		sudo $(JCC) $(JFLAGS) $(Devices)Light.java

Config.class: $(Pi4jImpl)Config.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Pi4jImpl)Config.java

Led.class: $(Pi4jImpl)Led.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Pi4jImpl)Led.java

Button.class: $(Devices)Button.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Devices)Button.java

CommChannel.class: $(Serial)CommChannel.java
		sudo $(JCC) $(JFLAGS) $(Serial)CommChannel.java 

SerialCommChannel.class: $(Serial)SerialCommChannel.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Serial)SerialCommChannel.java

ButtonReleased.class: $(Devices)ButtonReleased.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Devices)ButtonReleased.java
		
ButtonPressed.class: $(Devices)ButtonPressed.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Devices)ButtonPressed.java

Observer.class: $(Common)Observer.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Common)Observer.java

Observable.class: $(Common)Observable.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Common)Observable.java

ObservableTimer.class: $(Devices)ObservableTimer.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Devices)ObservableTimer.java

ObservableButton.class: $(Devices)ObservableButton.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Devices)ObservableButton.java

ButtonAdvanced.class: $(Pi4jImpl)Button.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Pi4jImpl)Button.java

BasicController.class: $(Common)BasicController.java
		sudo $(JCC) $(JFLAGS) $(Common)BasicController.java

BasicEventLoopController.class: $(Common)BasicEventLoopController.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Common)BasicEventLoopController.java

Blinker.class: $(BlinkingMsg)Blinker.java 
		sudo $(JCC) $(JFLAGS) $(JPATH) $(BlinkingMsg)Blinker.java

Counter.class: $(SendJSON)Counter.java 
		sudo $(JCC) $(JFLAGS) $(JPATH) $(SendJSON)Counter.java

Send.class: $(SendJSON)Send.java 
		sudo $(JCC) $(JFLAGS) $(JPATH) $(SendJSON)Send.java

SendImpl.class: $(SendJSON)SendImpl.java 
		sudo $(JCC) $(JFLAGS) $(JPATH) $(SendJSON)SendImpl.java

EventTracker.class: $(MainTracker)EventTracker.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(MainTracker)EventTracker.java

InputMsgReceiver.class: $(MainTracker)InputMsgReceiver.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(MainTracker)InputMsgReceiver.java

ShowSerialPorts.class: $(BasicSerial)ShowSerialPorts.java 
		sudo $(JCC) $(JFLAGS) $(JPATH) $(BasicSerial)ShowSerialPorts.java

MainTrackerClass.class: $(MainTracker)MainTrackerClass.java 
		sudo $(JCC) $(JFLAGS) $(JPATH) $(MainTracker)MainTrackerClass.java

RunShowSerialPorts:
		sudo java $(JPATH) pse.basicSerial.ShowSerialPorts

RunMainTrackerClass:
		sudo java $(JPATH) pse.mainTracker.MainTrackerClass /dev/ttyACM0