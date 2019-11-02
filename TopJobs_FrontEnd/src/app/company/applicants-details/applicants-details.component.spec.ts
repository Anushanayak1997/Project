import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplicantsDetailsComponent } from './applicants-details.component';

describe('ApplicantsDetailsComponent', () => {
  let component: ApplicantsDetailsComponent;
  let fixture: ComponentFixture<ApplicantsDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApplicantsDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApplicantsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
