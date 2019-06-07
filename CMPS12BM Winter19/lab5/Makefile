ADT_NAME  = Dictionary
SOURCES   = $(ADT_NAME).c $(ADT_NAME)Client.c 
OBJECTS   = $(ADT_NAME).o $(ADT_NAME)Client.o 
HEADERS   = $(ADT_NAME).h
EXEBIN    = $(ADT_NAME)Client
FLAGS     = -std=c99 -Wall
CHECK = ls /afs/cats.ucsc.edu/class/cmps012b-pt.w19/lab5/cbhong
SUBMIT = submit cmps012b-pt.w19 lab5

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS) $(HEADERS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES) $(HEADERS)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS)

check:
	valgrind --leak-check=full $(EXEBIN) 
	$(CHECK)

submit: $(SOURCES)
	$(SUBMIT) $(SOURCES) README Makefile $(ADT_NAME)Test.c $(ADT_NAME).h