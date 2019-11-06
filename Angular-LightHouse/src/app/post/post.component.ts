import { Component, OnInit, Input } from '@angular/core';
import { Post } from '../types/Post';


@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  @Input() inputPost: Post;
  contents: string;
  username: string;
  postDate: string;
  postTime: string;

  constructor() { }

  ngOnInit() {
    this.contents = this.inputPost.contents;
    this.username = this.inputPost.postedBy.username;
    this.postDate = this.inputPost.postDate[0].toString() + "/" + this.inputPost.postDate[1].toString() + "/" + this.inputPost.postDate[2].toString();
    this.postTime = this.inputPost.postTime[0].toString() + ":" + this.inputPost.postTime[1];
  }

}
