import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';
import { Cart } from '../model/cart.model';
import { Order } from '../model/order.model';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartItems:Cart[];
  user:string|null = sessionStorage.getItem("username");

  constructor(private cartService:CartService, private orderService:OrderService,private router:Router) { }

  ngOnInit(): void {
    this.cartItems = this.cartService.getAllCartItems().filter((ci) => ci.username === this.user)
  }

  orderNow(){
    if(this.cartItems.length <= 0){
      this.router.navigate(['home'])
    }
    if(this.user != null && this.user.trim().length > 0){
      var ord:Order = new Order();
      var total:number = 0;
      this.cartItems.forEach((c) => total = total + c.price)
      
      ord.cart = this.cartItems;
      ord.total = total;
      
      if(total > 0){
        this.orderService.addOrder(ord);
        
        this.cartService.clearCart();
        this.router.navigate(['myorders'])
      }
    }
  }

  clearCart(){
    this.cartItems = []
    this.cartService.clearCart();
  }
}
