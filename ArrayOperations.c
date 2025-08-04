/*basic operations supported by an array.
 Traverse − print all the array elements one by one.
 Insertion − Adds an element at the given index.
 Deletion − Deletes an element at the given index.
 Search − Searches an element using the given index or by the value.
 Update − Updates an element at the given index.
*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

typedef struct{
    int bno;
    char title[50];
    char author[50];
    float price;
}Book;

void addBook(Book **books,Book *book,int index){
    books[index] = book;
}
void readBooks(Book **books,int bookCount){
    printf("%-5s%-20s%-20s%8s\n","Bno","Title","Author","Price");
    int i;
    for(i=0;i<bookCount;i++){
        printf("%-5d%-20s%-20s%8.2f\n",books[i]->bno,books[i]->title,books[i]->author,books[i]->price);
    }
}
void insertBook(Book **books, Book *book,int index,int bookCount){
	while(bookCount > index)
	{
		books[bookCount] = books[bookCount-1];
		bookCount--;
	}
	books[bookCount] = book;
}
void deleteBook(Book **books, int index,int bookCount){
	while(index < bookCount){
		books[index] = books[index+1];
		index++;
	}
}
Book* searchBook(Book **books,char *title,int bookCount){
	int i=0;
	Book *b=NULL;
	for(i=0;i<bookCount;i++){
		if(strcmp(books[i]->title,title) == 0){
			b=books[i];
		}
	}
	return b;
}
void updateBook(Book **books,Book *book,int index){
	books[index] = book;
}
int main()
{
    Book **books;
	books = (Book **) malloc(10 * sizeof(Book *));
        
    Book b1 = {101,"C Data Structures","Prakash",3400.00};
    Book b2 = {102,"C++ OOPs","Lakshmi",2800.00};
    Book b3 = {103,"Java","Anand",5600.00};
    Book b4 = {104,"Dot Net","Saranya",4900.00};
    Book b5 = {203,"HTML","Pooja",3500.00};
    
    addBook(books,&b1,0);
    addBook(books,&b2,1);
    addBook(books,&b3,2);
    addBook(books,&b4,3);
    
    printf("Before Insert:\n");
    readBooks(books,4);
    insertBook(books,&b5,2,5);
	printf("After Insert:\n");
   	readBooks(books,5);
   	deleteBook(books,1,5);
   	printf("After Delete book at index 1:\n");
   	readBooks(books,4);
   	
   	printf("Searching for book title Jaba\n");
   	Book *book = searchBook(books,"Jaba",4);
   	if(book != NULL)
   		printf("%-5d%-20s%-20s%8.2f\n",book->bno,book->title,book->author,book->price);
   	else
   		printf("Book Not Found!\n");
   	
   	Book b6 = {203,"CSS","Pooja Rani",3500.00};
   	updateBook(books,&b6,1);
   	printf("After Updating Book at index 1:\n");
   	readBooks(books,4);
}
