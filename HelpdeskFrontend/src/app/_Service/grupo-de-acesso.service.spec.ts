import { TestBed } from '@angular/core/testing';

import { GrupoDeAcessoService } from './grupo-de-acesso.service';

describe('GrupoDeAcessoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GrupoDeAcessoService = TestBed.get(GrupoDeAcessoService);
    expect(service).toBeTruthy();
  });
});
