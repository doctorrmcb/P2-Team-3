import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-navbar-outer',
  templateUrl: './navbar-outer.component.html',
  styleUrls: ['./navbar-outer.component.css']
})
export class NavbarOuterComponent implements OnInit {

  username: String;

  constructor(private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.username = sessionStorage.getItem('user');
  }

}
