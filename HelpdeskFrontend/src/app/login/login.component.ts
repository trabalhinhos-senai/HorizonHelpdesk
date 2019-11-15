import { Component, OnInit } from '@angular/core';
import { RouterModule, Router } from '@angular/router';
import { AuthService } from './auth.service';
import { Usuario } from '../usuario-pack/usuarios';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  //private usuario: Usuario = new Usuario();

  constructor(private authService: AuthService,
              private router: Router) {
    
    if (this.authService.usuarioEstaAutenticado) {
      this.router.navigate(['/login']);
    }

   }

  ngOnInit() {
  }

  fazerLogin() {
    //console.log(this.usuario);
    //this.authService.fazerLogin(this.usuario);
  }
  
}
