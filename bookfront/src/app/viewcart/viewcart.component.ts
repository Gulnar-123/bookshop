import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Cart } from '../models/cart';
import { CartService } from '../services/cart.service';
import { Bookorder } from '../models/bookorder';
import { BookorderService } from '../services/bookorder.service';

@Component({
  selector: 'app-viewcart',
  imports: [CommonModule],
  templateUrl: './viewcart.component.html',
  styleUrl: './viewcart.component.css'
})
export class ViewcartComponent implements OnInit {
carr:Cart[]=[]
bo:Bookorder=new Bookorder()
sum=0
constructor(private cs :CartService,private bos :BookorderService)
{

}
ngOnInit(): void {
    this.cs.getall(localStorage.getItem("email")).subscribe(data=>{
      if(data!=null)
      {
        this.carr=data
      }
    })
}
confirm()
{
this.carr.forEach(ct=>{
  this.bo.booklst.push({"booktitle":ct.booktitle,"qty":ct.qty,"price":ct.amount/ct.qty,"amt":ct.amount})
  this.sum=this.sum+parseInt(ct.amount)
})
this.bo.dt=new Date()
this.bo.emailid=localStorage.getItem("email")
this.bo.status="Placed"
this.bo.totalamt=this.sum
this.bos.save(this.bo).subscribe(data=>{
  if(data!=null)
  {
   
    this.carr.forEach(ct=>{
      this.cs.del(ct.cartid).subscribe(data=>{
        alert("order placed successfully")
      })
    })
  }
})
}
}
