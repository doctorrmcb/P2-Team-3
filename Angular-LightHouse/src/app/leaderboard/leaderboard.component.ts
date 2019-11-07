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

  id: string;
  lboard: Leaderboard[];
  
  constructor(private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient) { }

  ngOnInit() {

    this.id = this.id = this.route.snapshot.paramMap.get('id');
  }

}
