//headers

#include<assert.h>
#include<string.h>
#include<stdlib.h>
#include<stdio.h>
#include "Dictionary.h"

//constant
const int tableSize = 101;
//hashtable helper fncs
unsigned int rotate_left(unsigned int value, int shift) {
	int sizeInBits = 8*sizeof(unsigned int);
	shift = shift & (sizeInBits - 1);
	if ( shift == 0 )
		return value;
	return (value << shift) | (value >> (sizeInBits - shift));
}  

unsigned int pre_hash(char* input) {
	unsigned int result = 0xBAE86554;
	while (*input) {
		result ^= *input++;
		result = rotate_left(result, 5);
	}  
	return result;
}

int hash(char* key){
	return pre_hash(key)%tableSize;
}


//Node Construct + Destruct
typedef struct NodeObj{
	char* key;
	char* value;
	struct NodeObj* next;
}NodeObj;
typedef NodeObj* Node;

Node newNode( char* x, char* y){
	Node N = malloc(sizeof(NodeObj));
	assert(N != NULL);
	N->value = y;
	N->key = x;
	N->next = NULL;
	return(N);
}

void freeNode(Node* pN){
	if(pN != NULL && *pN != NULL){
		free(*pN);
		*pN = NULL;
	}
}

//Dictionary
typedef struct DictionaryObj{
	Node *table;
	int numItems;
} DictionaryObj;

Dictionary newDictionary(){
	Dictionary D = malloc(sizeof(DictionaryObj));
	assert(D!=NULL);
	D->table = calloc(tableSize,sizeof(NodeObj));
	D->numItems = 0;
	return D;
}

void freeDictionary(Dictionary *pD){
	if(pD != NULL && *pD != NULL){
		makeEmpty(*pD);
		free((*pD)->table);
		free(*pD);
		*pD = NULL;
	}
}

int isEmpty(Dictionary D){
	if( D==NULL){
		fprintf(stderr, "Dictionary Error: calling isEmpty() on NULL Dictionary\n");
		exit(EXIT_FAILURE);
	}
	if(D->numItems>0){
		return 0;
	}
	return 1;
}

int size(Dictionary D){
	return D->numItems;
}

Node findKey(Dictionary D, char* key){
	Node N = NULL;
	if (D->numItems == 0){
		return NULL;
	}
	int i;
	for (i = 0; i < tableSize; i++){
		if (D->table[i] != NULL){
			N = D->table[i];
			break;
		}
	}
	if (strcmp(N->key, key) == 0){
		return N;
	}
	while (N->next != NULL){
		if (strcmp(N->key, key) == 0){
			return N;
		}
		N = N->next;
	}
	
	for (int j = i+1; j < tableSize; j++){
		if (D->table[j] == NULL){
			continue;
		}
		else{
			N = D->table[j];
			if (strcmp(N->key, key) == 0){
				return N;
			}
			while (N->next != NULL){
				if (strcmp(N->key, key) == 0){
					return N;
				}
				N = N->next;
			}
		}
	}
	
	return NULL;
}

char* lookup(Dictionary D, char* k){
	if (findKey(D, k) == NULL){
		return NULL;
	}
	else{
		return findKey(D, k)->value;
	}
}

void insert(Dictionary D, char* k, char* v){
	Node N;
	int index = hash(k);
	if(D == NULL){
		fprintf(stderr, "Dictionary Error: calling insert on NULL Dictionary\n");
		exit(EXIT_FAILURE);
	}
	if( findKey(D, k) != NULL){
		fprintf(stderr, "Dictionary Error: calling insert() on a pre-existing key");
		exit(EXIT_FAILURE);
	} 
	if(D->table[index] == NULL){
		D->table[index]  = newNode(k, v);
		D->numItems++; 
	}else{
		N = newNode(k, v);
		N->next = D->table[index];
		D->table[index] = N;
		D->numItems++;
	}
}

void delete(Dictionary D, char* k){
	Node N;
	Node A;
	if( findKey(D,k) == NULL ){
		fprintf(stderr, "Dictionary Error: key not found\n");
		exit(EXIT_FAILURE);
	}
	N = findKey(D,k);
	if(N == D->table[hash(k)] && N->next == NULL){
		N = NULL;
		freeNode(&N);
	}else if(N == D->table[hash(k)]){
		D->table[hash(k)] = N->next;
		N = NULL;
		freeNode(&N);
	}else{
		A = D->table[hash(k)];
		while(A->next != N){
			A = A->next;
		}
		A->next = N->next;
		freeNode(&N);

	}
	D->numItems--;
}

void makeEmpty(Dictionary D){
	for(int i = 0; i<tableSize; i++){
		while(D->table[i] != NULL){
			Node N;
			N = D-> table[i];
			D->table[i]=N->next;
			freeNode(&N);
			N = NULL;
		}
	}D->numItems = 0; 
}

void printDictionary(FILE* out, Dictionary D){
	for (int i = 0; i < tableSize; i++){
		if (D->table[i] != NULL){
			for (Node N = D->table[i]; N != NULL; N = N->next){
				fprintf(out, "%s %s\n", N->key, N->value);
			}
		}
	}
}