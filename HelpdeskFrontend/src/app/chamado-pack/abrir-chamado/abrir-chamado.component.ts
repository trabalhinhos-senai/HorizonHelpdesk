import { Component, OnInit } from '@angular/core';
import { AbrirChamadoService } from './abrir-chamado.service';
import { Chamado } from '../chamados';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-abrir-chamado',
  templateUrl: './abrir-chamado.component.html',
  styleUrls: ['./abrir-chamado.component.css']
})
export class AbrirChamadoComponent implements OnInit {

  private chamado: Chamado = new Chamado();
  public aberto = false;

  constructor(private abrirChamadoService: AbrirChamadoService) { }

  ngOnInit() {
  }

  onSubmit(formulario: NgForm) {
    if (formulario.valid) {

      this.chamado.id =  
      Math.random().toString(36).substring(2, 15) 
      + Math.random().toString(36).substring(2, 15);

        console.log(this.chamado)
        this.abrirChamadoService.abrirChamado(this.chamado);
        this.showAlert();
    }
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
