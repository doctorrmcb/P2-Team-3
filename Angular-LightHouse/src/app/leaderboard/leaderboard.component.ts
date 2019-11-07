import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Leaderboard } from '../types/Leaderboard';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {

  lboard: Leaderboard[];
  options = ['Java', 'SQL', 'HTML', 'CSS', 'JavaScript'];
  
  constructor(private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient) { }

  ngOnInit() {

    let url = 'http://localhost:8080/LightHouse/leaderboard';
    let result = this.http.get<Leaderboard[]>(url, {}).subscribe(tr => {
      this.lboard = tr;
      this.lboard.sort((a, b) => (a.quizScore < b.quizScore)? 1: (a.quizScore === b.quizScore) ? ((a.timeTaken < b.timeTaken)?1:-1): -1);
    })
  }

}
