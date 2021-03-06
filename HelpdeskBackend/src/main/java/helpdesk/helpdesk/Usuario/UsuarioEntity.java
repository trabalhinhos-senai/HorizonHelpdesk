package helpdesk.helpdesk.Usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import helpdesk.helpdesk.Config.ConfigEntity;
import helpdesk.helpdesk.GrupoAcesso.GrupoAcessoEntity;

@Entity
(name = "tb_usuario")
public class UsuarioEntity  {
	@Column
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeUsuario;
	@Column
	private String loginUsuario;
	@Column
	private String senhaUsuario;
	@ManyToOne
	private GrupoAcessoEntity grupoAcesso;
	
	/*@ManyToOne
	private ConfigEntity config;*/

	
	protected UsuarioEntity() {
	}
	
	public UsuarioEntity(Long id, String nomeUsuario, String loginUsuario, String senhaUsuario, GrupoAcessoEntity grupoAcesso/*, ConfigEntity config*/) {
		super();
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.loginUsuario = loginUsuario;
		this.senhaUsuario = senhaUsuario;
		this.grupoAcesso = grupoAcesso;
		/*this.config = config;*/
	}

	@Override
	public String toString() {
		return "UsuarioEntity [id=" + id + ", nomeUsuario=" + nomeUsuario + ", loginUsuario=" + loginUsuario + ", senhaUsuario=" + senhaUsuario + "]";
	}
	
	//----------
	public Long getId() {
		return id;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public String getLoginUsuario() {
		return loginUsuario;
	}
	
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	
	public GrupoAcessoEntity getGrupoAcesso() {	
		return grupoAcesso;
	}
	
	/*public ConfigEntity getConfig() {
		return config;
	}*/
	
	//----------------
	public void setId(Long id) {
		if(id != null)
			this.id = id;
	}

	public void setNomeUsuario(String nomeUsuario) {
		if(nomeUsuario != null)
			this.nomeUsuario = nomeUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		if(loginUsuario != null)
			this.loginUsuario = loginUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		if(senhaUsuario != null)
			this.senhaUsuario = senhaUsuario;
	}

	public void setGrupoAcesso(GrupoAcessoEntity grupoAcesso) {
		if(grupoAcesso != null)
			this.grupoAcesso = grupoAcesso;
	}
	
	/*public void setConfig(ConfigEntity configEntity) {
		if(configEntity != null)
			this.config = configEntity;
	}*/
	
}
