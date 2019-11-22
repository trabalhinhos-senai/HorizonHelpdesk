package helpdesk.helpdesk.Config;

public class ConfigDTO {
	
	public static final ConfigDTO NULL_VALUE = new ConfigDTO( -1l ,"", "", "", "");

	private final Long id;
	
	private final String nomeEmpresa;
	private final String telefoneEmpresa;
	private final String emailEmpresa;
	private final String enderecoCompletoEmpresa;
	
	
	
	public ConfigDTO(Long id, String nomeEmpresa, String telefoneEmpresa, String emailEmpresa,
			String enderecoCompletoEmpresa) {
		this.id = id;
		this.nomeEmpresa = nomeEmpresa;
		this.telefoneEmpresa = telefoneEmpresa;
		this.emailEmpresa = emailEmpresa;
		this.enderecoCompletoEmpresa = enderecoCompletoEmpresa;
	}
	
	public Long getId() {
		return id;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public String getTelefoneEmpresa() {
		return telefoneEmpresa;
	}
	public String getEmailEmpresa() {
		return emailEmpresa;
	}
	public String getEnderecoCompletoEmpresa() {
		return enderecoCompletoEmpresa;
	}	

	
	
}
