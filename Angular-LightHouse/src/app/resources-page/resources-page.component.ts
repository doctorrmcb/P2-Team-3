import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-resources-page',
  templateUrl: './resources-page.component.html',
  styleUrls: ['./resources-page.component.css']
})
export class ResourcesPageComponent {

  options =['Java8', 'Html', 'CSS', 'PostgreSQL', 'JavaScript']
  selected: string;
  
  resources= [
    {name: "Java8 Tutorial", link:"https://docs.oracle.com/javase/tutorial/index.html", rating: 5},
    {name: "Html Tutorial", link:"https://www.w3schools.com/html/", rating: 5},
    {name: "CSS Tutorial", link:"https://www.w3schools.com/css/default.asp", rating: 5},
    {name: "JavaScript Tutorial", link:"https://www.w3schools.com/js/", rating: 5},
    {name: "PostgreSQL Tutorial", link:"http://www.postgresqltutorial.com/", rating: 5},
    
    {name: "Java8 Documentation", link:"https://docs.oracle.com/javase/8/docs/", rating: 5},
    {name: "Javascript Documentation", link:"https://docs.oracle.com/javase/tutorial/index.html", rating: 5},
    {name: "Html Documentation", link:"https://devdocs.io/html/", rating: 5},
    {name: "CSS Documentation", link:"https://devdocs.io/css/", rating: 5},
    {name: "PostgreSQL Documentation", link:"https://www.postgresql.org/docs/", rating: 5}
 
  ];

  constructor() { }

search(selected){
  console.log('selected value:', selected);

  var filter, table, tr, td, i, txtValue;

   filter = selected.toUpperCase();
   table = document.getElementById("myTable");
   tr = table.getElementsByTagName("tr");
 
   // Loop through all table rows, and hide those who don't match the search query
   for (i = 0; i < tr.length; i++) {
     td = tr[i].getElementsByTagName("td")[0];
     if (td) {
       txtValue = td.textContent || td.innerText;
       if (txtValue.toUpperCase().indexOf(filter) > -1) {
         tr[i].style.display = "";
       } else {
         tr[i].style.display = "none";
       }
     }
   }


}


}
//