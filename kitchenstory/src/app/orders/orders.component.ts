import { Component, OnInit } from '@angular/core';
import { Order } from '../model/order.model';
import { OrderService } from '../order.service';
import { Cart } from '../model/cart.model';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  orders:Order[];
  user:string|null = sessionStorage.getItem("username");
  constructor(private service:OrderService) { }

  ngOnInit(): void {
    this.orders = this.service.getAllOrders();
  }

}
