import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Thread } from '../types/Thread';


@Component({
  selector: 'app-sub-forum',
  templateUrl: './sub-forum.component.html',
  styleUrls: ['./sub-forum.component.css']
})
export class SubForumComponent implements OnInit {

  id: string;
  threads: Thread[];
  display = 'none';
  options = ['Java', 'SQL', 'HTML', 'CSS', 'JavaScript'];

  constructor(private route: ActivatedRoute,
    private http: HttpClient) { }

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
    this.display='block';
  }

  onCloseHandled(){
 
    this.display='none';

 }

}
