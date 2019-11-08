import { Component, OnInit, Input } from '@angular/core';
import { ThreadComponent } from '../thread/thread.component';
import { Forum } from '../types/Forum'
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-general-forum-inner',
  templateUrl: './general-forum-inner.component.html',
  styleUrls: ['./general-forum-inner.component.css']
})
export class GeneralForumInnerComponent implements OnInit {

  @Input() inputForum: Forum;
  thread: ThreadComponent;


  constructor(
    private route: ActivatedRoute,
    private router: Router) { }

  // Function that gets all links where forum general topic = inputSubforum.
  ngOnInit() {


  }

}
