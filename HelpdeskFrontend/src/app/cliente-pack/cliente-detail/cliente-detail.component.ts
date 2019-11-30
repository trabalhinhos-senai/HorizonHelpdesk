import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ClientesService } from '../clientes/clientes.service';
import { EnderecoService } from 'src/app/_Service/endereco.service';
import { NgForm } from '@angular/forms';
import { Cliente } from '../clientesDTO';
import { Estados } from 'src/app/_DTO/estados';
import { Cidades } from 'src/app/_DTO/cidades';
import { Location } from '@angular/common';

@Component({
  selector: 'app-cliente-detail',
  templateUrl: './cliente-detail.component.html',
  styleUrls: ['./cliente-detail.component.css']
})
export class ClienteDetailComponent implements OnInit {

  private cliente: Cliente = new Cliente();
  private estados: Estados[];
  private cidades: Cidades[];
  private id: String;
  private UFId: Number;

  constructor(private clienteService: ClientesService,
    private route: ActivatedRoute,
    private enderecoService: EnderecoService,
    private _location: Location) { }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.getCliente();
    this.loadEstados();

    
  }

  onSubmit(formulario: NgForm) {
    if (formulario.valid) {

      this.clienteService.updateCliente(this.id, this.cliente).subscribe(
        cliente => {
          this.cliente = cliente;
          this.backLastPage();
        }
      );
    }
  }

  getCliente() {
    this.clienteService.getCliente(this.id).subscribe(
      cliente => {
        this.cliente = cliente;
      })
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

      }
    });
  }

  backLastPage() {
    this._location.back();
  }

}
