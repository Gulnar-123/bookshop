import { Component, OnInit } from '@angular/core';
import { Bookorder } from '../models/bookorder';
import { BookorderService } from '../services/bookorder.service';
import { Route, Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-vorders',
  imports: [CommonModule],
  templateUrl: './vorders.component.html',
  styleUrl: './vorders.component.css'
})
export class VordersComponent implements OnInit{
barr:Bookorder[]=[]

constructor(private bos:BookorderService,private router:Router)
{

}
ngOnInit(): void {
    this.bos.getall().subscribe(data=>{
      if(data!=null)
      {
        this.barr=data
      }
    })
}
showdetails(ono:any)
{
this.router.navigate(["/orderdetails",ono])
}
}