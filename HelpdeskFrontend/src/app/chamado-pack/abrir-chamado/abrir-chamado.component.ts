import { Component, OnInit } from '@angular/core';
import { Chamado } from '../chamados';
import { NgForm } from '@angular/forms';
import { ChamadosService } from '../chamados/chamados.service';
import { Cliente } from 'src/app/cliente-pack/clientes';
import { ClientesService } from 'src/app/cliente-pack/clientes/clientes.service';

@Component({
  selector: 'app-abrir-chamado',
  templateUrl: './abrir-chamado.component.html',
  styleUrls: ['./abrir-chamado.component.css']
})
export class AbrirChamadoComponent implements OnInit {

  private chamado: Chamado = new Chamado();
  private clientes: Cliente[];
  public aberto = false;

  constructor(private chamadoService: ChamadosService,
              private clienteService: ClientesService) { }

  ngOnInit() {
    this.loadClientes();
  }

  onSubmit(formulario: NgForm) {
    if (formulario.valid) {

      this.chamadoService.createChamado(this.chamado).subscribe(
        id => {
          this.chamado = new Chamado();
          this.showAlert();
        }
      );
    }
  }

  loadClientes(): void {
    //this.products = this.productService.getProducts();
    this.clienteService.getAllClientes().subscribe(
      clientes => {
        this.clientes = clientes;
      });
  }

  showAlert() {

    //aparecer caixa de mensagem
    this.aberto = true;

    //aguarda 3 Segundos e esconde
    setTimeout(function () {
      this.aberto = false;
    }.bind(this), 3000);

  }


}
