import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrl: './reservations.component.css'
})
export class ReservationsComponent {
  reservations:any
  personne:any|null
  edit:any|null
  page:number = 1
  resource:any|null
  constructor(private http:HttpClient) {
  }
  ngOnInit(): void {
    this.http
      .get("http://localhost:8888/RESERVATION-SERVICE/reservations").subscribe({
      next: (data)=>{
        this.reservations=data;
      },
      error:(err)=>{
        console.log(err)
      }
    });
  }

  getResource(resource: any) {
    this.resource=resource
  }

  getPersonne(personne: any) {
    this.personne=personne
  }

  deleteReservation(id:number) {
    this.http.delete("http://localhost:8888/RESERVATION-SERVICE/reservation/"+id)
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

  editReservation(r: any) {
    this.edit = r
    console.log(this.edit)
  }
// Function to edit a reservation
  lastEdit(nom:any,duree:any,contexte:any) {
    this.edit.nom=nom
    this.edit.duree=duree
    this.edit.contexte=contexte
      // Send an HTTP request to update the reservation
      this.http.post("http://localhost:8888/RESERVATION-SERVICE/reservation/" + this.edit.id, this.edit).subscribe({
        next: (data) => {
          // Handle success, e.g., close the modal and refresh the reservations
          console.log("Reservation updated successfully:", data);
          // Reload reservations
          window.location.reload();
        },
        error: (err) => {
          console.error("Error updating reservation:", err);
          // Handle error, e.g., display an alert to the user
        }
      });
  }
}
