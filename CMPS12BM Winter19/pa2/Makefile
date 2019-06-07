JAVASRC = Queens.java
SOURCES = Makefile $(JAVASRC)
MAINCLASS = Queens
CLASSES = Queens.class
JARFILE = Queens
SUBMIT = submit cmps012b-pt.w19 pa2
CHECK = ls /afs/cats.ucsc.edu/class/cmps012b-pt.w19/pa2/cbhong

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JARFILE)

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)

submit: $(SOURCES)
	$(SUBMIT) $(SOURCES)

check:
	$(CHECK)