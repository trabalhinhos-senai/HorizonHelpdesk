export class SenhaComponet {

    // private usuario: Usuario = new Usuario();
    public cadastrado = false;
    public confirmarSenha: String;

    //Minimo 6 caracteres, ao menos uma letra e um numero:
    public padraoNormal: any = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$";

    //Minimo 8 caracteres, ao menos uma letra, um numero e um caractere especial:
    public padraoMedio: any = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";

    //Minimum eight characters, ao menos uma letra maiuscula, uma letra minuscula e um numero:
    public padraoAlto: any = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    errorMgs: string;
    selecaoPadrao: string;

    constructor() { }

    SenhaPadrao(padrao) {

        switch (padrao) {
            case 1:
                this.selecaoPadrao = this.padraoNormal;
                break;
            case 2:
                this.selecaoPadrao = this.padraoMedio;
                break;
            case 3:
                this.selecaoPadrao = this.padraoAlto;
                break;
            default:
                this.selecaoPadrao = this.padraoNormal;
                break;
        }

        if (padrao === this.padraoNormal) {
            return this.errorMgs = 'A senha deve ter no minimo 6 caracteres, ao menos um numero e um caracter.'
        } else if (padrao === this.padraoMedio) {
            return this.errorMgs = 'O minimo é 8 caracteres, ao menos uma letra, um numero e um caracter especial.'
        } else if (padrao === this.padraoAlto) {
            return this.errorMgs = 'O minimo é 8 caracteres, ao menos uma letra maiuscula, uma minuscula e um numero.'
        }

    }
}
