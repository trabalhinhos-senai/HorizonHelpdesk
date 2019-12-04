package helpdesk.helpdesk.GrupoAcesso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
(name = "tb_grupoacesso")

public class GrupoAcessoEntity {

	@Column
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeGrupo;
	
	protected GrupoAcessoEntity() {
		
	}
	
	public GrupoAcessoEntity(Long id, String nomeGrupo) {
		this.id = id;
		this.nomeGrupo = nomeGrupo;
	}
	
	@Override
	public String toString() {
		return "GrupoAcessoEntity [id=" + id + ", nomeGrupo=" + nomeGrupo + "]";
	}
	
	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		if(nomeGrupo != null)
			this.nomeGrupo = nomeGrupo;
	}
	
	public void setId(Long id) {
		if(id != null)
			this.id = id;
	}

	public Long getId() {
		return id;
	}
}
