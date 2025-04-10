import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ViewbooksComponent } from './viewbooks/viewbooks.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { LoginComponent } from './login/login.component';
import { MngbooksComponent } from './mngbooks/mngbooks.component';
import { RegisterComponent } from './register/register.component';
import { VfeedbackComponent } from './vfeedback/vfeedback.component';
import { ViewcartComponent } from './viewcart/viewcart.component';
import { VordersComponent } from './vorders/vorders.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { BookdetailsComponent } from './bookdetails/bookdetails.component';
import { OrderdetailsComponent } from './orderdetails/orderdetails.component';

export const routes: Routes = [
    {path:'',component:HomeComponent},
    {path:'books',component:ViewbooksComponent},
    {path:'feedback',component:FeedbackComponent},
    {path:'login',component:LoginComponent},
    {path:'mngbooks',component:MngbooksComponent},
    {path:'register',component:RegisterComponent},
    {path:'vfeedback',component:VfeedbackComponent},
    {path:'viewcart',component:ViewcartComponent},
    {path:'vorders',component:VordersComponent},
    {path:'alogin',component:AdminloginComponent},
    {path:'bookdetails/:id',component:BookdetailsComponent},
    {path:'orderdetails/:id',component:OrderdetailsComponent},
];
