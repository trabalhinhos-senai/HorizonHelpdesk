package helpdesk.helpdesk.Config;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
(name = "tb_config")
public class ConfigEntity {
	@Column
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeEmpresa;
	private String telefoneEmpresa;
	private String emailEmpresa;
	private String enderecoCompretoEmpresa;	
	
	public ConfigEntity() {
		super();
	}

	public ConfigEntity(Long id, String nomeEmpresa, String telefoneEmpresa, String emailEmpresa,
			String enderecoCompretoEmpresa) {
		super();
		this.id = id;
		this.nomeEmpresa = nomeEmpresa;
		this.telefoneEmpresa = telefoneEmpresa;
		this.emailEmpresa = emailEmpresa;
		this.enderecoCompretoEmpresa = enderecoCompretoEmpresa;
	}
	
	@Override
	public String toString() {
		return "ConfigEntity [id=" + id + ", nomeEmpresa=" + nomeEmpresa + ", telefoneEmpresa=" + telefoneEmpresa
				+ ", emailEmpresa=" + emailEmpresa + ", enderecoCompretoEmpresa=" + enderecoCompretoEmpresa + "]";
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	
	public String getTelefoneEmpresa() {
		return telefoneEmpresa;
	}
	
	public void setTelefoneEmpresa(String telefoneEmpresa) {
		this.telefoneEmpresa = telefoneEmpresa;
	}
	
	public String getEmailEmpresa() {
		return emailEmpresa;
	}
	
	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}
	
	public String getEnderecoCompretoEmpresa() {
		return enderecoCompretoEmpresa;
	}
	
	public void setEnderecoCompretoEmpresa(String enderecoCompretoEmpresa) {
		this.enderecoCompretoEmpresa = enderecoCompretoEmpresa;
	}

	
}
