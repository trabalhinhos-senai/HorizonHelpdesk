package helpdesk.helpdesk.Chamado;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import helpdesk.helpdesk.Cliente.ClienteEntity;
import helpdesk.helpdesk.TipoAtividade.TipoAtividadeEntity;
import helpdesk.helpdesk.Usuario.UsuarioEntity;

@Entity
(name = "tb_chamado")
public class ChamadoEntity {

	@Column
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private  String solicitante;
	private  String titulo;
	private  String descricao;
	private  String status;
	private  Date dataAbertura;
	private  Date dataAlvo;

	private  String prioridadeChamado;
	
	@ManyToOne
	private ClienteEntity cliente;
	
	@ManyToOne
	private TipoAtividadeEntity tipoAtividade;
	
	@ManyToOne
	private UsuarioEntity resposavel;
	
	
	protected ChamadoEntity() {
		
	}
	
	public ChamadoEntity(Long id, String solicitante, String titulo, String descricao, String status,
			Date dataAbertura, Date dataAlvo, String prioridadeChamado, ClienteEntity cliente, TipoAtividadeEntity tipoAtividade, UsuarioEntity resposavel) {
		
		this.id = id;
		this.solicitante = solicitante;
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = status;
		this.dataAbertura = dataAbertura;
		this.dataAlvo = dataAlvo;
		this.prioridadeChamado = prioridadeChamado;
		this.cliente = cliente;
		this.tipoAtividade = tipoAtividade;
		this.resposavel = resposavel;
		
	}

	@Override
	public String toString() {
		return "ChamadoEntity [id=" + id + ", solicitante=" + solicitante + ", titulo=" + titulo + ", descricao="
				+ descricao + ", status=" + status + ", dataAbertura=" + dataAbertura + ", dataAlvo=" + dataAlvo
				+  ", prioridadeChamado=" + prioridadeChamado + "]";
	}
	
	//Getters
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
	
	public ClienteEntity getCliente() {
		return cliente;
	}
	
	public TipoAtividadeEntity getTipoAtividade() {
		return tipoAtividade;
	}
	
	public UsuarioEntity getResponsavel() {
		return resposavel;
	}
	
	//Setters
	public void setId(Long id) {
		if(id != null)
			this.id = id;
	}
	
	public void setSolicitante(String solicitante) {
		if(solicitante != null)
			this.solicitante = solicitante;
	}

	public void setTitulo(String titulo) {
		if(titulo != null)
			this.titulo = titulo;
	}

	public void setDescricao(String descricao) {
		if(descricao != null)
			this.descricao = descricao;
	}

	public void setDataAbertura(Date dataAbertura) {
		if(dataAbertura != null)
			this.dataAbertura = dataAbertura;
	}

	public void setDataAlvo(Date dataAlvo) {
		if(dataAlvo != null)
			this.dataAlvo = dataAlvo;
	}

	public void setPrioridadeChamado(String prioridadeChamado) {
		if(prioridadeChamado != null)
			this.prioridadeChamado = prioridadeChamado;
	}

	public void setStatus(String status) {
		if(status != null)
			this.status = status;
	}
	
	public void setCliente(ClienteEntity clienteEntity) {
		if(clienteEntity != null)
			this.cliente = clienteEntity;
	}

	public void setTipoAtividade(TipoAtividadeEntity tipoAtividadeEntity) {
		if(tipoAtividadeEntity != null)
			this.tipoAtividade = tipoAtividadeEntity;
	}

	public void setResposavel(UsuarioEntity usuarioEntity) {
		if(usuarioEntity != null)
			this.resposavel = usuarioEntity;
	}
		
}
