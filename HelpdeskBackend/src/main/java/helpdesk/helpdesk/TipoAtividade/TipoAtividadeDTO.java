package helpdesk.helpdesk.TipoAtividade;

public class TipoAtividadeDTO {
	
	public static final TipoAtividadeDTO NULL_VALUE = new TipoAtividadeDTO(-1l, "");
	
	private final Long id;
	private final String descricao;
		
	public TipoAtividadeDTO(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
