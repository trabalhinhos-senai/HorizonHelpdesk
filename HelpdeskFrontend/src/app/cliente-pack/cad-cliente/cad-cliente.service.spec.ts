import { TestBed } from '@angular/core/testing';

import { CadClienteService } from './cad-cliente.service';

describe('CadClienteService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CadClienteService = TestBed.get(CadClienteService);
    expect(service).toBeTruthy();
  });
});
