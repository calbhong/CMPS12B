FLAGS = -std=c99 -Wall
SOURCES = FileReverse.c
OBJECTS = FileReverse.o
EXEBIN = FileReverse
CHECK = ls /afs/cats.ucsc.edu/class/cmps012b-pt.w19/lab3/cbhong
SUBMIT = submit cmps012b-pt.w19 lab3

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS)

check:
	$(CHECK)

submit: $(SOURCES)
	$(SUBMIT) $(SOURCES) README Makefile