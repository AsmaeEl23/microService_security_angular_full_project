import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ResourcesComponent} from "./resources/resources.component";
import {PersonnesComponent} from "./personnes/personnes.component";
import {AuthGuard} from "./guards/auth.guard";
import {ReservationsComponent} from "./reservations/reservations.component";
import {ReservationsOfPersonneComponent} from "./reservations-of-personne/reservations-of-personne.component";

const routes: Routes = [
  {path:"resources",component:ResourcesComponent},
  {path:"personnes",component:PersonnesComponent,canActivate:[AuthGuard],data:{roles: ["ADMIN"]}},
  {path:"reservations",component:ReservationsComponent,canActivate:[AuthGuard],data:{roles: ["ADMIN"]}},
  {path : "reservations-of-personne/:personneId", component : ReservationsOfPersonneComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
