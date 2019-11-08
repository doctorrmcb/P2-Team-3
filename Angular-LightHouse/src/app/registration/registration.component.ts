import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ControllerResponse } from '../types/ControllerResponse';


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
  response: string;
  constructor(
    private route: ActivatedRoute,
  private router: Router,
  private http: HttpClient
  ) { }

  elemResources = document.getElementById('resources-link');
  elemForum = document.getElementById('forum-link');
  elemQuiz = document.getElementById('quiz-link');
  elemHome = document.getElementById('home-link');
  elemSearch = document.getElementById('search');
  elemLogout = document.getElementById('logout');

  ngOnInit() {
    sessionStorage.setItem('token', '');
    this.elemResources.style.visibility = "hidden";
    this.elemForum.style.visibility = "hidden";
    this.elemQuiz.style.visibility = "hidden";
    this.elemHome.style.visibility = "hidden";
    this.elemSearch.style.visibility = "hidden";
    this.elemLogout.style.visibility = "hidden";
  }
  onBack(): void {
    this.router.navigate(['']);
  }
  onRegister(): void {
    let url = 'http://localhost:8080/LightHouse/register';
    let result = this.http.post<ControllerResponse>(url, {
      username: this.username,
      password: this.password,
      fullName: this.fullName,
      emailName: this.emailName
      
    }).subscribe(cr => {
      if (cr.response === "registered") {
        console.log("Response: " + cr.response);
        sessionStorage.setItem(
          'token',
          btoa(this.username + ":" + this.password)
        );
        this.router.navigate(['home']);
      } else {
        console.log("Response: " + cr.response);
        this.response = cr.response;
        alert("Registration failed.");
      }
    });
  }
}
