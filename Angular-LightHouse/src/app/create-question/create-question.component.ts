import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { ControllerResponse } from '../types/ControllerResponse';
import { Question } from '../types/Question';

@Component({
  selector: 'app-create-question',
  templateUrl: './create-question.component.html',
  styleUrls: ['./create-question.component.css']
})
export class CreateQuestionComponent implements OnInit {

  qID: number;
  question: "";
  ca: "";
  exp: "";
  wa1: "";
  wa2: "";
  wa3: "";
  selected: "";
  createDisplay = 'none';
  response: string;
  options = ['Java', 'SQL', 'HTML', 'CSS', 'JavaScript'];
  createNewQuestion() {
      this.createDisplay = 'block';
    }
  onCloseHandled() {
      this.createDisplay = 'none';
    }
  onSubmit() {
      let url = 'http://localhost:8080/LightHouse/createQuestion/' + this.selected;
      console.log(url);
      let result = this.http.post<Question>(url, {
        questionName: this.question,
        correctAnswer: this.ca,
        wrongAnswer1: this.wa1,
        wrongAnswer2: this.wa2,
        wrongAnswer3: this.wa3,
        explanation: this.exp
        
      }/*, { headers: headers }*/).subscribe(cr => {
        if (cr != null) {
          //console.log("Response " + cr.questionName);
          this.onCloseHandled();
          this.qID = cr.questionID;
          //console.log("Response Question ID = " + cr.questionID)
          //console.log(this.qID);
          this.ngOnInit();
          
          this.createNewQuestion();
        } else {
          //console.log("Response" + cr.response);
          this.response = "Question Already Exists";
          //alert("Authentication failed.");
        }
      });
    }

  constructor(private route: ActivatedRoute,
    private http: HttpClient) { }

  ngOnInit() {
  }

}
