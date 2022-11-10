import { TestBed } from '@angular/core/testing';

import { HomestatsService } from './homestats.service';

describe('HomestatsService', () => {
  let service: HomestatsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HomestatsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
