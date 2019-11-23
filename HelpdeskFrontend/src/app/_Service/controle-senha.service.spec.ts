import { TestBed } from '@angular/core/testing';

import { ControleSenhaService } from './controle-senha.service';

describe('ControleSenhaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ControleSenhaService = TestBed.get(ControleSenhaService);
    expect(service).toBeTruthy();
  });
});
