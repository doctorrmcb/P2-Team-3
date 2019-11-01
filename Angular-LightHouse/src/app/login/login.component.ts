import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

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
    console.log("clicking");
  }
  onLogin(): void {
    console.log(this.username);
    console.log(this.password);
    console.log("CLICK!!!");

    let url = 'http://localhost8080/login';
  }

  constructor(
  private route: ActivatedRoute,
  private router: Router
    
    
  ) { }

  ngOnInit() {
  }

}
