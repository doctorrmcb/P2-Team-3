import { Component, OnInit } from '@angular/core';
import { JitEvaluator } from '@angular/compiler';
import { Forum } from '../types/Forum';

@Component({
  selector: 'app-general-forum',
  templateUrl: './general-forum.component.html',
  styleUrls: ['./general-forum.component.css']
})
export class GeneralForumComponent implements OnInit {

  Forums: Forum[] = [
    {title: 'Languages',
     subforum: ['Java', 'SQL', 'HTML', 'CSS', 'JavaScript']}, 
    {title: 'General Chat',
      subforum: ['Random', 'Movies', 'Music', 'Things to Do']},
    {title: 'Questions',
      subforum: ['Trainer Questions', 'Quiz Questions', 'General Questions']}]

  constructor() { }

  ngOnInit() {
  }

}
