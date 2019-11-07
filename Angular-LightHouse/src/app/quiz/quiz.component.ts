import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {
  templateUnchecked = false;
  templateChecked = true;
  template = true;

  getCheckboxesValue() {
    console.log('ngModel value', this.template);
  }
  constructor() { }

  ngOnInit() {
  }

}
