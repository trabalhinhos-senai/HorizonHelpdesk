import { Component, OnInit } from '@angular/core';
import { Chamados } from '../chamados';
import { AbrirChamadoService } from '../abrir-chamado/abrir-chamado.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-chamados',
  templateUrl: './chamados.component.html',
  styleUrls: ['./chamados.component.css']
})
export class ChamadosComponent implements OnInit {

  Chamados = Chamados;
  //nrChamado = (<HTMLInputElement>document.getElementById('inputPesquisa')).value;

  constructor(
    private chamadoService: AbrirChamadoService,
    private route: ActivatedRoute,
    private router: Router) 
    { }

  ngOnInit() {
    this.Chamados = this.chamadoService.getChamados()
  }

  procuraChamado(nrChamado: string){
    this.router.navigate(['/chamado-detalhe/' + nrChamado])
  }

}
