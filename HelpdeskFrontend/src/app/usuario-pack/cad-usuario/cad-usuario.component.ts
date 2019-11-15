import { Component, OnInit } from '@angular/core';
import { Usuario } from '../usuarios';
import { NgForm } from '@angular/forms';
import { UsuarioService } from '../usuarios/usuario.service';

@Component({
  selector: 'app-cad-usuario',
  templateUrl: './cad-usuario.component.html',
  styleUrls: ['./cad-usuario.component.css']
})
export class CadUsuarioComponent implements OnInit {

  private usuario: Usuario;

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

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit() {
    this.usuario = new Usuario();

    this.selecaoPadrao = this.padraoNormal; //pode alterar entre as tres opções acima

    if (this.selecaoPadrao === this.padraoNormal) {
      this.errorMgs = 'A senha deve ter no minimo 6 caracteres, ao menos um numero e um caracter.'
    } else if (this.selecaoPadrao === this.padraoMedio) {
      this.errorMgs = 'O minimo é 8 caracteres, ao menos uma letra, um numero e um caracter especial.'
    } else if (this.selecaoPadrao === this.padraoAlto) {
      this.errorMgs = 'O minimo é 8 caracteres, ao menos uma letra maiuscula, uma minuscula e um numero.'
    }

  }

  onSubmit(formulario: NgForm) {
    
    if (formulario.valid) {

      this.usuarioService.createUser(this.usuario).subscribe(
        id => {
          this.usuario = new Usuario();
          this.showAlert();
        }
      );
      /*if (this.usuario.senha === this.confirmarSenha) {

        console.log(this.usuario)
        this.cadUsuarioService.cadastrar(this.usuario);
        console.log(this.usuario.nome)

        this.showAlert();

      } else {
        console.log("não confere");
      }*/


    }
  }

  showAlert() {

    //aparecer caixa de mensagem
    this.cadastrado = true;

    //aguarda 3 Segundos e esconde
    setTimeout(function () {
      alert("Cadastrado com sucesso!");
      this.cadastrado = false;

      //console.log(this.cadastrado);
    }.bind(this), 3000);

  }

}
