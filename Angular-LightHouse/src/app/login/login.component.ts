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

  elemResources = document.getElementById('resources-link');
  elemForum = document.getElementById('forum-link');
  elemQuiz = document.getElementById('quiz-link');
  elemHome = document.getElementById('home-link');
  elemProfile = document.getElementById('profile');
  /* elemSearch = document.getElementById('search'); */
  elemLogout = document.getElementById('logout');

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
          'user', this.username
        ); 
        console.log("User: " + sessionStorage.getItem('user'));
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
    this.elemResources.style.visibility = "hidden";
    this.elemForum.style.visibility = "hidden";
    this.elemQuiz.style.visibility = "hidden";
    this.elemHome.style.visibility = "hidden";
    /* this.elemSearch.style.visibility = "hidden"; */
    this.elemProfile.style.visibility = "hidden";
    this.elemLogout.style.visibility = "hidden";
  }

}
