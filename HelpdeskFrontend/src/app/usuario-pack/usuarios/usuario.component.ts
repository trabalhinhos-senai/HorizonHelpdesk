import { Component, OnInit } from '@angular/core';
import { UsuarioService } from './usuario.service';
import { Usuario } from '../usuarios';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  //Usuarios = Usuarios;
  private usuarios: Usuario[];
  private usuarioAtual = new Usuario;

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit() {
    this.loadUsuarios();
    //this.Usuarios = this.usuarioService.getUsuarios();
  }

  loadUsuarios(): void {
    //this.products = this.productService.getProducts();
    this.usuarioService.getAllUsers().subscribe(
      usuarios => {
        this.usuarios = usuarios;
      });
  }

  deleteUser(id) {
    this.usuarioService.deleteUser(id).subscribe(
      usuario => {
        this.usuarioAtual = usuario;
      });

      console.log(this.usuarioAtual);
  }

}
