import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../cart.service';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})

export class LogoutComponent implements OnInit {

  constructor(private router:Router,private cartService:CartService, private orderService:OrderService) { 
    sessionStorage.clear();
  }
  
  ngOnInit(): void {
    this.cartService.clearCart()
    this.orderService.clearOrders()
    setTimeout(()=>{this.router.navigate(['home'])},2000);
  }
}
