package helpdesk.helpdesk.Chamado;

import java.sql.Date;

public class ChamadoDTO {
	
	 public static final ChamadoDTO NULL_VALUE = new ChamadoDTO(-1l, "", "", "", "", null, null,"", -1l, "", -1l, "", -1l, "");
	 
 	 private final Long id;
	 private final String solicitante;
	 private final String titulo;
	 private final String descricao;
	 private final String status;
	 private final Date dataAbertura;
	 private final Date dataAlvo;
	 private final String prioridadeChamado;
	 
	 private final Long clienteId;
	 private final String clienteNome;
	 private final Long responsavelId;
	 private final String responsavelNome;
	 private final Long tipoAtividadeId;
	 private final String tipoAtividade;
	 
	 public ChamadoDTO(Long id, String solicitante, String titulo, String descricao, String status, Date dataAbertura, Date dataAlvo, 
			 String prioridadeChamado, Long clienteId, String clienteNome, Long responsavelId, String responsavelNome, Long tipoAtividadeId, String tipoAtividade) {
		this.id = id;
		this.status = status;
		this.solicitante = solicitante;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataAbertura = dataAbertura;
		this.dataAlvo = dataAlvo;
		this.prioridadeChamado = prioridadeChamado;
		this.clienteId = clienteId;
		this.clienteNome = clienteNome;
		this.responsavelId = responsavelId;
		this.responsavelNome = responsavelNome;
		this.tipoAtividadeId = tipoAtividadeId;
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

	public static ChamadoDTO getNullValue() {
		return NULL_VALUE;
	}

	public Long getClienteId() {
		return clienteId;
	}


	public String getClienteNome() {
		return clienteNome;
	}


	public Long getResponsavelId() {
		return responsavelId;
	}


	public String getResponsavelNome() {
		return responsavelNome;
	}


	public Long getTipoAtividadeId() {
		return tipoAtividadeId;
	}


	public String getTipoAtividade() {
		return tipoAtividade;
	}
		 
	
}
