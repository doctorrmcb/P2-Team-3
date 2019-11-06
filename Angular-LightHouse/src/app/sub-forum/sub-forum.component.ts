import { Component, OnInit } from '@angular/core';
import { Thread } from '../types/Thread';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ControllerResponse } from '../types/ControllerResponse';


@Component({
  selector: 'app-sub-forum',
  templateUrl: './sub-forum.component.html',
  styleUrls: ['./sub-forum.component.css']
})
export class SubForumComponent implements OnInit {

  id: string;
  threads: Thread[];
  title: "";
  contents: "";
  response: string;
  username: string;
  display = 'none';
  options = ['Java', 'SQL', 'HTML', 'CSS', 'JavaScript'];
  

  constructor(private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient



  ) { }

  ngOnInit() {
    // Grabs the ID from the URL and adds it to the id paramter in this class.
    this.id = this.route.snapshot.paramMap.get('id');
    
    let url = 'http://localhost:8080/LightHouse/forum/' + this.id;
    let result = this.http.get<Thread[]>(url, {}).subscribe(tr => {
      /* for (let i = 0; i < tr.length; i++) {
        //<a href="{{tr[i]."></a> 
      } */
      this.threads = tr;
      console.log(tr);
      console.log(this.threads);
    });
  }

  createNewThread() {
    this.display = 'block';
  }

  onCloseHandled() {

    this.display = 'none';

  }

  onSubmit() {
    let url = 'http://localhost:8080/LightHouse/forum/' + this.id;
    //let headers = new HttpHeaders();
    //headers.append("allow-control-allow-credentials", "true");
    let result = this.http.post<ControllerResponse>(url, {
      title: this.title,
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
