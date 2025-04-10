import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Bookorder } from '../models/bookorder';

@Injectable({
  providedIn: 'root'
})
export class BookorderService {
  serverurl="http://localhost:9000/bookshop"
  constructor(private http:HttpClient) { }
  getall():Observable<Bookorder[]>
  {
    return this.http.get<Bookorder[]>(this.serverurl+"/bookorder")
  }
  save(s:Bookorder):Observable<Bookorder>
  {
    return this.http.post<Bookorder>(this.serverurl+"/bookorder",s)
  }
  del(id:any):Observable<any>
  {
    return this.http.delete(this.serverurl+"/bookorder/"+id)
  }
  update(id:any,s:Bookorder):Observable<Bookorder>
  {
    return this.http.put<Bookorder>(this.serverurl+"/bookorder/"+id,s)
  }
  search(id:any):Observable<Bookorder>
  {
    return this.http.get<Bookorder>(this.serverurl+"/bookorder/"+id)
  }
  userorder(em:any):Observable<Bookorder>
  {
    return this.http.get<Bookorder>(this.serverurl+"/bookorderemail/"+em)
  }
}
