import { Cliente } from 'src/app/cliente-pack/clientesDTO';

export class Chamado {

    id: Number;
    solicitante: string;
    titulo: string;
    descricao: string;
    status: string;
    dataAbertura: string;
    dataAlvo: string;
    prioridadeChamado: string;

    cliente = new Cliente();

    /*clienteId: Number;
    clienteNome: string;
    responsavelId: Number;
    responsavelNome: string;
    tipoAtividadeId: Number;
    tipoAtividade: string;*/

}