import { Component, OnInit } from '@angular/core';
import { Cliente } from '../clientesDTO';
import { ClientesService } from './clientes.service';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  private clientes: Cliente[];
  private cliente: Cliente = new Cliente();

  constructor(private clienteService: ClientesService) { }

  ngOnInit() {
    this.loadUsuarios();
  }

  loadUsuarios(): void {
    //this.products = this.productService.getProducts();
    this.clienteService.getAllClientes().subscribe(
      clientes => {
        console.log(clientes)
        this.clientes = clientes;
      });
  }

  deleteCliente(id) {

    var confirmar = confirm("Tem certeza que deseja excluir?");
    if (confirmar) {
      this.clienteService.deleteCliente(id).subscribe(
        cliente => {
          this.cliente = cliente;
          this.loadUsuarios();
        });
    }

  }

}
