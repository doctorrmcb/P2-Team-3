import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ControllerResponse } from '../types/ControllerResponse';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  title = 'Welcome to LightHouse';
  username: ""
  password: ""
  response: string;
  login = "log In";
  register = "register";


  onRegister(): void{
    this.router.navigate(['registration']);
    }
  onLogin(): void {
    
    let url = 'http://localhost:8080/LightHouse/login';
    let result = this.http.post<ControllerResponse>(url, {
      username: this.username,
      password: this.password
    }).subscribe(cr => {
      if (cr.response === "success") {
        console.log("Response" + cr.response);
        sessionStorage.setItem(
          'token',
          btoa(this.username + ":" + this.password)
        );
        this.router.navigate(['home']);
      } else {
        console.log("Response" + cr.response);
        this.response = cr.response;
        //alert("Authentication failed.");
      }
    });
  }

  constructor(
  private route: ActivatedRoute,
  private router: Router,
  private http: HttpClient
    
    
  ) { }

  ngOnInit() {
    sessionStorage.setItem('token', '');
  }

}
