import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';
import { Cart } from '../model/cart.model';
import { Product } from '../model/product.model';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  isadmin:string|null = sessionStorage.getItem("isadmin");
  user:string|null = sessionStorage.getItem("username");
  isAdminLoggedIn:boolean = false;
  products:any[];
  
  constructor(private service:ProductService, private cartService:CartService) {}

  ngOnInit(): void {
    this.loadAllProducts();
  }

  loadAllProducts(){
    this.products = this.service.getAllProducts();
    if(this.user != null && this.user.trim().length > 0){
      if(this.isadmin != null && this.isadmin === "y"){
        this.isAdminLoggedIn = true;
      }
    }
  }

  updateProduct(id:number, name:string, detail:string, price:number){
    this.service.updateProduct(id,name,detail,price)
  }

  deleteProduct(id:number){
    this.service.deleteProduct(id);
    this.products = this.service.getAllProducts();
  }

  addItemtoCart(name:string, price:number){
    if(this.user != null && this.user.trim().length > 0){
      var cart:Cart = new Cart();
      cart.username = this.user?.toString();
      cart.productname = name;
      cart.price = price;
      this.cartService.addItemtoCart(cart);
      alert("Item Added To Cart.")
    } else {
      alert("Please Login To Add Items Into Cart.")
    }
  }
}
