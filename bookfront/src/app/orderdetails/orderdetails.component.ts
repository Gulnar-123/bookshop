import { Component, OnInit } from '@angular/core';
import { BookorderService } from '../services/bookorder.service';
import { ActivatedRoute } from '@angular/router';
import { Bookorder } from '../models/bookorder';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-orderdetails',
  imports: [CommonModule],
  templateUrl: './orderdetails.component.html',
  styleUrl: './orderdetails.component.css'
})
export class OrderdetailsComponent implements OnInit {
  ono=0
  bo:Bookorder=new Bookorder()
constructor( private bs:BookorderService,private route:ActivatedRoute)
{

}
ngOnInit(): void {
    this.ono=this.route.snapshot.params["id"]
    this.bs.search(this.ono).subscribe(data=>{
      if(data!=null)
      this.bo=data
    })
}
}
