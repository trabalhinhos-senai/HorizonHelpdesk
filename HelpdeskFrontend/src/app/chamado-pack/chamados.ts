export const Chamados = [
    {
        id: "1",
        solicitante: "Igor Ponchielli",
        cliente: "Ponchielli LTDA",
        titulo: "Estou com um problema",
        tipo: "Problema",
        descricao: "Estou com um problema muito problematico",
        responsavel: "Jaison",
        prioridade: "Alta",
        data_abertura: new Date("2019-01-26 00:00:00").toLocaleDateString(),
        data_alvo: new Date("2019-01-29 00:00:00").toISOString().slice(0,10),
        status: "Em desenvolvimento",
    },
    {
        id: "2",
        solicitante: "Benjamin Arrola",
        cliente: "Peixola S.A.",
        titulo: "Corrigir um erro",
        tipo: "Correção",
        descricao: "Estou com um problema para ser corrigido",
        responsavel: "Leonardo",
        prioridade: "Baixa",
        data_abertura: new Date("2019-08-28 00:00:00").toLocaleDateString(),
        data_alvo: new Date("2019-09-12 00:00:00").toISOString().slice(0,10),
        status: "Aguardando"
    }
]

export class Chamado {
    id: string;
    solicitante: string;
    cliente: string;
    titulo: string;
    tipo: string;
    descricao: string;
    responsavel: string;
    prioridade: string;
    data_abertura: string;
    data_alvo: Date;
}