import { Component, OnInit } from '@angular/core';
import {Injectable} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Category } from '../types/Category';
import { Question } from '../types/Question';
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
  questions: Question[];
  
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient) { }

    ngOnInit() {
      this.selected = "Java";
      this.getCategories();
    }

    getCategories(){
      let url = 'http://localhost:8080/LightHouse/take-quiz/';
      let result = this.http.get<Category[]>(url, {}).subscribe(cr =>{
        this.categories = cr;
      });
    }

    startQuiz(category) {
      let url = 'http://localhost:8080/LightHouse/quiz/' + this.selected;
      let result = this.http.get<Question[]>(url, {}).subscribe(cr =>{
        this.questions = cr;
       // console.log("cr: " + cr);
      //  console.log("cr[0].questionName: " + cr[0].questionName);
       // console.log('take-quiz: ' + this.questions);
        this.router.navigate(['quiz'], {state: [this.questions]})
      });
    }
  
}
