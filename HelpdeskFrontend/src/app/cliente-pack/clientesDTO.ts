export class Cliente {
    id: Number;
    nomeCliente: String;
    cpfOuCnpj: String;
}

export class ClienteEndereco {
    id: Number;
    endereco: String;
    numero: String;
    bairro: String;
    cidade: String;
    estado: String;
    cliente: Cliente;
}

export class ClienteContato {
    id: Number;
    email: String;
    telefone: String;
    celular: String;
    cliente: Cliente;
}