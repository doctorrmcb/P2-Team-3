import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(
    private router: Router
  ) { }

  ngOnInit() {
    console.log(sessionStorage.getItem('user'));
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
