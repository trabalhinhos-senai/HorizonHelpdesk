package helpdesk.helpdesk.Cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "tb_cliente")

public class ClienteEntity {

	@Column
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeCliente;
	private String cpfOuCnpj;
	
	@Override
	public String toString() {
		return "ClienteEntity [id=" + id + ", nomeCliente=" + nomeCliente + ", cpfOuCnpj=" + cpfOuCnpj + "]";
	}
	
	public ClienteEntity() {
		
	}
	
	public ClienteEntity(Long id, String nomeCliente, String cpfOuCnpj) {
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		if(id != null)
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
