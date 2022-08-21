import { Injectable } from '@angular/core';
import { Cart } from './model/cart.model';
import { Order } from './model/order.model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  idCounter: number = 0;
  orderList = [{"id":++this.idCounter,"cart":[{"id":++this.idCounter,"username":"test","productname":"Test", "price":7.00}],"total":7.00}];
  
  constructor() { }

  addOrder(order:Order){
    order.id = ++this.idCounter;
    this.orderList.push(order);
  }

  getAllOrders(): Order[]{
    return this.orderList;
  }

  clearOrders(){
    this.idCounter = 0;
    this.orderList = [];
  }
}
