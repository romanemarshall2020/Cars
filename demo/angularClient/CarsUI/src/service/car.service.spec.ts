import { TestBed } from '@angular/core/testing';
import { HttpClient } from '@angular/common/http';
import { CarService } from './car.service';

describe('CarService', () => {
  let service: CarService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CarService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
