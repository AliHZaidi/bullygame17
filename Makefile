JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		


default:
	javac src/game/*.java src/locations/*.java -d bin/

classes: $(CLASSES:.java=.class)

run:
	java -classpath bin/ game.Application	