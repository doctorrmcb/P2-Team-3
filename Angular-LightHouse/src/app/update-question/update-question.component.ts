import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ControllerResponse } from '../types/ControllerResponse';


@Component({
  selector: 'app-update-question',
  templateUrl: './update-question.component.html',
  styleUrls: ['./update-question.component.css']
})

export class UpdateQuestionComponent implements OnInit {
  public isCollapsedone = false;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient
  ) { }

  newcontent: "";
  newanswer: "";
  newexplanation: "";
  questionid: 0;
  questionid1: 0;
  questionid2: 0;

  ngOnInit() {
  }

  updateQuestionName() {
    console.log(this.newcontent + " " + this.questionid);
    let url = 'http://localhost:8080/LightHouse/updateQuestionName/' + this.questionid;
    let result = this.http.put<ControllerResponse>(url, {
      newcontent: this.newcontent
    }).subscribe(cr => {
      if (cr.response === "success") {
        console.log("Response" + cr.response);
        this.router.navigate(['view-question']);
      } else {
        console.log("Response" + cr.response);
        //alert("Authentication failed.");
        alert("Update failed.");
      }
    });
  }

  updateQuestionCorrect() {
    console.log(this.newanswer + " " + this.questionid1);
    let url = 'http://localhost:8080/LightHouse/updateQuestionAnswer/' + this.questionid1;
    let result = this.http.put<ControllerResponse>(url, {
      newanswer: this.newanswer
    }).subscribe(cr => {
      if (cr.response === "success") {
        console.log("Response" + cr.response);
        this.router.navigate(['view-question']);
      } else {
        console.log("Response" + cr.response);
        //alert("Authentication failed.");
        alert("Update failed.");
      }
    });
  }

  updateQuestionExplain() {
    console.log(this.newexplanation + " " + this.questionid2);
    let url = 'http://localhost:8080/LightHouse/updateQuestionExplanation/' + this.questionid2;
    let result = this.http.put<ControllerResponse>(url, {
      newexplanation: this.newexplanation
    }).subscribe(cr => {
      if (cr.response === "success") {
        console.log("Response" + cr.response);
        this.router.navigate(['view-question']);
      } else {
        console.log("Response" + cr.response);
        alert("Update failed.");
      }
    });
  }

}
