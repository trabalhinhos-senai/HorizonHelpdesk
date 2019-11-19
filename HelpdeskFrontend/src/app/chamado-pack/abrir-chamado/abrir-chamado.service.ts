import { Injectable } from '@angular/core';
import { Chamado } from '../chamados';

@Injectable({
  providedIn: 'root'
})
export class AbrirChamadoService {

  //Chamados = Chamados;

  constructor() { }

  abrirChamado(chamado: any) {
    //this.Chamados.push(chamado);
  }

  getChamados() {
    //return this.Chamados;
  }

  getChamadoById(id: string) {
    
    /*for (let i = 0; i < this.Chamados.length; i++) {
      const chamado = this.Chamados[i];

      if (chamado.id === id) {
        return chamado;
      }   
    }    */
  }
}
