package helpdesk.helpdesk.ClienteEndereco;

public class ClienteEnderecoDTO {
	
	public static final ClienteEnderecoDTO NULL_VALUE = new ClienteEnderecoDTO( -1l , "", "", "", "", ""); 
	
	private final Long id;
	private final String endereco;
	private final String numero;
	private final String bairro;
	private final String cidade;
	private final String estado;
	
	public ClienteEnderecoDTO(Long id, String endereco, String numero, String bairro, String cidade, String estado) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public static ClienteEnderecoDTO getNullValue() {
		return NULL_VALUE;
	}

	public Long getId() {
		return id;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}
	
}
