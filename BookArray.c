#include<stdio.h>
#include<string.h>
#include<stdlib.h>
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

int main()
{
    /*Book books[5] = {
        {101,"C Data Structures","Prakash",3400.00},
        {102,"C++ OOPs","Lakshmi",2800.00},
        {103,"Core Java","Anand",5600.00},
        {104,"Java Spring Boot","Saranya",4900.00},
        {105,"Python","Krishna",5600.00}
    };
    printHeading();
    int i;
    for(i=0;i<5;i++){
    	//printBookByRef(&books[i]);
        printBookByVal(books[i]);
    }*/
    
    /*Book books[5];
    books[0].bno = 101; strcpy(books[0].title,"C Data Structures");		strcpy(books[0].author,"Prakash");	books[0].price=3400;
    books[1].bno = 102; strcpy(books[1].title , "C++ OOPs");			strcpy(books[1].author,"Lakshmi");	books[1].price=2800;
    books[2].bno = 103; strcpy(books[2].title , "Java");				strcpy(books[2].author,"Anand");	books[2].price=5600;
    books[3].bno = 104; strcpy(books[3].title , "Dot Net");				strcpy(books[3].author,"Saranya");	books[3].price=4900;
    books[4].bno = 105; strcpy(books[4].title , "Python");				strcpy(books[4].author,"Krishna");	books[4].price=5600;
    printHeading();
    int i;
    for(i=0;i<5;i++){
        //printBookByVal(books[i]);
        printBookByRef(&books[i]);
    }*/
    
    Book *books[5];
    int i;
	for(i=0;i<5;i++){
		books[i] = (Book *) malloc(sizeof(Book));
	}
    //books[0] = (Book *) malloc(sizeof(Book));
    //books[1] = (Book *) malloc(sizeof(Book));
    //books[2] = (Book *) malloc(sizeof(Book));
    //books[3] = (Book *) malloc(sizeof(Book));
    //books[4] = (Book *) malloc(sizeof(Book));
    
    books[0]->bno = 101; strcpy(books[0]->title,"C Data Structures");	strcpy(books[0]->author,"Prakash");	books[0]->price=3400;
    books[1]->bno = 102; strcpy(books[1]->title, "C++ OOPs");			strcpy(books[1]->author,"Lakshmi");	books[1]->price=2800;
    books[2]->bno = 103; strcpy(books[2]->title, "Java");				strcpy(books[2]->author,"Anand");	books[2]->price=5600;
    books[3]->bno = 104; strcpy(books[3]->title, "Dot Net");			strcpy(books[3]->author,"Saranya");	books[3]->price=4900;
    books[4]->bno = 105; strcpy(books[4]->title, "Python");				strcpy(books[4]->author,"Krishna");	books[4]->price=5600;
    
    printHeading();
    for(i=0;i<5;i++){
        printBookByRef(books[i]);
    }
    
    
	/*Book **books;
	books = (Book **) malloc(5 * sizeof(Book *));
	int i;
	for(i=0;i<5;i++){
		books[i] = (Book *) malloc(sizeof(Book));
	}
	//books[0] = (Book *) malloc(sizeof(Book));
    //books[1] = (Book *) malloc(sizeof(Book));
    //books[2] = (Book *) malloc(sizeof(Book));
    //books[3] = (Book *) malloc(sizeof(Book));
    //books[4] = (Book *) malloc(sizeof(Book));
	
	books[0]->bno = 101; strcpy(books[0]->title,"C Data Structures");		strcpy(books[0]->author,"Prakash");	books[0]->price=3400;
    books[1]->bno = 102; strcpy(books[1]->title , "C++ OOPs");			strcpy(books[1]->author,"Lakshmi");	books[1]->price=2800;
    books[2]->bno = 103; strcpy(books[2]->title , "Java");				strcpy(books[2]->author,"Anand");	books[2]->price=5600;
    books[3]->bno = 104; strcpy(books[3]->title , "Dot Net");				strcpy(books[3]->author,"Saranya");	books[3]->price=4900;
    books[4]->bno = 105; strcpy(books[4]->title , "Python");				strcpy(books[4]->author,"Krishna");	books[4]->price=5600;
    
    printHeading();
    for(i=0;i<5;i++){
        printBookByRef(books[i]);
    }*/
    
    
    
}
