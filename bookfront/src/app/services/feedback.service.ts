import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Feedback } from '../models/feedback';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  serverurl="http://localhost:9000/bookshop"
  constructor(private http:HttpClient) { 

  }

   getall():Observable<Feedback[]>
    {
      return this.http.get<Feedback[]>(this.serverurl+"/feedback")
    }
    save(s:Feedback):Observable<Feedback>
    {
      return this.http.post<Feedback>(this.serverurl+"/feedback",s)
    }
    del(id:any):Observable<any>
    {
      return this.http.delete(this.serverurl+"/feedback/"+id)
    }
}
