package helpdesk.helpdesk.Usuario;

public class UsuarioDTO {

	public static final UsuarioDTO NULL_VALUE = new UsuarioDTO( -1l ,"", "", "", "",-1l);
	
	 private final Long id;
	 private final String nomeUsuario;
	 private final String loginUsuario;
	 private final String senhaUsuario;
	 
	 private final String grupoAcessoNome;
	 private final Long configEntityId;
	 
	 public UsuarioDTO(Long id, String nomeUsuario, String loginUsuario, String senhaUsuario, 
			 String grupoAcessoNome, Long configEntityId) {
		 				this.id= id;
						this.nomeUsuario = nomeUsuario;
						this.loginUsuario = loginUsuario;
						this.senhaUsuario = senhaUsuario;
						
						this.grupoAcessoNome = grupoAcessoNome;
						this.configEntityId = configEntityId;
	}

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

	public String getGrupoAcessoNome() {
		return grupoAcessoNome;
	}

	public Long getConfigEntityId() {
		return configEntityId;
	}
	
	
	
}
