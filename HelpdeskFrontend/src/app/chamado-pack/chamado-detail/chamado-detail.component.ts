import { Component, OnInit, Input } from '@angular/core';
import { AbrirChamadoService } from '../abrir-chamado/abrir-chamado.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-chamado-detail',
  templateUrl: './chamado-detail.component.html',
  styleUrls: ['./chamado-detail.component.css']
})

export class ChamadoDetailComponent implements OnInit {

  chamado: any = new Object();
  
  constructor(
    private route: ActivatedRoute,
    private chamadoService: AbrirChamadoService
    ) { }

  ngOnInit(): void {
    this.getChamado();
  }

  getChamado() {
    const id: string = this.route.snapshot.paramMap.get('id');
    this.chamado = this.chamadoService.getChamadoById(id);

    console.log(this.chamadoService.getChamadoById(id))
  }

  atualizaChamado() {
    //back-end salvar no banco as alterações
    //Caso inputStatus == Concluído, remover da tabela de consulta, MAS NÃO DO BANCO, MONGOL
  }
}
