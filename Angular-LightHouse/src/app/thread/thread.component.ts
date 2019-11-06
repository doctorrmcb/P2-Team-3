import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Post } from '../types/Post';

@Component({
  selector: 'app-thread',
  templateUrl: './thread.component.html',
  styleUrls: ['./thread.component.css']
})
export class ThreadComponent implements OnInit {

  id: string;
  title = "";
  posts: Post[];
  //thread: Thread;

  constructor(private route: ActivatedRoute,
    private http: HttpClient) { }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.title = this.route.snapshot.paramMap.get('title');
    //this.thread = this.route.snapshot.paramMap.get('thread');
    this.getPosts();
  }

  getPosts() {
    let url = 'http://localhost:8080/LightHouse/post/' + this.title;
    let result = this.http.get<Post[]>(url, {}).subscribe(cr => {
      this.posts = cr;
        //alert("Authentication failed.");
      
    });
  }

}
