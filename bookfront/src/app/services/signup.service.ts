import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Signup } from '../models/signup';

@Injectable({
  providedIn: 'root'
})
export class SignupService {
serverurl="http://localhost:9000/bookshop"
  constructor(private http:HttpClient) { }
  getall():Observable<Signup[]>
  {
    return this.http.get<Signup[]>(this.serverurl+"/signups")
  }
  save(s:Signup):Observable<Signup>
  {
    return this.http.post<Signup>(this.serverurl+"/signup",s)
  }
  del(id:any):Observable<any>
  {
    return this.http.delete(this.serverurl+"/signup/"+id)
  }
  update(id:any,s:Signup):Observable<Signup>
  {
    return this.http.put<Signup>(this.serverurl+"/signup/"+id,s)
  }
  search(id:any):Observable<Signup>
  {
    return this.http.get<Signup>(this.serverurl+"/signup/"+id)
  }
  login(em:any,ps:any):Observable<Signup>
  {
    return this.http.get<Signup>(this.serverurl+"/signup/"+em+"/"+ps)
  }
  checkemail(em:any):Observable<Signup>
  {
    return this.http.get<Signup>(this.serverurl+"/checksignup/"+em)
  }
}
