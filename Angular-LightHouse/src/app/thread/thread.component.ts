import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Post } from '../types/Post';
import { ControllerResponse } from '../types/ControllerResponse';

@Component({
  selector: 'app-thread',
  templateUrl: './thread.component.html',
  styleUrls: ['./thread.component.css']
})
export class ThreadComponent implements OnInit {

  id: string;
  response: string;
  title = "";
  contents: "";
  posts: Post[];
  display = 'none';
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
      this.posts = this.formatDate(cr);
      this.posts.sort((a, b) => (a.orderBy > b.orderBy)?1:-1);
        //alert("Authentication failed.");
      
    });
  }
  formatDate(posts: Post[]): Post[]{
    for (let post of posts){
      let orderBy = "";
      orderBy += post.postDate[0];
      orderBy += post.postDate[1];
      orderBy += post.postDate[2];
      orderBy += post.postTime[0];
      if (post.postTime[1].toString().length < 2){
        orderBy += '0' + post.postTime[1];
      } else{
        orderBy += post.postTime[1];
      }
      post.orderBy = Number(orderBy);
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
      contents: this.contents
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
