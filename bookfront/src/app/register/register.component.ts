import { Component } from '@angular/core';
import { Signup } from '../models/signup';
import { FormsModule } from '@angular/forms';
import { SignupService } from '../services/signup.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register',
  imports: [FormsModule,CommonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
s:Signup=new Signup()

constructor(private ss:SignupService)
{
  
}
submitdata(regForm:any)
{
  if(regForm.valid)
  {
  this.ss.checkemail(this.s.email).subscribe(data=>{
    console.log(JSON.stringify(data))
    if(data!=null)
    {
      alert("this email is already registerd")
      return
    }
    else
    {
      this.ss.save(this.s).subscribe(data=>{
        if(data!=null)
          alert("Registration successful")
      })
    }
  })
}
else
alert("Please input valid data")
}
}
