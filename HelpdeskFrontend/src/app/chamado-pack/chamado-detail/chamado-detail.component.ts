import { Component, OnInit, Input } from '@angular/core';
import { AbrirChamadoService } from '../abrir-chamado/abrir-chamado.service';
import { ActivatedRoute } from '@angular/router';
import { Chamado } from '../chamados';
import { ChamadosService } from '../chamados/chamados.service';
import { NgForm } from '@angular/forms';
import {Location} from '@angular/common';
import { ClientesService } from 'src/app/cliente-pack/clientes/clientes.service';
import { Cliente } from 'src/app/cliente-pack/clientesDTO';


@Component({
  selector: 'app-chamado-detail',
  templateUrl: './chamado-detail.component.html',
  styleUrls: ['./chamado-detail.component.css']
})

export class ChamadoDetailComponent implements OnInit {

  private chamado: Chamado = new Chamado();
  private cliente: Cliente = new Cliente();
  private id: String;

  constructor(
    private route: ActivatedRoute,
    private _location: Location,
    private chamadoService: ChamadosService,
    private clienteService: ClientesService
    ) { }

  ngOnInit(): void {
    //this.usuario = new Usuario;
    
    this.id = this.route.snapshot.paramMap.get('id');
    this.getChamado();
    //this.getCliente();
  }

  onSubmit(formChamado: NgForm) {
    if (formChamado.valid) {
      console.log(this.chamado)
      this.chamadoService.updateChamado(this.id, this.chamado).subscribe(
        chamado => {
          this.chamado = chamado;
          this.backLastPage();
        }
      );
    }
  }

  getChamado() {
    this.chamadoService.getChamado(this.id).subscribe(
      chamado => {
        console.log(chamado)
        this.chamado = chamado;

        
          this.clienteService.getCliente(this.chamado.cliente.id).subscribe(
            cliente => {
              console.log(cliente)
              this.cliente = cliente;
            })
        

      })
  }

  backLastPage() {
    this._location.back();
  }
}
