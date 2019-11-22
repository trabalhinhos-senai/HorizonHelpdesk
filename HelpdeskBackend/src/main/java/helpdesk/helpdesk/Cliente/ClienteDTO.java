package helpdesk.helpdesk.Cliente;

public class ClienteDTO {

	public static final ClienteDTO NULL_VALUE = new ClienteDTO(-1l,"","");
	
	private final Long id;
	private final String nomeCliente;
	private final String cpfOuCnpj;
	
	
	
	public ClienteDTO(Long id ,String nomeCliente, String cpfOuCnpj) {
		this.id=id;
		this.nomeCliente = nomeCliente;
		this.cpfOuCnpj = cpfOuCnpj;
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
