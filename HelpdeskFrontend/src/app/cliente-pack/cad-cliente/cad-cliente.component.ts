import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Cliente, ClienteContato, ClienteEndereco } from '../clientesDTO';
import { CadClienteService } from './cad-cliente.service';
import { EnderecoService } from 'src/app/_Service/endereco.service';
import { Estados } from 'src/app/_DTO/estados';
import { Cidades } from 'src/app/_DTO/cidades';
import { ClientesService } from '../clientes/clientes.service';
import { ClienteContatoService } from 'src/app/_Service/cliente-contato.service';
import { ClienteEnderecoService } from 'src/app/_Service/cliente-endereco.service';

@Component({
  selector: 'app-cad-cliente',
  templateUrl: './cad-cliente.component.html',
  styleUrls: ['./cad-cliente.component.css']
})
export class CadClienteComponent implements OnInit {

  private cliente: Cliente = new Cliente();
  private clienteContato: ClienteContato = new ClienteContato();
  private clienteEndereco: ClienteEndereco = new ClienteEndereco();
  private estados: Estados[];
  private cidades: Cidades[];
  cadastrado = false;

  constructor(private clienteService: ClientesService,
    private clienteContatoService: ClienteContatoService,
    private clienteEnderecoService: ClienteEnderecoService,
    private enderecoService: EnderecoService) { }

  ngOnInit() {
    this.loadEstados();
  }

  onSubmit(formulario: NgForm) {
    if (formulario.valid) {

      this.clienteService.createCliente(this.cliente).subscribe(
        idCliente => {
          console.log(this.cliente)
          this.cliente = new Cliente();
          //this.backLastPage();
        }
      );

      /*this.clienteContatoService.createClienteContato(this.clienteContato).subscribe(
        idContato => {
          this.clienteContato = new ClienteContato();
          
        }
      );

      this.clienteEnderecoService.createClienteEndereco(this.clienteEndereco).subscribe(
        idEndereco => {
          this.clienteEndereco = new ClienteEndereco();
        }
      );*/

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
