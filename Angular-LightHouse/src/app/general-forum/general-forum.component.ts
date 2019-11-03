import { Component, OnInit } from '@angular/core';
import { JitEvaluator } from '@angular/compiler';

@Component({
  selector: 'app-general-forum',
  templateUrl: './general-forum.component.html',
  styleUrls: ['./general-forum.component.css']
})
export class GeneralForumComponent implements OnInit {

  SubForums: String[] = ['Java', 'SQL', 'HTML', 'CSS', 'JavaScript', 'General Chat', 'Questions']

  constructor() { }

  ngOnInit() {
  }

}
