import { Injectable } from '@angular/core';
import { Usuario } from '../usuario-pack/usuarios';
import { Router } from '@angular/router';
import { UsuarioService } from '../usuario-pack/usuarios/usuario.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private usuarios: Usuario[];
  private usuarioAutenticado: boolean = false;

  constructor(private router: Router,
    private usuarioService: UsuarioService) { }

    fazerLogin(login: string, senha: string) {

      this.usuarioService.getAllUsers().subscribe(
        usuarios => {

          for (let i = 0; i < usuarios.length; i++) {
            const usuarioAtual = usuarios[i];

            if (usuarioAtual.loginUsuario === login && usuarioAtual.senhaUsuario === senha) {
              this.usuarioAutenticado = true;
              this.router.navigate(['/chamados']);
              console.log(this.usuarioAutenticado)
              break;
            } else {
              this.usuarioAutenticado = false;
            }

          }

          if (!this.usuarioAutenticado) {
            alert("Usuario ou senha incorretos.")
          }


        });

    }

  usuarioEstaAutenticado() {
    return this.usuarioAutenticado;
  }

}
