package helpdesk.helpdesk.ClienteEndereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import helpdesk.helpdesk.Cliente.ClienteEntity;

@Entity (name = "tb_cliente_endereco")
public class ClienteEnderecoEntity {
	
	@Column
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String endereco;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	
	@ManyToOne
	private ClienteEntity clienteEntity;

	public ClienteEnderecoEntity() {
		super();
	}

	public ClienteEnderecoEntity(Long id, String endereco, String numero, String bairro, String cidade, String estado) {
		this.id = id;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}	
	
	@Override
	public String toString() {
		return "ClienteEnderecoEntity [id=" + id + ", endereco=" + endereco + ", numero=" + numero + ", bairro="
				+ bairro + ", cidade=" + cidade + ", estado=" + estado + "]";
	}

	//---------------
	public Long getId() {
		return id;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public ClienteEntity getClienteEntity() {
		return clienteEntity;
	}
	//--------------
	
	public void setId(Long id) {
		if(id != null)
		this.id = id;
	}	
		
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}	
	
	public void setClienteEntity(ClienteEntity clienteEntity) {
		this.clienteEntity = clienteEntity;
	}

}
