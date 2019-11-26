package helpdesk.helpdesk.Cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_cliente")

public class ClienteEntity {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeCliente;
	private String cpfOuCnpj;
	private String endereco;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String email;
	private String telefone;
	private String celular;

	public ClienteEntity(Long id, String nomeCliente, String cpfOuCnpj, String endereco, String numero, String bairro,
			String cidade, String estado, String email, String telefone, String celular) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.cpfOuCnpj = cpfOuCnpj;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
	}

	public ClienteEntity() {

	}

	@Override
	public String toString() {
		return "ClienteEntity [id=" + id + ", nomeCliente=" + nomeCliente + ", cpfOuCnpj=" + cpfOuCnpj + ", endereco="
				+ endereco + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado
				+ ", email=" + email + ", telefone=" + telefone + ", celular=" + celular + "]";
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id != null)
			this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

}
