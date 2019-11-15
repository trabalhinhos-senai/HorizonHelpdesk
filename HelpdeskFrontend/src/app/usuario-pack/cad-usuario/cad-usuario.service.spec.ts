import { TestBed } from '@angular/core/testing';

import { CadUsuarioService } from './cad-usuario.service';

describe('CadUsuarioService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CadUsuarioService = TestBed.get(CadUsuarioService);
    expect(service).toBeTruthy();
  });
});
