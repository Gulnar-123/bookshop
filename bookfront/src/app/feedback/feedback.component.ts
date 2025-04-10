import { Component, OnInit } from '@angular/core';
import { Feedback } from '../models/feedback';
import { FormsModule } from '@angular/forms';
import { FeedbackService } from '../services/feedback.service';
import { CommonModule } from '@angular/common';
import { RatingComponent } from "../rating/rating.component";

@Component({
  selector: 'app-feedback',
  imports: [FormsModule, CommonModule, RatingComponent],
  templateUrl: './feedback.component.html',
  styleUrl: './feedback.component.css'
})
export class FeedbackComponent implements OnInit {
f:Feedback=new Feedback()
farr:Feedback[]=[]
islogin=false
constructor(private as:FeedbackService)
{

}
ngOnInit(): void {
    this.fetchfeedback()
    if(localStorage.getItem("email")!=null)
      this.islogin=true
}
fetchfeedback()
{
  this.as.getall().subscribe(data=>{
    if(data!=null)
      this.farr=data
  })
}
submitdata()
{
  this.f.email=localStorage.getItem("email")
  this.f.rating=parseInt(localStorage.getItem("rating")+"")
this.as.save(this.f).subscribe(data=>{
  if(data!=null){
    alert("Thanks for feedback")
this.fetchfeedback()
  }
})

}
}
