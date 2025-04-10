import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Signup } from '../models/signup';
import { SignupService } from '../services/signup.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
s:Signup=new Signup()

constructor(private ss:SignupService,private router:Router)
{

}

submitdata()
{
this.ss.login(this.s.email,this.s.password).subscribe(data=>{
  if(data!=null)
  {
    alert("Login successful")
    localStorage.setItem("email",this.s.email)
   this.router.navigate(["/"])
  }
  else
  {
    alert("Invalid emailid or password")
  }
})
}
}
