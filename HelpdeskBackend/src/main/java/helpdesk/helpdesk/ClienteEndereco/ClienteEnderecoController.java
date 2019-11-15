package helpdesk.helpdesk.ClienteEndereco;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

@Controller
public class ClienteEnderecoController {


	private final ClienteEnderecoRepository clienteEnderecoRepository;
	
	ClienteEnderecoController(final ClienteEnderecoRepository clienteEnderecoRepository) {
	    this.clienteEnderecoRepository = clienteEnderecoRepository;
	}
	
	private static ClienteEnderecoEntity toEntity(final ClienteEnderecoDTO clienteEnderecoDTO) {
		final Long id = clienteEnderecoDTO.getId();
		final String endereco = clienteEnderecoDTO.getEndereco() ;
		final String numero = clienteEnderecoDTO.getNumero() ;
		final String bairro = clienteEnderecoDTO.getBairro() ;
		final String cidade = clienteEnderecoDTO.getCidade() ;
		final String estado = clienteEnderecoDTO.getEstado() ;
		
		return new ClienteEnderecoEntity(id,endereco,numero,bairro,cidade,estado);
	} 
	
	private static ClienteEnderecoDTO toDTO(final ClienteEnderecoEntity clienteEnderecoEntity) {
		final Long id = clienteEnderecoEntity.getId();
		final String endereco = clienteEnderecoEntity.getEndereco() ;
		final String numero = clienteEnderecoEntity.getNumero() ;
		final String bairro = clienteEnderecoEntity.getBairro() ;
		final String cidade = clienteEnderecoEntity.getCidade() ;
		final String estado = clienteEnderecoEntity.getEstado() ;
		
		return new ClienteEnderecoDTO(id,endereco,numero,bairro,cidade,estado);
	}
	
	private static void updateEntityFromDTO(final ClienteEnderecoDTO clienteEnderecoDTO, final ClienteEnderecoEntity clienteEnderecoEntity) {
		clienteEnderecoEntity.setId(clienteEnderecoDTO.getId());
		clienteEnderecoEntity.setEndereco(clienteEnderecoDTO.getEndereco());
		clienteEnderecoEntity.setNumero(clienteEnderecoDTO.getNumero());
		clienteEnderecoEntity.setBairro(clienteEnderecoDTO.getBairro());
		clienteEnderecoEntity.setCidade(clienteEnderecoDTO.getCidade());
		clienteEnderecoEntity.setEstado(clienteEnderecoDTO.getEstado());
		
		
	}
	
	List<ClienteEnderecoDTO> getAllClienteEnderecos(){
		final List<ClienteEnderecoDTO> clienteEnderecos = new ArrayList<>();
		this.clienteEnderecoRepository.findAll().forEach(clienteEnderecoEntity -> clienteEnderecos.add(ClienteEnderecoController.toDTO(clienteEnderecoEntity)));
		return clienteEnderecos;
	}
	
	ClienteEnderecoDTO getClienteEndereco(final Long id) {
		final Optional<ClienteEnderecoEntity> optionalClienteEndereco = this.clienteEnderecoRepository.findById(id);
		if(optionalClienteEndereco.isPresent()) {
			return ClienteEnderecoController.toDTO(optionalClienteEndereco.get());
		}
		return ClienteEnderecoDTO.NULL_VALUE;
	}
	
	ClienteEnderecoDTO removeClienteEndereco(final Long id) {
		final Optional<ClienteEnderecoEntity> optionalClienteEndereco = this.clienteEnderecoRepository.findById(id);
		if(optionalClienteEndereco.isPresent()) {
			final ClienteEnderecoEntity clienteEnderecoEntity = optionalClienteEndereco.get();
			this.clienteEnderecoRepository.delete(clienteEnderecoEntity);
			return ClienteEnderecoController.toDTO(clienteEnderecoEntity);
		}
		return ClienteEnderecoDTO.NULL_VALUE;
	}
	
	Long insertClienteEndereco(final ClienteEnderecoDTO clienteEnderecoDTO) {
		final ClienteEnderecoEntity clienteEnderecoEntity = ClienteEnderecoController.toEntity(clienteEnderecoDTO);
		this.clienteEnderecoRepository.save(clienteEnderecoEntity);
		return clienteEnderecoEntity.getId();
	}
	
	ClienteEnderecoDTO updateClienteEndereco(final Long id, final ClienteEnderecoDTO clienteEnderecoDTO) {
		final Optional<ClienteEnderecoEntity> optionalClienteEndereco = this.clienteEnderecoRepository.findById(id);
		if(optionalClienteEndereco.isPresent()) {
			final ClienteEnderecoEntity clienteEnderecoEntity = optionalClienteEndereco.get();
			final ClienteEnderecoDTO oldClienteEndereco = ClienteEnderecoController.toDTO(clienteEnderecoEntity);
			ClienteEnderecoController.updateEntityFromDTO(clienteEnderecoDTO, clienteEnderecoEntity);
			this.clienteEnderecoRepository.save(clienteEnderecoEntity);
			return oldClienteEndereco;
		}
		return ClienteEnderecoDTO.NULL_VALUE;
	}
	
	public boolean isExistsClienteEnderecoByIdentifier(final Long id) {
		return this.clienteEnderecoRepository.existsById(id);
	}
	
	
}
