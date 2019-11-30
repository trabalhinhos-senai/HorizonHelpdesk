import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Cliente } from '../clientesDTO';
import { CadClienteService } from './cad-cliente.service';
import { EnderecoService } from 'src/app/_Service/endereco.service';
import { Estados } from 'src/app/_DTO/estados';
import { Cidades } from 'src/app/_DTO/cidades';
import { ClientesService } from '../clientes/clientes.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-cad-cliente',
  templateUrl: './cad-cliente.component.html',
  styleUrls: ['./cad-cliente.component.css']
})
export class CadClienteComponent implements OnInit {

  private cliente: Cliente = new Cliente();
  private estados: Estados[];
  private cidades: Cidades[];

  private UFId: Number;

  cadastrado = false;

  constructor(private clienteService: ClientesService,
              private enderecoService: EnderecoService,
              private _location: Location) { }

  ngOnInit() {
    this.loadEstados();
  }

  onSubmit(formulario: NgForm) {
    if (formulario.valid) {

      this.clienteService.createCliente(this.cliente).subscribe(
        idCliente => {
          console.log(this.cliente)
          this.cliente = new Cliente();
          this.backLastPage();
        }
      );
    }
  }

  loadEstados(): void {
    this.enderecoService.getAllEstados().subscribe(
      estados => {
        //console.log(estados)
        var estadosAZ = estados;
        estadosAZ.sort((a, b) => a.sigla.localeCompare(b.sigla));
        //console.log(estadosAZ);
        this.estados = estadosAZ;

      });
  }

  loadCidadePorEstado(estadoSigla) {

    

    this.estados.forEach(element => {
      if (estadoSigla === element.sigla) {
        this.UFId = element.id

        this.enderecoService.getCidadePorUF(this.UFId).subscribe(
          cidades => {
            console.log(cidades);
            this.cidades = cidades;
          })

      } else {
       // alert("Estado não encontrado")
      }
    });
  }

  backLastPage() {
    this._location.back();
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
