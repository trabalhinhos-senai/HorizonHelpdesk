/*export const Clientes = [
    {
        id: "1",
        nome: "Cooper",
        cpfcnpj: "123123123",
        endereco: "Rua Seis",
        numero: "34",
        cidade: "Indaial",
        estado: "Santa Catarina",
        bairro: "Tapajos",
        email: "cooper.com.br@.com.br",
        telefone: "34587363",
        celular: "96787893",
    },
    {
        id: "2",
        nome: "Jeniffer",
        cpfcnpj: "881231233",
        endereco: "Rua Sete",
        numero: "3394",
        cidade: "Ascurra",
        estado: "Rio de Janeiro",
        bairro: "Monte Alegre",
        email: "cooper.cor@.com.br",
        telefone: "33223232",
        celular: "99083633",
    }
]*/

export class Cliente {
    
    id: Number;
    nomeCliente: String;
    cpfOuCnpj: String;

    endereco: String;
    numero: String;
    cidade: String;
    estado: String;
    bairro: String;
    email: String;
    telefone: String;
    celular: String;
}