PathCommon=/home/pi/Development/workspace/ProgettoComunicazione
Devices=$(PathCommon)/src/pse/devices/
Pi4jImpl=$(Devices)/p4j_impl/
Serial=$(PathCommon)/src/pse/serial/
BasicSerial=$(PathCommon)/src/pse/basicSerial/

bin=/home/pi/Development/workspace/ProgettoComunicazione/bin
JCC=javac
JPATH=-cp $(bin):/usr/share/java/RXTXcomm.jar:/opt/pi4j/lib/'*'
JFLAGS=-d $(bin)

default: CommChannel.class SerialCommChannel.class ShowSerialPorts.class TestPingPong.class

ShowSerialPorts.class: $(BasicSerial)ShowSerialPorts.java 
		sudo $(JCC) $(JFLAGS) $(JPATH) $(BasicSerial)ShowSerialPorts.java

CommChannel.class: $(Serial)CommChannel.java
		sudo $(JCC) $(JFLAGS) $(Serial)CommChannel.java 

SerialCommChannel.class: $(Serial)SerialCommChannel.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(Serial)SerialCommChannel.java 

TestPingPong.class: $(BasicSerial)TestPingPong.java 
		sudo $(JCC) $(JFLAGS) $(JPATH) $(BasicSerial)TestPingPong.java

RunShowSerialPorts:
		sudo java $(JPATH) pse.basicSerial.ShowSerialPorts

RunTestPingPong:
		sudo java $(JPATH) pse.basicSerial.TestPingPong /dev/ttyACM0