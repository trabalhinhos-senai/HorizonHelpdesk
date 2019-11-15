import { TestBed } from '@angular/core/testing';

import { AbrirChamadoService } from './abrir-chamado.service';

describe('AbrirChamadoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AbrirChamadoService = TestBed.get(AbrirChamadoService);
    expect(service).toBeTruthy();
  });
});
