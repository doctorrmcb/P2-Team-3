import { Component, OnInit } from '@angular/core';
import { Options } from 'selenium-webdriver/chrome';

@Component({
  selector: 'app-resources-page',
  templateUrl: './resources-page.component.html',
  styleUrls: ['./resources-page.component.css']
})
export class ResourcesPageComponent {

  options =['Java', 'HTML', 'CSS', 'PostgreSQL', 'JavaScript'];
  selected = this.options[0];
  
  
  resources= [
    {name: "Java Tutorial", link:"https://docs.oracle.com/javase/tutorial/index.html", rating: 5, category: "Java"},
    {name: "Html Tutorial", link:"https://www.w3schools.com/html/", rating: 5, category: "HTML"},
    {name: "CSS Tutorial", link:"https://www.w3schools.com/css/default.asp", rating: 5, category: "CSS"},
    {name: "JavaScript Tutorial", link:"https://www.w3schools.com/js/", rating: 5, category: "JavaScript"},
    {name: "PostgreSQL Tutorial", link:"http://www.postgresqltutorial.com/", rating: 5, category: "PostgreSQL"},
    
    {name: "Java Documentation", link:"https://docs.oracle.com/javase/8/docs/", rating: 5, category: "Java"},
    {name: "Javascript Documentation", link:"https://docs.oracle.com/javase/tutorial/index.html", rating: 5, category: "JavaScript"},
    {name: "Html Documentation", link:"https://devdocs.io/html/", rating: 5, category: "HTML"},
    {name: "CSS Documentation", link:"https://devdocs.io/css/", rating: 5, category: "CSS"},
    {name: "PostgreSQL Documentation", link:"https://www.postgresql.org/docs/", rating: 5, category: "PostgreSQL"}
 
  ];

  filteredResources: any[] = [];

  constructor() { }

  search(selected){
    console.log('selected value:', selected);

    this.filteredResources = [];

    for (let i = 0; i < this.resources.length; i++)
    {
      if (this.resources[i].category === selected)
      {
        this.filteredResources.push(this.resources[i]);
      }
    }

    console.log(this.filteredResources);



    // filter = selected.toUpperCase();
    // table = document.getElementById("myTable");
    // tr = table.getElementsByTagName("tr");
  
    // Loop through all table rows, and hide those who don't match the search query
    // for (i = 0; i < this.resources.length; i++) {
    //   td = tr[i].getElementsByTagName("td")[0];
    //   if (td) {
    //     txtValue = td.textContent || td.innerText;
    //     if (txtValue.toUpperCase().indexOf(filter) > -1) {
    //       tr[i].style.display = "";
    //     } else {
    //       tr[i].style.display = "none";
    //     }
    //   }
    // }


  }


  ngOnInit() {
    this.search(this.selected);
  }

}
//