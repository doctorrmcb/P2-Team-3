import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { ControllerResponse } from '../types/ControllerResponse';
@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  name = "blah";
  onCreateCat(): void{
    let url = 'http://localhost:8080/LightHouse/category';
    let result = this.http.post<ControllerResponse>(url, {
    name: this.name
    }).subscribe(cr => {
      if (cr.response === "Category created!") {
        console.log("Response" + cr.response);
        this.router.navigate(['home']);
      } else {
        console.log("Response" + cr.response);
        alert(cr.response);
      }
    });

  }
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient) { }

  ngOnInit() {
  }

}
