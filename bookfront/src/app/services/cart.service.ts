import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Cart } from '../models/cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  serverurl="http://localhost:9000/bookshop"
  constructor(private http:HttpClient) { }
  getall(em:any):Observable<Cart[]>
  {
    return this.http.get<Cart[]>(this.serverurl+"/cart/"+em)
  }
  save(s:Cart):Observable<Cart>
  {
    return this.http.post<Cart>(this.serverurl+"/cart",s)
  }
  del(id:any):Observable<any>
  {
    return this.http.delete(this.serverurl+"/cart/"+id)
  }
  update(id:any,s:Cart):Observable<Cart>
  {
    return this.http.put<Cart>(this.serverurl+"/cart/"+id,s)
  }
  
}
