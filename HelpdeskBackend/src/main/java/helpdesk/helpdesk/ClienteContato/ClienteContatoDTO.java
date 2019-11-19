package helpdesk.helpdesk.ClienteContato;

public class ClienteContatoDTO {
	
	public static final ClienteContatoDTO NULL_VALUE = new ClienteContatoDTO (-1l, "", "", "");
			
	private final Long id;
	private final String email;
	private final String telefone;
	private final String celular;
	
	public ClienteContatoDTO(Long id, String email, String telefone, String celular) {
		super();
		this.id = id;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCelular() {
		return celular;
	}
	
}
