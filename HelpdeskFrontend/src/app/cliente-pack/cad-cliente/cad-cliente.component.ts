import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Cliente } from '../clientes';
import { CadClienteService } from './cad-cliente.service';

@Component({
  selector: 'app-cad-cliente',
  templateUrl: './cad-cliente.component.html',
  styleUrls: ['./cad-cliente.component.css']
})
export class CadClienteComponent implements OnInit {

  private cliente: Cliente = new Cliente();
  cadastrado = false;

  constructor(private cadClienteService: CadClienteService) { }

  ngOnInit() {
  }

  onSubmit(formulario: NgForm) {
    /*if (formulario.valid) {
      this.cliente.id =  
      Math.random().toString(36).substring(2, 15) 
      + Math.random().toString(36).substring(2, 15);

        console.log(this.cliente)
        this.cadClienteService.cadCliente(this.cliente);
        this.showAlert();
    }*/
  }

  showAlert() {
    //aparecer caixa de mensagem
    this.cadastrado = true;

    //aguarda 3 Segundos e esconde
    setTimeout(function () {
      this.cadastrado = false;
    }.bind(this), 3000);
  }
}
