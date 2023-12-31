import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationsOfPersonneComponent } from './reservations-of-personne.component';

describe('ReservationsOfPersonneComponent', () => {
  let component: ReservationsOfPersonneComponent;
  let fixture: ComponentFixture<ReservationsOfPersonneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ReservationsOfPersonneComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ReservationsOfPersonneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
