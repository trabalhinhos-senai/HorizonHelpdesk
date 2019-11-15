import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UsuarioService } from '../usuarios/usuario.service';
import { Usuario } from '../usuarios';
import {Location} from '@angular/common';
import { NgForm } from '@angular/forms';
import { SenhaComponet } from '../senha.component';

@Component({
  selector: 'app-usuario-detail',
  templateUrl: './usuario-detail.component.html',
  styleUrls: ['./usuario-detail.component.css']
})
export class UsuarioDetailComponent implements OnInit {

  //private senha: SenhaComponet;

  private usuario: Usuario = new Usuario;
  private id: String;

  constructor(
    private route: ActivatedRoute,
    private _location: Location,
    private usuarioService: UsuarioService
    ) { }

  ngOnInit(): void {
    //this.usuario = new Usuario;
    
    this.id = this.route.snapshot.paramMap.get('id');
    //this.senha.SenhaPadrao(1); //1 = normal, 2 = medio, 3 = alto
    this.getUsuario();
  }

  onSubmit(formUsuario: NgForm) {
    if (formUsuario.valid) {
      console.log(this.usuario)
      this.usuarioService.updateUser(this.id, this.usuario).subscribe(
        usuario => {
          console.log(usuario)
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
    /*this.usuario = this.usuarioService.getUsuarioById(id);

    console.log(this.usuarioService.getUsuarioById(id))*/
  }

  backLastPage() {
    this._location.back();
  }

}
