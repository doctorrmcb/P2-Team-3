import { Component, OnInit } from '@angular/core';
import {Injectable} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Category } from '../types/Category';
import { Question } from '../types/Question';

@Component({
  selector: 'app-view-question',
  templateUrl: './view-question.component.html',
  styleUrls: ['./view-question.component.css']
})

@Injectable()
export class ViewQuestionComponent implements OnInit {

  selected: string;
  categories: Category[];
  questions: Question[];
  
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient
  ) { }

  ngOnInit() {
    this.getCategories();
    this.getQuestions();
  }

  getCategories(){
    let url = 'http://localhost:8080/LightHouse/view-question/';
    let result = this.http.get<Category[]>(url, {}).subscribe(cr =>{
      this.categories = cr;
    });
  }

  getQuestions(){
    let url = 'http://localhost:8080/LightHouse/view-question/';
    let result = this.http.get<Question[]>(url, {}).subscribe(cr =>{
      this.questions = cr;
    });
  }
}
