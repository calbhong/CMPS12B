FLAGS = -std=c99 -Wall
SOURCES = charType.c
OBJECTS = charType.o
EXEBIN = charType
CHECK = ls /afs/cats.ucsc.edu/class/cmps012b-pt.s19/lab4/cbhong
SUBMIT = submit cmps012b-pt.s19 lab4

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS)
	gcc -o $(EXEBIN) $(OBJECTS)

$(OBJECTS) : $(SOURCES)
	gcc -c $(FLAGS) $(SOURCES)

clean :
	rm -f $(EXEBIN) $(OBJECTS)

check:
	valgrind --leak-check=full $(EXEBIN) in out

submit: $(SOURCES)
	$(SUBMIT) $(SOURCES) README Makefile