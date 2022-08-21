import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddproductComponent } from './addproduct/addproduct.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';
import { LogoutComponent } from './logout/logout.component';
import { OrdersComponent } from './orders/orders.component';
import { ProductdetailComponent } from './productdetail/productdetail.component';
import { UserloginComponent } from './userlogin/userlogin.component';

const routes: Routes = [
  {path:'',redirectTo:"home",pathMatch:'full'},
  {path:'home',component:HomeComponent},
  {path:'userlogin',component:UserloginComponent},
  {path:"adminlogin",component:AdminloginComponent},
  {path:"logout",component:LogoutComponent},
  {path:"addproduct",component:AddproductComponent},
  {path:"product/:id",component:ProductdetailComponent},
  {path:"mycart",component:CartComponent},
  {path:"myorders",component:OrdersComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
