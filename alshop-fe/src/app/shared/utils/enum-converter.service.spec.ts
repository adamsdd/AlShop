import { TestBed } from '@angular/core/testing';

import { EnumConverterService } from './enum-converter.service';

describe('EnumConverterService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EnumConverterService = TestBed.get(EnumConverterService);
    expect(service).toBeTruthy();
  });
});
