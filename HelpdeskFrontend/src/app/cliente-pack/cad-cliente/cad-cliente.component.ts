import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Cliente } from '../clientes';
import { CadClienteService } from './cad-cliente.service';
import { EnderecoService } from 'src/app/_Service/endereco.service';
import { Estados } from 'src/app/_DTO/estados';
import { Cidades } from 'src/app/_DTO/cidades';

@Component({
  selector: 'app-cad-cliente',
  templateUrl: './cad-cliente.component.html',
  styleUrls: ['./cad-cliente.component.css']
})
export class CadClienteComponent implements OnInit {

  private cliente: Cliente = new Cliente();
  private estados: Estados[];
  private cidades: Cidades[];
  cadastrado = false;

  constructor(private cadClienteService: CadClienteService,
              private enderecoService: EnderecoService) { }

  ngOnInit() {
    this.loadEstados();
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

  loadEstados(): void {
    this.enderecoService.getAllEstados().subscribe(
      estados => {
        //console.log(estados)
        var estadosAZ = estados;
        estadosAZ.sort((a,b) => a.sigla.localeCompare(b.sigla));
        //console.log(estadosAZ);
        this.estados = estadosAZ;

      });
  }

  loadCidadePorEstado(idUF) {

    this.enderecoService.getCidadePorUF(idUF).subscribe(
      cidades => {
        console.log(cidades);
        this.cidades = cidades;
      })

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
