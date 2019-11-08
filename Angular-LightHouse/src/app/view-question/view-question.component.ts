import { Component, OnInit } from '@angular/core';
import {Injectable} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Category } from '../types/Category';
import { QList } from '../types/QList';

@Component({
  selector: 'app-view-question',
  templateUrl: './view-question.component.html',
  styleUrls: ['./view-question.component.css']
})

@Injectable()
export class ViewQuestionComponent implements OnInit {

  selected: string;
  categories: Category[];
  questions: QList[];
  
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient
  ) { }

  ngOnInit() {
    this.selected = "Java";
    this.getCategories();
    this.getQuestions();
  }

  getCategories(){
    let url = 'http://localhost:8080/LightHouse/category/';
    let result = this.http.get<Category[]>(url, {}).subscribe(cr =>{
      this.categories = cr;
    });
  }

  getQuestions(){
    let url = 'http://localhost:8080/LightHouse/viewQuestions/' + this.selected;
    let result = this.http.get<QList[]>(url, {}).subscribe(cr =>{
      this.questions = cr;
    });
  }
}
