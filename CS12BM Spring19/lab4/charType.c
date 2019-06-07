#include<stdio.h>
#include<ctype.h>
#include<stdlib.h>
#include<string.h>

void extract_chars(char* s, char* a, char* d, char* p, char* w);	

int main(int argc, char* argv[]){
	FILE* in;		//in file
	FILE* out;		//out file
	char *a;
	char *d;
	char *p;
	char *w;

	int lineNum = 1;
	char input[256];

	//makes sure command line unput is correct if not error
	if(argc != 3){
		printf("Usage: %s <input file> <output file>\n", argv[0]);
		exit(EXIT_FAILURE);
	}

	//opens reading file
	in = fopen(argv[1], "r"); // "r" for read input file
	if(in == NULL){												
		printf("Unable to read file %s\n", argv[1]);
		exit(EXIT_FAILURE);
	}

	//opens writing file
	out = fopen(argv[2], "w"); // "w" for writing output file
	if(out == NULL){
		printf("Unable to write to file %s\n", argv[2]);
		exit(EXIT_FAILURE);
	}

	//
	while(!feof(in)){  //f stands for file
		fscanf(in, "%[^\n]\n", input);					
		fprintf(out,"line %d contains:\n",lineNum);		
		lineNum++;										

		a = calloc(strlen(input), sizeof(char));
		d = calloc(strlen(input), sizeof(char));		
		p = calloc(strlen(input), sizeof(char));		
		w = calloc(strlen(input), sizeof(char));		

		extract_chars(input, a, d, p, w);				
		
		if(strlen(a) == 1){
			fprintf(out,"%ld alphabetic character: %s\n", strlen(a), a);
		}
		else{
			fprintf(out,"%ld alphabetic characters: %s\n", strlen(a), a);						
		}
		//
		if(strlen(d) == 1){
			fprintf(out,"%ld numeric character: %s\n", strlen(d), d);
		}
		else{
			fprintf(out,"%ld numeric characters: %s\n", strlen(d), d);					
		}
		//
		if(strlen(p) == 1){
			fprintf(out,"%ld punctuation character: %s\n", strlen(p), p);
		}
		else{
			fprintf(out,"%ld punctuation characters: %s\n", strlen(p), p);			
		}	
		//
		if(strlen(w) == 0){	
			fprintf(out,"%ld whitespace character: %s\n", strlen(w)+1, w);		
		}
		else{
			fprintf(out,"%ld whitespace characters: %s\n", strlen(w)+1, w);			
		}	

		fprintf(out,"\n");

		free(a);								
		free(d);								
		free(p);
		free(w);
		a = NULL;
		d = NULL;
		p = NULL;
		w = NULL;
	}

	
	//closes files
	fclose(in);
	fclose(out); 
	//close program
	return(EXIT_SUCCESS);
}

void extract_chars(char* input, char* a, char* d, char* p, char* w){
	int j = 0;
	int k = 0;						
	int l = 0;
	int m = 0;

	for(int i = 0; i < strlen(input); i++){
		if(isalpha(input[i])){
			a[j] = input[i];					//indexs are incremented ever time element
			j++;								//is placed in array
		}

		if(isdigit(input[i])){
			d[k] = input[i];					//input is set equal to the first avaliable
			k++;								//place in array if isX tests true
		}

		if(ispunct(input[i])){
			p[l] = input[i];
			l++;
		}
		if(isspace(input[i])){
			w[m] = input[i];
			m++;
		}
	}
}

