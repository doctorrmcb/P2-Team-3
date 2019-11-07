import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-delete-question',
  templateUrl: './delete-question.component.html',
  styleUrls: ['./delete-question.component.css']
})
export class DeleteQuestionComponent implements OnInit {
  options =['Java8', 'Html', 'CSS', 'PostgreSQL', 'JavaScript']
  selected: string;
  constructor() { }

  ngOnInit() {
  }

}
