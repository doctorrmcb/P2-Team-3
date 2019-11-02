import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  title = 'Welcome to LightHouse';
  username: ""
  password: ""
  login = "Log In";
  register = "register";

  onRegister(): void{
    this.router.navigate(['registration']);
    }
  onLogin(): void {
    
    let url = 'http://localhost:8080/LightHouse/login';
    let result = this.http.post<Observable<boolean>>(url, {
      username: this.username,
      password: this.password
    }).subscribe(isValid => {
      if (isValid) {
        console.log("Truthy");
        sessionStorage.setItem(
          'token',
          btoa(this.username + ":" + this.password)
        );
        this.router.navigate(['home']);
      } else {
        console.log("Falsey");
        alert("Authentication failed.");
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
