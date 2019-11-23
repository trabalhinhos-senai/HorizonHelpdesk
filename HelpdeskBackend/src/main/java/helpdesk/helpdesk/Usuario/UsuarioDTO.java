package helpdesk.helpdesk.Usuario;

import helpdesk.helpdesk.Config.ConfigDTO;
import helpdesk.helpdesk.GrupoAcesso.GrupoAcessoDTO;

public class UsuarioDTO {

	public static final UsuarioDTO NULL_VALUE = new UsuarioDTO( -1l ,"", "", "", GrupoAcessoDTO.NULL_VALUE/*, ConfigDTO.NULL_VALUE*/);
	
	 private final Long id;
	 private final String nomeUsuario;
	 private final String loginUsuario;
	 private final String senhaUsuario;
	 
	 private final GrupoAcessoDTO grupoAcesso;
	 //private final ConfigDTO config;
	 
	 public UsuarioDTO(Long id, String nomeUsuario, String loginUsuario, String senhaUsuario, GrupoAcessoDTO grupoAcesso/*, ConfigDTO config*/) {
		 				//this.config = config;
						this.id= id;
						this.nomeUsuario = nomeUsuario;
						this.loginUsuario = loginUsuario;
						this.senhaUsuario = senhaUsuario;
						
						this.grupoAcesso = grupoAcesso;
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

	public GrupoAcessoDTO getGrupoAcesso() {
		return grupoAcesso;
	}

	/*public ConfigDTO getConfig() {
		return config;
	}*/


	
	
	
}
