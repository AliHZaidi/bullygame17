JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		


default:
	javac **/*.java -d bin/

classes: $(CLASSES:.java=.class)

run:
	java -classpath bin/ Application	