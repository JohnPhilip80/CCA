#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct{
    int bno;
    char title[50];
    char author[50];
    float price;
}Book;

int main(){
	
	/*Book b;
	b.bno = 101;
	strcpy(b.title,"C Data Structures");
	strcpy(b.author,"Prakash");
	b.price = 3400.00;
	printf("\n%-5d%-20s%-20s%8.2f\n",b.bno,b.title,b.author,b.price);
	*/
	
	/*Book b = {101,"C Data Structures","Prakash",3400.00};
	printf("\n%-5d%-20s%-20s%8.2f\n",b.bno,b.title,b.author,b.price);
	*/
	
	/*Book b;
	printf("\nEnter Book No:"); 
	scanf("%d",&b.bno);getchar();
    printf("\nEnter Title:"); 
	scanf("%[^\n]s",b.title);getchar();
    printf("\nEnter Author:"); 
	scanf("%[^\n]s",b.author);getchar();
    printf("\nEnter Price:"); 
	scanf("%f",&b.price);getchar();
	
	printf("\n%-5d%-20s%-20s%8.2f\n",b.bno,b.title,b.author,b.price);
	*/
	
	Book *b;
	b= (Book *) malloc(sizeof(Book));
	b->bno = 101; 
	strcpy(b->title,"C Data Structures");	
	strcpy(b->author,"Prakash");	
	b->price=3400;
	
	printf("\n%-5d%-20s%-20s%8.2f\n",b->bno,b->title,b->author,b->price);
	
	return 0;
}
