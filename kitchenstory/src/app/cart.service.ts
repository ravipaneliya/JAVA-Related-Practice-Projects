import { Injectable } from '@angular/core';
import { Cart } from './model/cart.model';
import { Product } from './model/product.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  idCounter: number = 0;
  cartItems = [{"id":0,"username":"","productname":"", "price":0.00}];
  
  constructor() { }

  addItemtoCart(cart:Cart){
    cart.id = ++this.idCounter;
    this.cartItems.push(cart);
  }

  getAllCartItems(): Cart[]{
    return this.cartItems;
  }

  clearCart(){
    this.idCounter = 0;
    this.cartItems = []
  }
}
