import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-personnes',
  templateUrl: './personnes.component.html',
  styleUrl: './personnes.component.css'
})
export class PersonnesComponent {
  personnes: any

  constructor(private http: HttpClient, private router: Router) {
  }
  ngOnInit():void{
    this.http
      .get("http://localhost:8888/RESERVATION-SERVICE/personnes")
      .subscribe(
        {
          next:value=> {
            console.log(value)
            this.personnes=value},
          error:err => {
            console.log(err)
          }
        }
      )
  }

    getReservations(id:number) {
      this.router.navigateByUrl("/reservations-of-personne/"+id)
    }

    deletePersonne(id:number) {
      this.http.delete("http://localhost:8888/RESERVATION-SERVICE/personne/"+id)
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

    editPersonne(p: any) {

    }
}
