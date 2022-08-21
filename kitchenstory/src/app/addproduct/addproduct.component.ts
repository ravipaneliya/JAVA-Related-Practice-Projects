import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Product } from '../model/product.model';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {

  prod:Product = new Product();
  registerForm: FormGroup;
  submitted: boolean = false;
  user:string|null = sessionStorage.getItem("username");

  //builder dependency injected through constructor
  constructor(private builder: FormBuilder, 
    private service: ProductService,private router:Router) { }

  ngOnInit(): void {
    this.registerForm = this.builder.group({
      name: ['', Validators.required],
      detail: ['', [Validators.required]],
      price: ['', Validators.required],
    })
  }
  get form() {
    return this.registerForm.controls;
  }
  onSubmit() {
    this.submitted = true;
    if (this.registerForm.invalid)
      return;
    else {
      //console.log(this.user)
      this.service.addProduct(this.prod)
      this.router.navigate(['home']);
      //alert("Form submitted for the Approval ")
    }
  }
}
