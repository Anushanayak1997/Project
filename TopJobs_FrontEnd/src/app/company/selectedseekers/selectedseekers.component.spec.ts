import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectedseekersComponent } from './selectedseekers.component';

describe('SelectedseekersComponent', () => {
  let component: SelectedseekersComponent;
  let fixture: ComponentFixture<SelectedseekersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectedseekersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectedseekersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
