import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-resources',
  templateUrl: './resources.component.html',
  styleUrl: './resources.component.css'
})
export class ResourcesComponent {
  resources:any;
  constructor(private http:HttpClient) {
  }
  ngOnInit():void{
    this.http
      .get("http://localhost:8888/RESOURCE-SERVICE/resources")
      .subscribe(
        {
          next:value=> {
            console.log(value)
            this.resources=value},
          error:err => {
            console.log(err)
          }
        }
      )
  }
  deleteResource(idResource:number) {
    this.http.delete("http://localhost:8888/RESOURCE-SERVICE/resource/"+idResource)
      .subscribe(
        {
          next: value => {
            window.location.reload()
          },
          error: err => {
            console.log(err)
          }
        }
      )

  }

  editResource(resource: any) {

  }

}
