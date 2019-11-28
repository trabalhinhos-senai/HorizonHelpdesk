import { GrupoAcesso } from '../_DTO/gruposDeAcesso';
import { Config } from '../_DTO/config';

export class Usuario {

    id: Number;
    nomeUsuario: string;
    loginUsuario: string;
    senhaUsuario: string;
    grupoAcesso: GrupoAcesso;
}