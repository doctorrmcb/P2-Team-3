import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-sub-forum',
  templateUrl: './sub-forum.component.html',
  styleUrls: ['./sub-forum.component.css']
})
export class SubForumComponent implements OnInit {

  @Input() inputSubforum: string;
  constructor() { }

  ngOnInit() {
  }

}
