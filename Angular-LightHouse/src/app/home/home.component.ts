import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  elemResources = document.getElementById('resources-link');
  elemForum = document.getElementById('forum-link');
  elemQuiz = document.getElementById('quiz-link');
  elemHome = document.getElementById('home-link');
  elemSearch = document.getElementById('search');
  elemProfile = document.getElementById('profile');
  elemLogout = document.getElementById('logout');

  constructor(
    private router: Router
  ) { }

  ngOnInit() {

    this.elemResources.style.visibility = "visible";
    this.elemForum.style.visibility = "visible";
    this.elemQuiz.style.visibility = "visible";
    this.elemHome.style.visibility = "visible";
    //this.elemSearch.style.visibility = "visible";
    this.elemProfile.style.visibility = "visible";
    this.elemLogout.style.visibility = "visible";

  }

  toQuiz(): void{
    this.router.navigate(['take-quiz']);
  }

  toResources(): void{
    this.router.navigate(['resources']);
  }

  toForums(): void{
    this.router.navigate(['general-forum']);
  }
}
