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
      this.posts = cr;
        //alert("Authentication failed.");
      
    });
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
