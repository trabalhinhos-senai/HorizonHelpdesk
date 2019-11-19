package helpdesk.helpdesk.ClienteContato;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import helpdesk.helpdesk.Cliente.ClienteEntity;

@Entity (name = "tb_cliente_contato")
public class ClienteContatoEntity {
	@Column
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String telefone;
	private String celular;
	
	@ManyToOne
	private ClienteEntity clienteEntity;
	
	public ClienteContatoEntity() {
	}

	public ClienteContatoEntity(Long id, String email, String telefone, String celular) {
		this.id = id;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "ClienteContatoEntity [id=" + id + ", email=" + email + ", telefone=" + telefone + ", celular=" + celular
				+ "]";
	}
	
	//--------------
	public Long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public ClienteEntity getClienteEntity() {
		return clienteEntity;
	}
	
	//-----------------
	public void setId(Long id) {
		if(id != null)
		this.id = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public void setClienteEntity(ClienteEntity clienteEntity) {
		this.clienteEntity = clienteEntity;
	}
	
}	
	
