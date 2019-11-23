import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ControleSenhaService {

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

  senhaPadrao(tipo) {

    switch (tipo) {
      case "Normal":
        tipo = this.padraoNormal;
        break;
      case "Medio":
        tipo = this.padraoMedio;
        break;
      case "Alto":
        tipo = this.padraoAlto;
        break;
      default:
        tipo = this.padraoNormal;
        break;
    }

    this.selecaoPadrao = tipo; //pode alterar entre as tres opções acima

    if (this.selecaoPadrao === this.padraoNormal) {
      this.errorMgs = 'A senha deve ter no minimo 6 caracteres, ao menos um numero e um caracter.'
    } else if (this.selecaoPadrao === this.padraoMedio) {
      this.errorMgs = 'O minimo é 8 caracteres, ao menos uma letra, um numero e um caracter especial.'
    } else if (this.selecaoPadrao === this.padraoAlto) {
      this.errorMgs = 'O minimo é 8 caracteres, ao menos uma letra maiuscula, uma minuscula e um numero.'
    }

  }
}
