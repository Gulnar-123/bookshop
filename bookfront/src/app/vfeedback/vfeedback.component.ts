import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RatingComponent } from '../rating/rating.component';
import { Feedback } from '../models/feedback';
import { FeedbackService } from '../services/feedback.service';

@Component({
  selector: 'app-vfeedback',
  imports: [FormsModule,CommonModule,RatingComponent],
  templateUrl: './vfeedback.component.html',
  styleUrl: './vfeedback.component.css'
})
export class VfeedbackComponent implements OnInit {
farr:Feedback[]=[]

constructor(private as:FeedbackService)
{

}
ngOnInit(): void {
    this.fetchfeedback()
    
}
fetchfeedback()
{
  this.as.getall().subscribe(data=>{
    if(data!=null)
      this.farr=data
  })
}
}
