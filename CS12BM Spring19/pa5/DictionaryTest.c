#include <stdio.h>
#include <stdlib.h>
#include "Dictionary.h"

int main(void){
   DictionaryRef D = newDictionary();
   

   insert(D,24,7);
   insert(D,365,12);
   insert(D,120,10);
   insert(D,42,7);
   
   printDictionary(D,stdout);

   delete(D,24);
   delete(D,120);
   delete(D,42);
   
   printDictionary(D,stdout);
   
   makeEmpty(D);
   printDictionary(D,stdout);

}