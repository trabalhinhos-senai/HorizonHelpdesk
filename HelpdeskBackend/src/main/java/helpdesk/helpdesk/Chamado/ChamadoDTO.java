package helpdesk.helpdesk.Chamado;

import java.sql.Date;

import helpdesk.helpdesk.Cliente.ClienteDTO;
import helpdesk.helpdesk.Cliente.ClienteEntity;
import helpdesk.helpdesk.TipoAtividade.TipoAtividadeDTO;
import helpdesk.helpdesk.Usuario.UsuarioDTO;

public class ChamadoDTO {
	
	 public static final ChamadoDTO NULL_VALUE = new ChamadoDTO(-1l, "", "", "", "", null, null, "", ClienteDTO.NULL_VALUE, TipoAtividadeDTO.NULL_VALUE, UsuarioDTO.NULL_VALUE);
	 
 	 private final Long id;
	 private final String solicitante;
	 private final String titulo;
	 private final String descricao;
	 private final String status;
	 private final Date dataAbertura;
	 private final Date dataAlvo;
	 private final String prioridadeChamado;
	 
	 private final ClienteDTO cliente;
	 private final UsuarioDTO responsavel;
	 private final TipoAtividadeDTO tipoAtividade;
	 
	 public ChamadoDTO(Long id, String solicitante, String titulo, String descricao, String status, Date dataAbertura, Date dataAlvo, 
			 String prioridadeChamado,  ClienteDTO cliente, TipoAtividadeDTO tipoAtividade, UsuarioDTO responsavel) {

		this.id = id;
		this.status = status;
		this.solicitante = solicitante;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataAbertura = dataAbertura;
		this.dataAlvo = dataAlvo;
		this.prioridadeChamado = prioridadeChamado;
		this.cliente = cliente;
		this.responsavel = responsavel;
		this.tipoAtividade = tipoAtividade;
		
	}
	 
	 
	public Long getId() {
		return id;
	}
 
	public String getSolicitante() {
		return solicitante;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public Date getDataAlvo() {
		return dataAlvo;
	}
	
	public String getPrioridadeChamado() {
		return prioridadeChamado;
	}

	public String getStatus() {
		return status;
	}


	public ClienteDTO getCliente() {
		return cliente;
	}


	public UsuarioDTO getResponsavel() {
		return responsavel;
	}


	public TipoAtividadeDTO getTipoAtividade() {
		return tipoAtividade;
	}
	
	
}
