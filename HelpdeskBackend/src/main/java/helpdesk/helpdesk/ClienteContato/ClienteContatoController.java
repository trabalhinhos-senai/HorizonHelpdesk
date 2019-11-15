package helpdesk.helpdesk.ClienteContato;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;


@Controller
public class ClienteContatoController {

private final ClienteContatoRepository clienteContatoRepository;
	
	ClienteContatoController(final ClienteContatoRepository clienteContatoRepository) {
	    this.clienteContatoRepository = clienteContatoRepository;
	}
	
	private static ClienteContatoEntity toEntity(final ClienteContatoDTO clienteContatoDTO) {
		final Long id = clienteContatoDTO.getId();
		final String email = clienteContatoDTO.getEmail();
		final String telefone = clienteContatoDTO.getTelefone();
		final String celular = clienteContatoDTO.getCelular();

		return new ClienteContatoEntity(id, email, telefone, celular);
	} 
	
	private static ClienteContatoDTO toDTO(final ClienteContatoEntity clienteContatoEntity) {
		final Long id = clienteContatoEntity.getId();
		final String email = clienteContatoEntity.getEmail();
		final String telefone = clienteContatoEntity.getTelefone();
		final String celular = clienteContatoEntity.getCelular();
	
		return new ClienteContatoDTO(id, email, telefone, celular);
	}
	
	private static void updateEntityFromDTO(final ClienteContatoDTO clienteContatoDTO, final ClienteContatoEntity clienteContatoEntity) {
		clienteContatoEntity.setId(clienteContatoDTO.getId());
		clienteContatoEntity.setEmail(clienteContatoDTO.getEmail());
		clienteContatoEntity.setTelefone(clienteContatoDTO.getTelefone());
		clienteContatoEntity.setCelular(clienteContatoDTO.getCelular());
		
		
	}
	
	List<ClienteContatoDTO> getAllClienteContatos(){
		final List<ClienteContatoDTO> ClienteContatos = new ArrayList<>();
		this.clienteContatoRepository.findAll().forEach(clienteContatoEntity -> ClienteContatos.add(ClienteContatoController.toDTO(clienteContatoEntity)));
		return ClienteContatos;
	}
	
	ClienteContatoDTO getClienteContato(final Long id) {
		final Optional<ClienteContatoEntity> optionaClietneContato = this.clienteContatoRepository.findById(id);
		if(optionaClietneContato.isPresent()) {
			return ClienteContatoController.toDTO(optionaClietneContato.get());
		}
		return ClienteContatoDTO.NULL_VALUE;
	}
	
	ClienteContatoDTO removeClienteContato(final Long id) {
		final Optional<ClienteContatoEntity> optionaClietneContato = this.clienteContatoRepository.findById(id);
		if(optionaClietneContato.isPresent()) {
			final ClienteContatoEntity clienteContatoEntity = optionaClietneContato.get();
			this.clienteContatoRepository.delete(clienteContatoEntity);
			return ClienteContatoController.toDTO(clienteContatoEntity);
		}
		return ClienteContatoDTO.NULL_VALUE;
	}
	
	Long insertClienteContato(final ClienteContatoDTO clienteContatoDTO) {
		final ClienteContatoEntity clienteContatoEntity = ClienteContatoController.toEntity(clienteContatoDTO);
		this.clienteContatoRepository.save(clienteContatoEntity);
		return clienteContatoEntity.getId();
	}
	
	ClienteContatoDTO updateClienteContato(final Long id, final ClienteContatoDTO clienteContatoDTO) {
		final Optional<ClienteContatoEntity> optionaClietneContato = this.clienteContatoRepository.findById(id);
		if(optionaClietneContato.isPresent()) {
			final ClienteContatoEntity clienteContatoEntity = optionaClietneContato.get();
			final ClienteContatoDTO oldClienteContato = ClienteContatoController.toDTO(clienteContatoEntity);
			ClienteContatoController.updateEntityFromDTO(clienteContatoDTO, clienteContatoEntity);
			this.clienteContatoRepository.save(clienteContatoEntity);
			return oldClienteContato;
		}
		return ClienteContatoDTO.NULL_VALUE;
	}
	
	public boolean isExistsClienteContatoByIdentifier(final Long id) {
		return this.clienteContatoRepository.existsById(id);
	}
	
}
