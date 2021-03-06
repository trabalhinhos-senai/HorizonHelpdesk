import { Component, OnInit } from '@angular/core';
import { UsuarioService } from './usuario.service';
import { Usuario } from '../usuarios';
import { Chamado } from 'src/app/chamado-pack/chamados';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  private usuarios: Usuario[];
  private usuarioAtual = new Usuario;
  private chamados: Chamado[];

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit() {
    this.loadUsuarios();
  }

  loadUsuarios(): void {
    this.usuarioService.getAllUsers().subscribe(
      usuarios => {

        this.usuarios = usuarios;
      });
  }

  deleteUser(id) {

    var confirmar = confirm("Tem certeza que deseja excluir?");
    if (confirmar) {
      this.usuarioService.deleteUser(id).subscribe(
        usuario => {
          this.usuarioAtual = usuario;
          this.loadUsuarios();
        });
    }

  }

}
