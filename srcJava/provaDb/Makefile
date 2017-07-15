PathCommon=/home/pi/Development/workspace/ProgettoComunicazione
ProvaDb=$(PathCommon)/src/pse/provaDb/

bin=/home/pi/Development/workspace/ProgettoComunicazione/bin
JCC=javac -Xlint
JPATH=-cp $(bin):$(PathCommon)/lib/mysql-connector-java-5.1.39.jar
JFLAGS=-d $(bin)

default: Config.class NotTempOrPresException.class LetturaDati.class \
ManageDb.class InsDb.class

Config.class: $(ProvaDb)Config.java
		sudo $(JCC) $(JFLAGS) $(ProvaDb)Config.java

NotTempOrPresException.class: $(ProvaDb)NotTempOrPresException.java
		sudo $(JCC) $(JFLAGS) $(ProvaDb)NotTempOrPresException.java

LetturaDati.class: $(ProvaDb)LetturaDati.java
		sudo $(JCC) $(JPATH) $(JFLAGS) $(ProvaDb)LetturaDati.java

ManageDb.class: $(ProvaDb)ManageDb.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(ProvaDb)ManageDb.java

InsDb.class: $(ProvaDb)InsDb.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(ProvaDb)InsDb.java

AutomaticInsDb.class: $(ProvaDb)AutomaticInsDb.java
		sudo $(JCC) $(JFLAGS) $(JPATH) $(ProvaDb)AutomaticInsDb.java

RunInsDb:
		sudo java $(JPATH) pse.provaDb.InsDb

RunAutomaticInsDb:
		sudo java $(JPATH) pse.provaDb.AutomaticInsDb