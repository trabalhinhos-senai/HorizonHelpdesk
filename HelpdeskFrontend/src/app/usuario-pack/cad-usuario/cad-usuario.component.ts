import { Component, OnInit } from '@angular/core';
import { Usuario } from '../usuarios';
import { NgForm } from '@angular/forms';
import { UsuarioService } from '../usuarios/usuario.service';
import { GrupoAcesso } from 'src/app/_DTO/gruposDeAcesso';
import { GrupoAcessoService } from 'src/app/_Service/grupo-de-acesso.service';
import { ControleSenhaService } from 'src/app/_Service/controle-senha.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-cad-usuario',
  templateUrl: './cad-usuario.component.html',
  styleUrls: ['./cad-usuario.component.css']
})
export class CadUsuarioComponent implements OnInit {

  private usuario: Usuario;
  private gruposAcesso: GrupoAcesso[];
  private grupoAcesso: GrupoAcesso = new GrupoAcesso;

  public cadastrado = false;
  public confirmarSenha: String;

  constructor(private usuarioService: UsuarioService,
              private grupoDeAcessoService: GrupoAcessoService,
              private _location: Location,
              private controleSenha: ControleSenhaService) { }

  ngOnInit() {
    this.usuario = new Usuario();
    this.loadGrupoDeAcesso();

    this.controleSenha.senhaPadrao("Normal");

  }

  onSubmit(formulario: NgForm) {

    if (formulario.valid) {

      this.usuarioService.createUser(this.usuario).subscribe(
        id => {
          console.log(this.usuario)
          this.usuario = new Usuario();
          this.showAlert();
          this.backLastPage();
        }
      );
      console.log(this.usuario);
    }
  }

  loadGrupoDeAcesso(): void {
    this.grupoDeAcessoService.getAllGrupoAcesso().subscribe(
      grupos => {
        this.gruposAcesso = grupos;
      });
  }

  showAlert() {

    //aparecer caixa de mensagem
    this.cadastrado = true;

    //aguarda 3 Segundos e esconde
    setTimeout(function () {
      alert("Cadastrado com sucesso!");
      this.cadastrado = false;

      //console.log(this.cadastrado);
    }.bind(this), 3000);

  }

  backLastPage() {
    this._location.back();
  }

}
