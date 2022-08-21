import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../model/product.model';
import { ProductService } from '../product.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-productdetail',
  templateUrl: './productdetail.component.html',
  styleUrls: ['./productdetail.component.css']
})
export class ProductdetailComponent implements OnInit {
  
  prod:Product;
  isProductFound:boolean = false;
  user:string|null = sessionStorage.getItem("username");
  
  constructor(private service:ProductService,private route:ActivatedRoute, private location:Location) {  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get("id");
    this.prod = this.service.getProductById(Number(id));
    if(this.prod !== undefined){
      this.isProductFound = true;
    }
  }

  goback(){
    this.location.back();
  }
}
