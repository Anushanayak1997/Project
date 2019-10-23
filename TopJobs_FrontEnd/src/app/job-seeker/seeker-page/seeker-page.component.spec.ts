import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeekerPageComponent } from './seeker-page.component';

describe('SeekerPageComponent', () => {
  let component: SeekerPageComponent;
  let fixture: ComponentFixture<SeekerPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeekerPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeekerPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
