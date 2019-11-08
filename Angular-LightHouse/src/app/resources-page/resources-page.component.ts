import { Component, OnInit } from '@angular/core';
import { Options } from 'selenium-webdriver/chrome';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { S3Category } from '../types/S3Category';
import { S3Files } from '../types/S3Files';
//import { S3FilesReturned } from '../types/S3FilesReturned';
import { ActivatedRoute, Router } from '@angular/router';
import { ControllerResponse } from '../types/ControllerResponse';


@Component({
  selector: 'app-resources-page',
  templateUrl: './resources-page.component.html',
  styleUrls: ['./resources-page.component.css']
})
export class ResourcesPageComponent {

  options = ['Java', 'HTML', 'CSS', 'PostgreSQL', 'JavaScript'];
  selected = this.options[0];
  path: "";
  //path0: "";

  //private http: HttpClient;
  
  
  //These wree for hard coded tests
  // resources= [
  //   {name: "Java Tutorial", link:"https://docs.oracle.com/javase/tutorial/index.html", rating: 5, category: "Java"},
  //   {name: "Html Tutorial", link:"https://www.w3schools.com/html/", rating: 5, category: "HTML"},
  //   {name: "CSS Tutorial", link:"https://www.w3schools.com/css/default.asp", rating: 5, category: "CSS"},
  //   {name: "JavaScript Tutorial", link:"https://www.w3schools.com/js/", rating: 5, category: "JavaScript"},
  //   {name: "PostgreSQL Tutorial", link:"http://www.postgresqltutorial.com/", rating: 5, category: "PostgreSQL"},
    
  //   {name: "Java Documentation", link:"https://docs.oracle.com/javase/8/docs/", rating: 5, category: "Java"},
  //   {name: "Javascript Documentation", link:"https://docs.oracle.com/javase/tutorial/index.html", rating: 5, category: "JavaScript"},
  //   {name: "Html Documentation", link:"https://devdocs.io/html/", rating: 5, category: "HTML"},
  //   {name: "CSS Documentation", link:"https://devdocs.io/css/", rating: 5, category: "CSS"},
  //   {name: "PostgreSQL Documentation", link:"https://www.postgresql.org/docs/", rating: 5, category: "PostgreSQL"}
 
  // ];

  //filteredResources: any[] = [];


  resources: S3Files[];
  //filesReturned: S3FilesReturned;
  //resources: any[] = [];

  constructor(
    private route: ActivatedRoute,
  private router: Router,
  private http: HttpClient
  ) { }

  /* search(selected){
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
  }
 */


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



  ngOnInit() {
    this.onGetS3FilesByCat(this.selected);
    
  }


  /**
   * When the page is first loaded or whenever the dropdown box for selecting a file category is changed,
   * this function will be called. By default, the Java category is selected and so that will be the category
   * loaded up on page startup. This function will grab all files from the AWS S3 Bucket through a get request
   * to Java. It wil then set this.resources to the response recieved where HTML will populate the resoucres
   * table on page using *ngFor. 
   * 
   * @author ErikHaklar
   * @param selected 
   */
  onGetS3FilesByCat(selected): void {
    let url = 'http://localhost:8080/LightHouse/get-files/' + selected;
    let result = this.http.get<S3Files[]>(url, {
    }).subscribe(cr => {
      //this.filesReturned.files = cr;
      console.log(cr);
      this.resources = cr;
      //this.search(this.selected);
      /* for (let i = 0; i < this.filesReturned.files.length; i++)
      {
        this.resources.push(this.filesReturned.files[i]);
      } */

    });
  }

  /**
   * Download a file listed on the resources page by clicking the download button next to the one you want to grab.
   * You must provide a path to download the file to so it knows where to go by writing that information
   * into the input located next to the download button. the file path must include a \ after the endpoint
   * like this: C:\Users\Erik\Desktop\S3Tests\DownloadTests\. The name of the file is then inserted at the
   * endpoint so the final file path will look like this: 
   * C:\Users\Erik\Desktop\S3Tests\DownloadTests\JavaLesson.txt
   * 
   * @author ErikHaklar
   * @param fileName 
   */
  downloadFile(fileName): void {
    let url = 'http://localhost:8080/LightHouse/download-file/';

    let keyName = fileName;
    let filePath = this.path + fileName;
    let return0 = "!"+keyName+"!" + filePath+"!";
    console.log("Attempting to download file with keyName: " +keyName+ " filePath: " + filePath)

    let result = this.http.post<ControllerResponse>(url, {
      return0 
    }).subscribe(cr => {
      //this.filesReturned.files = cr;
      console.log(cr);
      //this.resources = cr;
      //this.search(this.selected);
      /* for (let i = 0; i < this.filesReturned.files.length; i++)
      {
        this.resources.push(this.filesReturned.files[i]);
      } */

    });
  }

  /**
   * Upload a file to the resources page by entering the path of the file on your computer for the file
   * you want to upload and selecting the file by clicking on the 'Choose File' button. the file path
   * provided must include a \ at the endpoint. It should look like C:\Users\Erik\Desktop\S3Tests\.
   * After the file is chosen this function will automatically add the file name of the file selected
   * ontp the endpoint. The final file path will look like this: C:\Users\Erik\Desktop\S3Tests\JavaLesson.txt
   * 
   * @author ErikHaklar
   * @param file 
   */
  uploadFile(file): void {
    let url = 'http://localhost:8080/LightHouse/upload-file/';
    //let S3File = new S3Files(file.name, this.path, this.selected); 

    /* let fileName = file.name;
    let filePath = this.path;
    let directory = file; */

    let keyName = file.name;
    let filePath = this.path + file.name;
    let category = this.selected;
    let return0 = "!"+keyName+"!" + filePath+"!" + category+"!";

    let result = this.http.post<ControllerResponse>(url, {
      return0
    }).subscribe(cr => {
      //this.filesReturned.files = cr;
      console.log(cr);
      //this.resources = cr;
      //this.search(this.selected);
      /* for (let i = 0; i < this.filesReturned.files.length; i++)
      {
        this.resources.push(this.filesReturned.files[i]);
      } */

    });
  }

}
//