#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"Dictionary.h"

#define MAX_LEN 180

int main(int argc, char* argv[]){
	Dictionary A = newDictionary();
	char* k;
	char* v;
	char* word1[] = {"one","two","three","four"};
	char* word2[] = {"test1","test2","test3","test4"};
	int i;

	for(i=0; i<4; i++){
		insert(A, word1[i], word2[i]);
	}

	printDictionary(stdout, A);

	for(i=0; i<4; i++){
		k = word1[i];
		v = lookup(A, k);
		printf("key=\"%s\" %s\"%s\"\n", k, (v==NULL?"not found ":"value="), v);
	}

	delete(A, "1");
	delete(A, "3");

	printDictionary(stdout, A);

	for(i=0; i<4; i++){
		k = word1[i];
		v = lookup(A, k);
		printf("key=\"%s\" %s\"%s\"\n", k, (v==NULL?"not found ":"value="), v);
	}

	printf("%s\n", (isEmpty(A)?"true":"false"));
	printf("%d\n", size(A));
	makeEmpty(A);
	printf("%s\n", (isEmpty(A)?"true":"false"));

	freeDictionary(&A);

	return(EXIT_SUCCESS);
}