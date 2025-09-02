import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from './book';

@Injectable({
  providedIn: 'root'
})
export class Bookservice {
  private baseURL = "http://localhost:8080/book/db/api/";
  constructor(private httpClient:HttpClient){

  }
  readBooks():Observable<Book[]>{
    return this.httpClient.get<Book[]>(this.baseURL + "readbooks");
  }
  createBook(book:Book):Observable<Object>{
    return this.httpClient.post(this.baseURL + "createbook",book,{responseType:'text'});
  }
  readBook(bno: number): Observable<Book>{
    let queryParams = new HttpParams();
    queryParams = queryParams.set('bno',bno);
    return this.httpClient.get<Book>(this.baseURL + "getbookbybno",{params:queryParams});
  }

  updateBook(bno: number, book: Book): Observable<Object>{
  const params = {
        bno: bno
      };
    return this.httpClient.put(this.baseURL + "updatebook", book , {responseType:'text', params});
  }
  deleteBook(bno: number): Observable<Object>{
    const params = {
        bno: bno
      };
    return this.httpClient.delete(this.baseURL + "deletebook", {responseType:'text', params});
  }

}
