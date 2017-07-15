PathCommon=/home/pi/Development/workspace/ProgettoComunicazione
Devices=$(PathCommon)/src/pse/devices/
Serial=$(PathCommon)/src/pse/serial/
Pi4jImpl=$(Devices)/p4j_impl/
Common=$(PathCommon)/src/pse/common/
BasicBlinking=$(PathCommon)/src/pse/basicBlinking/
BasicButton=$(PathCommon)/src/pse/basicButton/
BlinkerWithMsg=$(PathCommon)/src/pse/blinker_with_msg/

bin=/home/pi/Development/workspace/ProgettoComunicazione/bin
JCC=javac
JPATH=-cp $(bin):/usr/share/java/RXTXcomm.jar:/opt/pi4j/lib/'*'
JFLAGS=-d $(bin)

default: Light.class Config.class Led.class \
CommChannel.class SerialCommChannel.class Event.class Tick.class \
StopMsg.class StartMsg.class Button.class ButtonPressed.class \
ButtonReleased.class Observer.class Observable.class ObservableTimer.class ObservableButton.class \
BasicEventLoopController.class Blinker.class \
InputMsgReceiver.class ControllableBlinking.class

Light.class: $(Devices)Light.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Devices)Light.java

Config.class: $(Pi4jImpl)Config.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Pi4jImpl)Config.java

Led.class: $(Pi4jImpl)Led.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Pi4jImpl)Led.java

CommChannel.class: $(Serial)CommChannel.java
		sudo $(JCC) $(JFLAGS) $(Serial)CommChannel.java

SerialCommChannel.class: $(Serial)SerialCommChannel.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Serial)SerialCommChannel.java

Event.class: $(Common)Event.java
		sudo $(JCC) $(JFLAGS) $(Common)Event.java

Tick.class: $(Devices)Tick.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Devices)Tick.java

StopMsg.class: $(BlinkerWithMsg)StopMsg.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(BlinkerWithMsg)StopMsg.java

StartMsg.class: $(BlinkerWithMsg)StartMsg.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(BlinkerWithMsg)StartMsg.java

Button.class: $(Devices)Button.java
		sudo $(JCC) $(JFLAGS) $(Devices)Button.java

ButtonPressed.class: $(Devices)ButtonPressed.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Devices)ButtonPressed.java

ButtonReleased.class: $(Devices)ButtonReleased.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Devices)ButtonReleased.java

Observer.class: $(Common)Observer.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Common)Observer.java

Observable.class: $(Common)Observable.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Common)Observable.java

ObservableTimer.class: $(Devices)ObservableTimer.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Devices)ObservableTimer.java

ObservableButton.class: $(Devices)ObservableButton.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Devices)ObservableButton.java

BasicController.class: $(Common)BasicController.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Common)BasicController.java

BasicEventLoopController.class: $(Common)BasicEventLoopController.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Common)BasicEventLoopController.java

Blinker.class: $(BlinkerWithMsg)Blinker.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(BlinkerWithMsg)Blinker.java

InputMsgReceiver.class: $(BlinkerWithMsg)InputMsgReceiver.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(BlinkerWithMsg)InputMsgReceiver.java

ControllableBlinking.class: $(BlinkerWithMsg)ControllableBlinking.java 
		sudo $(JCC) $(JFLAGS) $(JPATH) $(BlinkerWithMsg)ControllableBlinking.java

Run:
		sudo java $(JPATH) pse.blinker_with_msg.ControllableBlinking /dev/ttyACM0