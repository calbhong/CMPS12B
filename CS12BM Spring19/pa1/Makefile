JAVASRC = Subset.java
SOURCES = Makefile $(JAVASRC)
MAINCLASS = Subset
CLASSES = Subset.class
JARFILE = Subset
SUBMIT = submit cmps012b-pt.s19 pa1
CHECK = ls /afs/cats.ucsc.edu/class/cmps012b-pt.s19/pa1/cbhong

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