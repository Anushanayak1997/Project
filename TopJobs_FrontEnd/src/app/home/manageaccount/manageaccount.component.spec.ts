import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageaccountComponent } from './manageaccount.component';

describe('ManageaccountComponent', () => {
  let component: ManageaccountComponent;
  let fixture: ComponentFixture<ManageaccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManageaccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageaccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
