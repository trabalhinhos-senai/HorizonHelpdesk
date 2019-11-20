import { Component, OnInit } from '@angular/core';
import { Cliente } from '../clientes';
import { CadClienteService } from '../cad-cliente/cad-cliente.service';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  //Clientes = Clientes;

  constructor(private clienteService: CadClienteService) { }

  ngOnInit() {
    //this.Clientes = this.clienteService.getCliente();
  }
}
