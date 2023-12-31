import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-reservations-of-personne',
  templateUrl: './reservations-of-personne.component.html',
  styleUrl: './reservations-of-personne.component.css'
})
export class ReservationsOfPersonneComponent {
  reservations:any
  personneId! : number;
  constructor(private http:HttpClient, private router:Router , private route:ActivatedRoute) {
    this.personneId=route.snapshot.params['personneId']
  }
  ngOnInit(): void {
    this.http
      .get("http://localhost:8888/RESERVATION-SERVICE/reservations/idPersonne/"+this.personneId).subscribe({
      next: (data)=>{
        this.reservations=data;
      },
      error:(err)=>{
        console.log(err)
      }
    });
  }
}
