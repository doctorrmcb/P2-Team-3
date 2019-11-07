import { Component, OnInit } from '@angular/core';
import {Injectable} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Category } from '../types/Category';
import { ControllerResponse } from '../types/ControllerResponse';
@Component({
  selector: 'app-take-quiz',
  templateUrl: './take-quiz.component.html',
  styleUrls: ['./take-quiz.component.css']
})

@Injectable()
export class TakeQuizComponent implements OnInit {

  //options =['Java8', 'Html', 'CSS', 'PostgreSQL', 'JavaScript']
  selected: string;
  categories: Category[];
  
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient) { }

    ngOnInit() {
      this.getCategories();
    }

    getCategories(){
      let url = 'http://localhost:8080/LightHouse/take-quiz/';
      let result = this.http.get<Category[]>(url, {}).subscribe(cr =>{
        this.categories = cr;
      });
    }


  
}
