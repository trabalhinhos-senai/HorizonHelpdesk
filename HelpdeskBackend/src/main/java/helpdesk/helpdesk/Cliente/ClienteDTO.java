package helpdesk.helpdesk.Cliente;

public class ClienteDTO {

	public static final ClienteDTO NULL_VALUE = new ClienteDTO(-1l, "", "", "", "", "", "", "", "", "", "");

	private final Long id;
	private final String nomeCliente;
	private final String cpfOuCnpj;
	private final String email;
	private final String telefone;
	private final String celular;
	private final String endereco;
	private final String numero;
	private final String bairro;
	private final String cidade;
	private final String estado;

	public ClienteDTO(Long id, String nomeCliente, String cpfOuCnpj, String email, String telefone, String celular,
			String endereco, String numero, String bairro, String cidade, String estado) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.cpfOuCnpj = cpfOuCnpj;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
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

	public Long getId() {
		return id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

}
