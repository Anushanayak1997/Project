import { TestBed } from '@angular/core/testing';

import { JobpostService } from './jobpost.service';

describe('JobpostService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: JobpostService = TestBed.get(JobpostService);
    expect(service).toBeTruthy();
  });
});
