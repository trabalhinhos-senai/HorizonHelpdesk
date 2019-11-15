import { Injectable } from '@angular/core';
import { Clientes } from '../clientes';

@Injectable({
  providedIn: 'root'
})
export class CadClienteService {

  Clientes = Clientes;

  constructor() { }

  cadCliente(clientes: any) {
    this.Clientes.push(clientes);
  }

  getCliente() {
    return this.Clientes;
  }

  getClienteById(id: string) {
    
    for (let i = 0; i < this.Clientes.length; i++) {
      const clientes = this.Clientes[i];

      if (clientes.id === id) {
        return clientes;
      }   
    }    
  }
}
