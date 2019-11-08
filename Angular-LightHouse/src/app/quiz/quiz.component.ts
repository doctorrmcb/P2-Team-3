import { Component, OnInit } from '@angular/core';
import { Question } from '../types/Question';
import { element } from 'protractor';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {
  templateUnchecked = false;
  templateChecked = true;
  template = true;

  questions: Question[];

  getCheckboxesValue() {
    console.log('ngModel value', this.template);
  }
  constructor() { }

  ngOnInit() {

   // console.log(history.state[0]);
    //console.log(history.state[1]);
    this.questions = history.state[0];
   // console.log("quiz: " + this.questions);

  }

  submitQuiz(selected) {
    for (let i = 0; i < 10; i++) {
      let elemForm = document.getElementById("#formGroup[" + i + "]");
      
    }
    
  }

}
