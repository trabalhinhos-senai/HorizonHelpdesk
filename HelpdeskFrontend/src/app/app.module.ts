import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { NavBarComponent } from './page-proprieties/nav-bar/nav-bar.component';
import { ChamadosComponent } from './chamado-pack/chamados/chamados.component';
import { AbrirChamadoComponent } from './chamado-pack/abrir-chamado/abrir-chamado.component';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './app-routing.module';
import { AuthService } from './login/auth.service';
import { AuthGuard } from './guards/auth-guard';
import { UsuarioComponent } from './usuario-pack/usuarios/usuario.component';
import { CadUsuarioComponent } from './usuario-pack/cad-usuario/cad-usuario.component';
import { CadClienteComponent } from './cliente-pack/cad-cliente/cad-cliente.component';
import { ClientesComponent } from './cliente-pack/clientes/clientes.component';
import { FooterComponent } from './page-proprieties/footer/footer.component';
import { ChamadoDetailComponent } from './chamado-pack/chamado-detail/chamado-detail.component';
import { UsuarioDetailComponent } from './usuario-pack/usuario-detail/usuario-detail.component';
import { ClienteDetailComponent } from './cliente-pack/cliente-detail/cliente-detail.component';
import { ConfigComponent } from './config/config.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    ChamadosComponent,
    AbrirChamadoComponent,
    LoginComponent,
    UsuarioComponent,
    CadUsuarioComponent,
    CadClienteComponent,
    ClientesComponent,
    FooterComponent,
    ChamadoDetailComponent,
    UsuarioDetailComponent,
    ClienteDetailComponent,
    ConfigComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [AuthService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
