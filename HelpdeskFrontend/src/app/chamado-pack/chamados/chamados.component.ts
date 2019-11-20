import { Component, OnInit } from '@angular/core';
import { Chamado } from '../chamados';
import { ActivatedRoute, Router } from '@angular/router';
import { ChamadosService } from './chamados.service';


@Component({
  selector: 'app-chamados',
  templateUrl: './chamados.component.html',
  styleUrls: ['./chamados.component.css']
})
export class ChamadosComponent implements OnInit {

  //Chamados = Chamados;
  //nrChamado = (<HTMLInputElement>document.getElementById('inputPesquisa')).value;
  private chamados: Chamado[];

  constructor(
    private chamadoService: ChamadosService,
    private route: ActivatedRoute,
    private router: Router) 
    { }

  ngOnInit() {
    this.loadChamados();
  }

  loadChamados(): void {
    this.chamadoService.getAllChamados().subscribe(
      chamados => {
        this.chamados = chamados;
        console.log(this.chamados)});
  }

  procuraChamado(nrChamado: string){
    this.router.navigate(['/chamado-detalhe/' + nrChamado])
  }

}
