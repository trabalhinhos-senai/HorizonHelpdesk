import { Component, OnInit, Input } from '@angular/core';
import { AbrirChamadoService } from '../abrir-chamado/abrir-chamado.service';
import { ActivatedRoute } from '@angular/router';
import { Chamado } from '../chamados';
import { ChamadosService } from '../chamados/chamados.service';
import { NgForm } from '@angular/forms';
import {Location} from '@angular/common';
import { ClientesService } from 'src/app/cliente-pack/clientes/clientes.service';
import { Cliente } from 'src/app/cliente-pack/clientesDTO';
import { Usuario } from 'src/app/usuario-pack/usuarios';
import { UsuarioService } from 'src/app/usuario-pack/usuarios/usuario.service';
import { TipoAtividade } from 'src/app/_DTO/tipoAtividade';
import { TipoAtividadeService } from 'src/app/_Service/tipo-atividade.service';


@Component({
  selector: 'app-chamado-detail',
  templateUrl: './chamado-detail.component.html',
  styleUrls: ['./chamado-detail.component.css']
})

export class ChamadoDetailComponent implements OnInit {

  private chamado: Chamado = new Chamado();
  private cliente: Cliente = new Cliente();
  private usuario: Usuario = new Usuario();
  private tipoAtividade: TipoAtividade = new TipoAtividade();
  private tiposAtividade: TipoAtividade[];
  private usuarios: Usuario[];
  private id: String;

  constructor(
    private route: ActivatedRoute,
    private _location: Location,
    private chamadoService: ChamadosService,
    private clienteService: ClientesService,
    private usuarioService: UsuarioService,
    private tipoAtividadeService: TipoAtividadeService
    ) { }

  ngOnInit(): void {
    //this.usuario = new Usuario;
    
    this.id = this.route.snapshot.paramMap.get('id');
    this.getChamado();
    this.loadUsuariosList();
    this.loadTipoAtividadeList();
    //this.getCliente();
  }

  onSubmit(formChamado: NgForm) {
    //alert(this.chamado.titulo);
    if (formChamado.valid) {
      this.chamadoService.updateChamado(this.id, this.chamado).subscribe(
        chamado => {
          console.log(chamado)
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
      })
  }

  loadUsuariosList(): void {
    this.usuarioService.getAllUsers().subscribe(
      usuarios => {
        //console.log(grupos)
        this.usuarios = usuarios;
      });
  }

  loadTipoAtividadeList(): void {
    this.tipoAtividadeService.getAllTipoAtividade().subscribe(
      tiposAtividade => {
        this.tiposAtividade = tiposAtividade;
      });
  }

  getUsuario(id) {
    this.usuarioService.getUser(id).subscribe(
      usuario => {
        this.usuario = usuario;
      })
  }

  backLastPage() {
    this._location.back();
  }
}
