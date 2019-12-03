import { Component, OnInit } from '@angular/core';
import { Chamado } from '../chamados';
import { NgForm } from '@angular/forms';
import { ChamadosService } from '../chamados/chamados.service';
import { Cliente } from 'src/app/cliente-pack/clientesDTO';
import { ClientesService } from 'src/app/cliente-pack/clientes/clientes.service';
import { TipoAtividade } from 'src/app/_DTO/tipoAtividade';
import { Usuario } from 'src/app/usuario-pack/usuarios';
import { UsuarioService } from 'src/app/usuario-pack/usuarios/usuario.service';
import { TipoAtividadeService } from 'src/app/_Service/tipo-atividade.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-abrir-chamado',
  templateUrl: './abrir-chamado.component.html',
  styleUrls: ['./abrir-chamado.component.css']
})
export class AbrirChamadoComponent implements OnInit {

  private chamado: Chamado = new Chamado();
  private cliente: Cliente = new Cliente();
  private clientes: Cliente[];
  private usuario: Usuario = new Usuario();
  private tipoAtividade: TipoAtividade = new TipoAtividade();
  private tiposAtividade: TipoAtividade[];
  private usuarios: Usuario[];
  public aberto = false;

  private formChamado: NgForm;
  private today: String = "2019-01-01";

  constructor(private _location: Location,
    private chamadoService: ChamadosService,
    private clienteService: ClientesService,
    private usuarioService: UsuarioService,
    private tipoAtividadeService: TipoAtividadeService) { }

  ngOnInit() {
    this.loadClientes();
    this.loadTipoAtividadeList();
    this.loadUsuariosList();    
  }

  onSubmit(formulario: NgForm) {
    if (formulario.valid) {

      this.chamadoService.createChamado(this.chamado).subscribe(
        id => {
          console.log(id)
          this.chamado = new Chamado();
          //this.showAlert();
          this.backLastPage()
        }
      );
    }
  }

  loadClientes(): void {
    this.clienteService.getAllClientes().subscribe(
      clientes => {
        this.clientes = clientes;
      });
  }

  loadUsuariosList(): void {
    this.usuarioService.getAllUsers().subscribe(
      usuarios => {
        //console.log(grupos)
        this.usuarios = usuarios;
      });
  }

  loadTipoAtividadeList(): void {
    this.tipoAtividadeService.getAllTipoAtividade().subscribe(
      tiposAtividade => {
        this.tiposAtividade = tiposAtividade;
      });
  }

  createAtividade(formulario: NgForm): void {
    if (formulario.valid) {
      this.tipoAtividadeService.createTipoAtividade(this.tipoAtividade).subscribe(
        id => {
          this.tipoAtividade = new TipoAtividade();
          this.loadTipoAtividadeList();
        });
    }
  }

  updateAtividade(id: Number, atividade: TipoAtividade): void {
      this.tipoAtividadeService.updateTipoAtividade(id, atividade).subscribe(
        atividade => {
          this.tipoAtividade = atividade;
          this.loadTipoAtividadeList();
        });
  }

  showAlert() {

    //aparecer caixa de mensagem
    this.aberto = true;

    //aguarda 3 Segundos e esconde
    setTimeout(function () {
      this.aberto = false;
    }.bind(this), 3000);

  }

  backLastPage() {
    this._location.back();
  }


}
