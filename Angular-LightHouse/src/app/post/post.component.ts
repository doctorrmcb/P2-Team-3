import { Component, OnInit, Input } from '@angular/core';
import { Post } from '../types/Post';


@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  @Input() inputPost: Post;
  constructor() { }

  ngOnInit() {
  }

}
