import { Component, OnInit } from '@angular/core';
import { ControllerResponse } from '../types/ControllerResponse';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-delete-question',
  templateUrl: './delete-question.component.html',
  styleUrls: ['./delete-question.component.css']
})
export class DeleteQuestionComponent implements OnInit {
  options = ['Java8', 'Html', 'CSS', 'PostgreSQL', 'JavaScript']
  selected: string;
  private fieldArray: Array<any> = [];
  private newAttribute: any = {};

  addFieldValue() {
    this.fieldArray.push(this.newAttribute)
    this.newAttribute = {};
  }

  deleteFieldValue(index) {
    this.fieldArray.splice(index, 1);
  }
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient,
  ) { this.addFieldValue() }

  ngOnInit() {
  }

  onDelete() {
    console.log(this.fieldArray);
    for (let i in this.fieldArray ){
      console.log(this.fieldArray[i]);
      console.log(this.fieldArray[i].id);
      this.deleteQuestion(this.fieldArray[i].id);
    }
  }

  deleteQuestion(id) {
    let url = 'http://localhost:8080/LightHouse/deleteQuestion/' + id;
    let result = this.http.delete<ControllerResponse>(url, {}
    ).subscribe(cr => {
      if (cr.response === "success") {
        console.log("Response" + cr.response);
        this.router.navigate(['view-question']);
      } else {
        console.log("Response" + cr.response);
        //alert("Authentication failed.");
        alert("Delete failed.");
      }
    });
  }
}


