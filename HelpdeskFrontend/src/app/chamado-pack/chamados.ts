import { Cliente } from 'src/app/cliente-pack/clientesDTO';
import { Usuario } from '../usuario-pack/usuarios';
import { TipoAtividade } from '../_DTO/tipoAtividade';

export class Chamado {

    id: Number;
    solicitante: string;
    titulo: string;
    descricao: string;
    status: string;
    dataAbertura: string;
    dataAlvo: string;
    prioridadeChamado: string;
    cliente: Cliente;
    responsavel: Usuario;
    tipoAtividade: TipoAtividade;
}