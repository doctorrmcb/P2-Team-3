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
     subforum: ['Java', 'SQL', 'HTML', 'CSS', 'JavaScript'],
     descriptions: ['All things Java', 'All things SQL', 'All things HTML', 'All things CSS', 'All things JavaScript']
    }, 
    {title: 'General Chat',
      subforum: ['Random', 'Movies', 'Music', 'Things to Do'],
      descriptions: ['Anything goes', 'All things movies', 'All things music', 'Things to do locally']},
    {title: 'Questions',
      subforum: ['Trainer Questions', 'Quiz Questions', 'General Questions'],
      descriptions: ['Ask a trainer a question', 'Discuss questions from the quizzes', 'Questions about anything']}]

  constructor() { }

  ngOnInit() {
    
  }

}
