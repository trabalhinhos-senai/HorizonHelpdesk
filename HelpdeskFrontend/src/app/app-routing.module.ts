import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AbrirChamadoComponent } from './chamado-pack/abrir-chamado/abrir-chamado.component';
import { ChamadosComponent } from './chamado-pack/chamados/chamados.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './guards/auth-guard';
import { UsuarioComponent } from './usuario-pack/usuarios/usuario.component';
import { CadUsuarioComponent } from './usuario-pack/cad-usuario/cad-usuario.component';
import { ClientesComponent } from './cliente-pack/clientes/clientes.component';
import { CadClienteComponent } from './cliente-pack/cad-cliente/cad-cliente.component'
import { ChamadoDetailComponent } from './chamado-pack/chamado-detail/chamado-detail.component';
import { UsuarioDetailComponent } from './usuario-pack/usuario-detail/usuario-detail.component';
import { ClienteDetailComponent } from './cliente-pack/cliente-detail/cliente-detail.component';
import { ConfigComponent } from './config/config.component';

const routes: Routes = [
  { path: 'abrir-chamado', component: AbrirChamadoComponent/*, canActivate: [AuthGuard]*/ },
  { path: 'chamados', component: ChamadosComponent/*, canActivate: [AuthGuard]*/ },
  { path: 'login', component: LoginComponent },
  { path: 'usuarios', component: UsuarioComponent },
  { path: 'cad-usuario', component: CadUsuarioComponent },
  { path: 'clientes', component: ClientesComponent },
  { path: 'cad-cliente', component: CadClienteComponent },
  { path: 'config', component: ConfigComponent },
  { path: 'chamado-detalhe/:id', component: ChamadoDetailComponent },
  { path: 'usuario-detalhe/:id', component: UsuarioDetailComponent },
  { path: 'cliente-detalhe/:id', component: ClienteDetailComponent },
  { path: '', redirectTo: '/chamados', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
