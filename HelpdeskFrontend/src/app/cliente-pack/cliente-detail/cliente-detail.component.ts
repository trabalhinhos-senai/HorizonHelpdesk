import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CadClienteService } from '../cad-cliente/cad-cliente.service';

@Component({
  selector: 'app-cliente-detail',
  templateUrl: './cliente-detail.component.html',
  styleUrls: ['./cliente-detail.component.css']
})
export class ClienteDetailComponent implements OnInit {

  cliente: any = new Object();
  
  constructor(
    private route: ActivatedRoute,
    private clienteService: CadClienteService
    ) { }

  ngOnInit(): void {
    //this.getCliente();
  }

  getCliente() {
    /*const id: string = this.route.snapshot.paramMap.get('id');
    this.cliente = this.clienteService.getClienteById(id);

    console.log(this.clienteService.getClienteById(id))*/
  }

}
