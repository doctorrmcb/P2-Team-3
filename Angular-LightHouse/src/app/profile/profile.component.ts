import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Post } from '../types/Post';
import { ForumThread } from '../types/Thread';
import { User } from '../types/User';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  username: string;
  posts: Post[];
  threads: ForumThread[];
  user: User;

  constructor(private route: ActivatedRoute,
    private http: HttpClient) { }
  
  ngOnInit() {
    this.username = this.route.snapshot.paramMap.get('username');
    this.getUser();
    this.getPosts();
    this.getThreads();
  }

  getUser() {
    let url = 'http://localhost:8080/LightHouse/user/' + this.username ;
    let result = this.http.get<User>(url, {}).subscribe(cr => {
      this.user = cr;
    })
  }

  getPosts() {
    let url = 'http://localhost:8080/LightHouse/' + this.username + "/posts";
    let result = this.http.get<Post[]>(url, {}).subscribe(cr => {
      this.posts = this.formatDate(cr);
      this.posts.sort((a, b) => (a.orderBy > b.orderBy)?1:-1);
    });
  }

  getThreads(){
    let url = 'http://localhost:8080/LightHouse/' + this.username + "/threads";
    let result = this.http.get<ForumThread[]>(url, {}).subscribe(tr => {
      this.threads = this.formatDateThread(tr);
      this.threads.sort((a, b) => (a.orderBy < b.orderBy) ? 1: -1);
    });
  }

  formatDate(posts: Post[]): Post[]{
    for (let post of posts){
      let orderBy = "";
      orderBy += post.postDate[0];
      if (post.postDate[1].toString().length < 2){
        orderBy += '0' + post.postDate[1];
      } else{
        orderBy += post.postDate[1];
      }
      if (post.postDate[2].toString().length < 2){
        orderBy += '0' + post.postDate[2];
      } else{
        orderBy += post.postDate[2];
      }

      if (post.postTime[0].toString().length < 2){
        orderBy += '0' + post.postTime[0];
      } else{
        orderBy += post.postTime[0];
      }
      
      if (post.postTime[1].toString().length < 2){
        orderBy += '0' + post.postTime[1];
      } else{
        orderBy += post.postTime[1];
      }
      post.orderBy = Number(orderBy);
      console.log(post.orderBy);
    }
    return posts;
  }


  formatDateThread(threads: ForumThread[]): ForumThread[]{
    for (let thread of threads){
      let orderBy = "";
      orderBy += thread.lastPost[0];

      if (thread.lastPost[1].toString().length < 2){
        orderBy += '0' + thread.lastPost[1];
      } else{
        orderBy += thread.lastPost[1];
      }

      if (thread.lastPost[2].toString().length < 2){
        orderBy += '0' + thread.lastPost[2];
      } else{
        orderBy += thread.lastPost[2];
      }

      if (thread.lastPost[3].toString().length < 2){
        orderBy += '0' + thread.lastPost[3];
      } else{
        orderBy += thread.lastPost[3];
      }
      
      if (thread.lastPost[4].toString().length < 2){
        orderBy += '0' + thread.lastPost[4];
      } else{
        orderBy += thread.lastPost[4];
      }
      
      thread.orderBy = Number(orderBy);
    }
    return threads;
  }
}
