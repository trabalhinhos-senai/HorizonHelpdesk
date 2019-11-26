import { Component, OnInit } from '@angular/core';
import { Cliente, ClienteContato } from '../clientesDTO';
import { ClientesService } from './clientes.service';
import { ClienteContatoService } from 'src/app/_Service/cliente-contato.service';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  private clientes: ClienteContato[];
  private clienteAtual = new ClienteContato;

  constructor(private clienteService: ClientesService,
              private clienteContatoService: ClienteContatoService) { }

  ngOnInit() {
    this.loadUsuarios();
  }

  loadUsuarios(): void {
    //this.products = this.productService.getProducts();
    this.clienteContatoService.getAllClientesContato().subscribe(
      clientes => {
        console.log(clientes)
        this.clientes = clientes;
      });
  }

}
