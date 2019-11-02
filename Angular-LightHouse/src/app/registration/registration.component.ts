import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  username: ""
  password: ""
  fullName: ""
  emailName: ""
  backtologin = "Back to login";
  register = "register";
  constructor(
    private route: ActivatedRoute,
  private router: Router,
  private http: HttpClient
  ) { }

  ngOnInit() {
    sessionStorage.setItem('token', '');
  }
  onBack(): void {
    this.router.navigate(['']);
  }
  onRegister(): void {
    let url = 'http://localhost:8080/LightHouse/register';
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
        alert("Registration failed.");
      }
    });
  }
}
