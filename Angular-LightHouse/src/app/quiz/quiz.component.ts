import { Component, OnInit } from '@angular/core';
import { Question } from '../types/Question';

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

    this.questions = history.state;
    console.log("quiz: " + this.questions);

  }

}
