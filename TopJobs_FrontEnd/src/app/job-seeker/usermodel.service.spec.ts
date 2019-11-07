import { TestBed } from '@angular/core/testing';

import { UsermodelService } from './usermodel.service';

describe('UsermodelService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UsermodelService = TestBed.get(UsermodelService);
    expect(service).toBeTruthy();
  });
});
