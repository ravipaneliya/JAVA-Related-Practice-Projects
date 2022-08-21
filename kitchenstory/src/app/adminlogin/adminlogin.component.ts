import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})

export class AdminloginComponent implements OnInit {

  loginForm: FormGroup;
  submitted: boolean = false;
  
  constructor(private builder: FormBuilder, private router:Router) { }

  ngOnInit(): void {
    this.loginForm = this.builder.group({
      username: ['', Validators.required],
      password: ['',[Validators.required]]
    })
  }
  get form() {
    return this.loginForm.controls;
  }

  onSubmit(){
    this.submitted = true;
    
    if (this.loginForm.invalid)
      return;
    else {
      sessionStorage.setItem("isadmin","y");
      sessionStorage.setItem("username",this.loginForm.controls['username'].value);
      sessionStorage.setItem("password",this.loginForm.controls['password'].value);
      this.router.navigate(['home'])
    }
  }
}
