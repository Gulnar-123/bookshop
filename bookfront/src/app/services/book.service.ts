import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private baseUrl = 'http://localhost:9000/bookshop/books';

  constructor(private http: HttpClient) { }

  
  

  createBook(book:FormData): Observable<Object> {
   
    return this.http.post(`${this.baseUrl}`, book);
  }
  getAll() {
   
    return this.http.get<Book[]>(`${this.baseUrl}`);
  }
  deletebook(id:number){
   
    return this.http.delete(`${this.baseUrl}`+"/"+id)
  }
}
