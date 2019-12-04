import { Component, OnInit } from '@angular/core';
import { RouterModule, Router } from '@angular/router';
import { AuthService } from './auth.service';
import { Usuario } from '../usuario-pack/usuarios';
import { UsuarioService } from '../usuario-pack/usuarios/usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  private usuario: Usuario = new Usuario();
  private usuarioAtual: Usuario = new Usuario();

  constructor(private authService: AuthService,
              private router: Router) {
    
    if (this.authService.usuarioEstaAutenticado) {
      this.router.navigate(['/login']);
    }

   }

  ngOnInit() {

    this.usuarioAtual = JSON.parse(localStorage.getItem('usuarioAtual'))

    this.fazerLogin(this.usuarioAtual.loginUsuario, this.usuarioAtual.senhaUsuario);

    //console.log(JSON.parse(localStorage.getItem('usuarioAtual')))
  }

  fazerLogin(login: string, senha: string) {
    this.authService.fazerLogin(login, senha);
  }
  
}
