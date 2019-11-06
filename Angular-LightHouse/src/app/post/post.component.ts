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
    console.log(this.inputPost);
    this.contents = this.inputPost.contents;
    this.username = this.inputPost.posted_by.username;
    this.postDate = this.inputPost.postDate[1].toString() + "/" + this.inputPost.postDate[2].toString() + "/" + this.inputPost.postDate[0].toString();
    
    let period = "AM";

    if (this.inputPost.postTime[0] > 12) {
      let hour = this.inputPost.postTime[0] - 12;
      this.postTime = hour.toString()
      period = "PM";
    } else {
      this.postTime = this.inputPost.postTime[0].toString()
    }

    this.postTime += ":";

    if (this.inputPost.postTime[1] < 10) {
      this.postTime += "0"
      this.postTime += this.inputPost.postTime[1].toString();
    } else {
      this.postTime += this.inputPost.postTime[1].toString();
    }

    this.postTime += " " + period;

  }

}
