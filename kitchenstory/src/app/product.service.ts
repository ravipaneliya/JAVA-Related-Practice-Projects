import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './model/product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  idCounter:number = 0;
  products = [{"id":++this.idCounter,"name":"Spoon","detail":"Eat Support For Kitchen", "price":7.00}];

  constructor() {
    // this.products.push({"id":++this.idCounter,"name":"Dish","detail":"Dry Container For Kitchen", "price":100.00});
    // this.products.push({"id":++this.idCounter,"name":"Bowl","detail":"Liquid Container For Kitchen", "price":50.00});
  }

  getAllProducts(): Product[]{
    return this.products;
  }

  getProductById(id:number):Product {
    const index = this.products.findIndex(prod=> prod.id === id);
    return this.products[index];
  }

  addProduct(prod:Product){
    prod.id = ++this.idCounter;
    this.products.push(prod);
  }

  deleteProduct(id:number){
    // way 1
    // this.products = this.products.filter(p => p.id !== id);
    
    //way 2
    let ind = this.products.findIndex((p)=> p.id === id);
    this.products.splice(ind,1);
  }

  updateProduct(id:number, name:string, detail:string, price:number){
    this.products.forEach((prod)=>{
      if(prod.id === id){
        prod.name = name;
        prod.detail = detail;
        prod.price = price;
      }
    });
  }
}
