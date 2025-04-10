import { Component } from '@angular/core';
import { Admin } from '../models/admin';
import { FormsModule } from '@angular/forms';
import { AdminService } from '../services/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminlogin',
  imports: [FormsModule],
  templateUrl: './adminlogin.component.html',
  styleUrl: './adminlogin.component.css'
})
export class AdminloginComponent {
s:Admin=new Admin()
constructor(private as:AdminService,private router:Router)
{

}
submitdata()
{
this.as.login(this.s.email,this.s.password).subscribe(data=>{
  if(data!=null)
  {
    alert("Login successful")
    localStorage.setItem("aemail",this.s.email)
    this.router.navigate(["/"])
  }
  else
  alert("Invalid email or pasword")
})
}
}
