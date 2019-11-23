import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UsuarioService } from '../usuarios/usuario.service';
import { Usuario } from '../usuarios';
import {Location} from '@angular/common';
import { NgForm } from '@angular/forms';
import { GrupoAcessoService } from '../../_Service/grupo-de-acesso.service';
import { GrupoAcesso } from 'src/app/_DTO/gruposDeAcesso';
import { ControleSenhaService } from 'src/app/_Service/controle-senha.service';

@Component({
  selector: 'app-usuario-detail',
  templateUrl: './usuario-detail.component.html',
  styleUrls: ['./usuario-detail.component.css']
})
export class UsuarioDetailComponent implements OnInit {

  private gruposAcesso: GrupoAcesso[];
  private usuario: Usuario = new Usuario;
  private grupoAcesso: GrupoAcesso = new GrupoAcesso;
  private id: String;

  constructor(
    private route: ActivatedRoute,
    private _location: Location,
    private grupoDeAcessoService: GrupoAcessoService,
    private usuarioService: UsuarioService,
    private controleSenha: ControleSenhaService
    ) { }

  ngOnInit(): void {
    //this.usuario = new Usuario;
    
    this.id = this.route.snapshot.paramMap.get('id');
    this.controleSenha.senhaPadrao("Normal");
    this.getUsuario();
    this.loadGrupoDeAcesso();
  }

  onSubmit(formUsuario: NgForm) {
    if (formUsuario.valid) {
      console.log(this.usuario)
      this.usuarioService.updateUser(this.id, this.usuario).subscribe(
        usuario => {
          console.log(this.usuario.grupoAcesso)
          //this.usuario.grupoAcesso = this.grupoAcesso;
          this.usuario = usuario;
          this.backLastPage();
        }
      );
    }
  }

  getUsuario() {
    this.usuarioService.getUser(this.id).subscribe(
      usuario => {
        this.usuario = usuario;
      })
  }

  loadGrupoDeAcesso(): void {
    this.grupoDeAcessoService.getAllGrupoAcesso().subscribe(
      grupos => {
        console.log(grupos)
        this.gruposAcesso = grupos;
      });
  }

  getGrupoDeAcesso(id) {
    this.grupoDeAcessoService.getGrupoAcesso(id).subscribe(
      grupo => {
        this.grupoAcesso = grupo;
      })
  }

  backLastPage() {
    this._location.back();
  }

}
