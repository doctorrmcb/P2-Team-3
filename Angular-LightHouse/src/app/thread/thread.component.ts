import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Post } from '../types/Post';
import { ControllerResponse } from '../types/ControllerResponse';
import { ForumThread } from '../types/Thread';


@Component({
  selector: 'app-thread',
  templateUrl: './thread.component.html',
  styleUrls: ['./thread.component.css']
})
export class ThreadComponent implements OnInit {

  //@Input() inputThread: Thread;
  id: string;
  response: string;
  title = "";
  contents: string;
  postContents: string;
  posts: Post[];
  display = 'none';
  //thread: Thread;

  constructor(private route: ActivatedRoute,
    private http: HttpClient) { }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.title = this.route.snapshot.paramMap.get('title');
    this.getThread();
    //this.contents = this.inputThread.contents;
    //this.thread = this.route.snapshot.paramMap.get('thread');
    this.getPosts();
  }
  getThread() {
    let url = 'http://localhost:8080/LightHouse/thread/' + this.title;
    let result = this.http.get<ForumThread>(url, {}).subscribe(cr => {
      console.log(cr);
      this.contents = cr.contents;
    })
  }
  getPosts() {
    let url = 'http://localhost:8080/LightHouse/post/' + this.title;
    let result = this.http.get<Post[]>(url, {}).subscribe(cr => {
      this.posts = this.formatDate(cr);
      this.posts.sort((a, b) => (a.orderBy > b.orderBy)?1:-1);
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
  createNewPost() {
    this.display = 'block';
  }

  onCloseHandled() {

    this.display = 'none';

  }

  onSubmit() {
    let url = 'http://localhost:8080/LightHouse/' + this.title + "/post";
    //let headers = new HttpHeaders();
    //headers.append("allow-control-allow-credentials", "true");
    let result = this.http.post<ControllerResponse>(url, {
      contents: this.postContents
    }/*, { headers: headers }*/).subscribe(cr => {
      if (cr.response === "success") {
        console.log("Response" + cr.response);
        this.onCloseHandled();
        this.ngOnInit();
      } else {
        console.log("Response" + cr.response);
        this.response = cr.response;
        //alert("Authentication failed.");
      }
    });
  }

}
