import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ResourcesComponent } from './resources/resources.component';
import { PersonnesComponent } from './personnes/personnes.component';
import { ReservationsComponent } from './reservations/reservations.component';
import {HttpClientModule} from "@angular/common/http";
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";
import { ReservationsOfPersonneComponent } from './reservations-of-personne/reservations-of-personne.component';
import {FormsModule} from "@angular/forms";

function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'app-realm',
        clientId: 'angular-front-app'
      },
      initOptions : {
        onLoad : "login-required",
        silentCheckSsoRedirectUri:
          window.location.origin + '/assets/silent-check-sso.html'
      }
    });
}

@NgModule({
  declarations: [
    AppComponent,
    ResourcesComponent,
    PersonnesComponent,
    ReservationsComponent,
    ReservationsOfPersonneComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    KeycloakAngularModule,
    FormsModule
  ],
  providers: [{
    provide: APP_INITIALIZER,
    useFactory: initializeKeycloak,
    multi: true,
    deps: [KeycloakService]
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
