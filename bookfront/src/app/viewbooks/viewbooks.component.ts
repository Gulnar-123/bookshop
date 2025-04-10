import { Component, OnInit } from '@angular/core';
import { Book } from '../models/book';
import { BookService } from '../services/book.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-viewbooks',
  imports: [CommonModule,FormsModule],
  templateUrl: './viewbooks.component.html',
  styleUrl: './viewbooks.component.css'
})
export class ViewbooksComponent implements OnInit {
barr:Book[]=[]
islogin=false
qty=0
amt=0
constructor(private bs:BookService,private router:Router)
{

}
ngOnInit(): void {
    this.fetchbooks()
    if(localStorage.getItem("email")!=null)
      this.islogin=true
}
fetchbooks()
{
  this.bs.getAll().subscribe(data=>{
    if(data!=null)
    {
      this.barr=data
    }
  })
}
calamt(pr:any)
{
  this.amt=pr*this.qty
}
showdetails(id:any)
{
this.router.navigate(["/bookdetails",id])
}
}