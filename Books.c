#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct{
    int bno;
    char title[50];
    char author[50];
    float price;
}Book;

void printHeading(){
    printf("%-5s%-20s%-20s%8s\n","Bno","Title","Author","Price");
}

void printBookByVal(Book b){
    printf("%-5d%-20s%-20s%8.2f\n",b.bno,b.title,b.author,b.price);
}
void printBookByRef(Book *b){
    printf("%-5d%-20s%-20s%8.2f\n",b->bno,b->title,b->author,b->price);
}

void scanBookByVal(Book b){
   	printf("\nEnter Book No:"); scanf("%d",&b.bno);getchar();
   	printf("\nEnter Title:"); scanf("%[^\n]s",b.title);getchar();
   	printf("\nEnter Author:"); scanf("%[^\n]s",b.author);getchar();
   	printf("\nEnter Price:"); scanf("%f",&b.price);getchar();
}

void scanBookByRef(Book *b){
    printf("\nEnter Book No:");
    scanf("%d",&b->bno);getchar();
    printf("\nEnter Title:");
    scanf("%[^\n]s",&b->title);getchar();
    printf("\nEnter Author:");
    scanf("%[^\n]s",&b->author);getchar();
    printf("\nEnter Price:");
    scanf("%f",&b->price);getchar();
}



int main()
{
    /*Book b1 = {101,"C Data Structures","Prakash",3400.00};
    Book b2 = {102,"C++ OOPs","Lakshmi",2800.00};
    Book b3 = {103,"Java","Anand",5600.00};
    Book b4 = {104,"Dot Net","Saranya",4900.00};
    Book b5 = {0,"N/A","N/A",0.00};
    
    //scanBookByVal(b5);
    scanBookByRef(&b5);
    
	printHeading();
    printBookByVal(b1);
    printBookByVal(b2);
    printBookByVal(b3);
    printBookByVal(b4);
    printBookByVal(b5);
    */
    
    /*Book b1,b2,b3,b4,b5;
    
    b1.bno = 101; strcpy(b1.title,"C Data Structures");	strcpy(b1.author,"Prakash");	b1.price=3400;
    b2.bno = 102; strcpy(b2.title,"C++ OOPs");			strcpy(b2.author,"Lakshmi");	b2.price=2800;
    b3.bno = 103; strcpy(b3.title,"Java");				strcpy(b3.author,"Anand");		b3.price=5600;
    b4.bno = 104; strcpy(b4.title,"Dot Net");			strcpy(b4.author,"Saranya");	b4.price=4900;
    b5.bno = 105; strcpy(b5.title,"Python");			strcpy(b5.author,"Krishna");	b5.price=5600;
 
	printHeading();
    printBookByVal(b1);
    printBookByVal(b2);
    printBookByVal(b3);
    printBookByVal(b4);
    printBookByVal(b5);
    */
    
    
    
    Book *b1 = (Book *) malloc(sizeof(Book));
    Book *b2 = (Book *) malloc(sizeof(Book));
    Book *b3 = (Book *) malloc(sizeof(Book));
    Book *b4 = (Book *) malloc(sizeof(Book));
    Book *b5 = (Book *) malloc(sizeof(Book));
    
    b1->bno = 101; strcpy(b1->title,"C Data Structures");	strcpy(b1->author,"Prakash");	b1->price=3400;
    b2->bno = 102; strcpy(b2->title,"C++ OOPs");			strcpy(b2->author,"Lakshmi");	b2->price=2800;
    b3->bno = 103; strcpy(b3->title,"Java");				strcpy(b3->author,"Anand");		b3->price=5600;
    b4->bno = 104; strcpy(b4->title,"Dot Net");				strcpy(b4->author,"Saranya");	b4->price=4900;
    b5->bno = 105; strcpy(b5->title,"Python");				strcpy(b5->author,"Krishna");	b5->price=5600;
    
    printHeading();
    printBookByRef(b1);
    printBookByRef(b2);
    printBookByRef(b3);
    printBookByRef(b4);
    printBookByRef(b5);
}

