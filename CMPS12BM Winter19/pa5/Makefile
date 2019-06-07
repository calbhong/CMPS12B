#------------------------------------------------------------------------------
# Makefile for DictionaryClient.c with macros
#------------------------------------------------------------------------------

ADT     = Dictionary
EXEBIN  = $(ADT)Client
SOURCES = $(ADT).c $(EXEBIN).c
OBJECTS = $(ADT).o $(EXEBIN).o
HEADERS = $(ADT).h
CHECK = ls /afs/cats.ucsc.edu/class/cmps012b-pt.w19/pa5/cbhong
SUBMIT = submit cmps012b-pt.w19 pa5

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS) $(HEADERS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES) $(HEADERS)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS)

check:
	valgrind --leak-check=full $(EXEBIN) 

checkSubmit:
	$(CHECK)

submit: $(SOURCES)
	$(SUBMIT) $(SOURCES) README Makefile $(HEADERS) $(ADT)Test.c