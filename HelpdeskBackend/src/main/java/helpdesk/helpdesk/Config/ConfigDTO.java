package helpdesk.helpdesk.Config;

public class ConfigDTO {
	
	public static final ConfigDTO NULL_VALUE = new ConfigDTO( -1l ,"", "", "", "");

	private final Long id;
	
	private final String nomeEmpresa;
	private final String telefoneEmpresa;
	private final String emailEmpresa;
	private final String enderecoCompretoEmpresa;
	
	
	
	public ConfigDTO(Long id, String nomeEmpresa, String telefoneEmpresa, String emailEmpresa,
			String enderecoCompretoEmpresa) {
		this.id = id;
		this.nomeEmpresa = nomeEmpresa;
		this.telefoneEmpresa = telefoneEmpresa;
		this.emailEmpresa = emailEmpresa;
		this.enderecoCompretoEmpresa = enderecoCompretoEmpresa;
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
	public String getEnderecoCompretoEmpresa() {
		return enderecoCompretoEmpresa;
	}	

	
	
}
