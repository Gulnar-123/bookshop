import { Component, OnInit } from '@angular/core';
import { Book } from '../models/book';
import { BookService } from '../services/book.service';
import { ActivatedRoute } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CartService } from '../services/cart.service';
import { Cart } from '../models/cart';

@Component({
  selector: 'app-bookdetails',
  imports: [FormsModule],
  templateUrl: './bookdetails.component.html',
  styleUrl: './bookdetails.component.css'
})
export class BookdetailsComponent implements OnInit {
b:Book=new Book()
bid:any
barr:Book[]=[]
qty=0
amt=0
c:Cart=new Cart()
constructor(private bs:BookService,private route:ActivatedRoute,private cs :CartService)
{

}
ngOnInit(): void {
    this.bid=this.route.snapshot.params["id"]
    this.bs.getAll().subscribe(data=>{
      if(data!=null)
      {
        this.barr=data
      this.b=  this.barr.filter(bk=>bk.id==this.bid)[0]
      }
    })
}
calamt()
{
  this.amt=this.b.price*this.qty
}
submitdata()
{
  this.c.email=localStorage.getItem("email")
  this.c.amount=this.amt
  this.c.booktitle=this.b.bookname
  this.c.qty=this.qty
this.cs.save(this.c).subscribe(data=>{
  if(data!=null)
  {
    alert("Book added to cart")
  }
})
}
}
