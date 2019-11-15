package helpdesk.helpdesk.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;

@Controller
public class ClienteController {
	
	private final ClienteRepository ClienteRepository;
	
	ClienteController(final ClienteRepository ClienteRepository) {
	    this.ClienteRepository = ClienteRepository;
	}
	
	private static ClienteEntity toEntity(final ClienteDTO clienteDTO) {
		final Long id = clienteDTO.getId();
		final String nomeCliente = clienteDTO.getNomeCliente();
		final String cpfOuCnpj = clienteDTO.getCpfOuCnpj();
		
		return new ClienteEntity(id, nomeCliente, cpfOuCnpj);
	} 
	
	private static ClienteDTO toDTO(final ClienteEntity clienteEntity) {
		final Long id = clienteEntity.getId();
		final String nomeCliente = clienteEntity.getNomeCliente();
		final String cpfOuCnpj = clienteEntity.getCpfOuCnpj();
		
		return new ClienteDTO(id,nomeCliente, cpfOuCnpj);
	}
	
	private static void updateEntityFromDTO(final ClienteDTO clienteDTO, final ClienteEntity clienteEntity) {
		clienteEntity.setId(clienteDTO.getId());
		clienteEntity.setNomeCliente(clienteDTO.getNomeCliente());
		clienteEntity.setCpfOuCnpj(clienteDTO.getCpfOuCnpj());
			
	}
	
	List<ClienteDTO> getAllClientes(){
		final List<ClienteDTO> clientes = new ArrayList<>();
		this.ClienteRepository.findAll().forEach(clienteEntity -> clientes.add(ClienteController.toDTO(clienteEntity)));
		return clientes;
	}
	
	ClienteDTO getCliente(final Long id) {
		final Optional<ClienteEntity> optionalCliente = this.ClienteRepository.findById(id);
		if(optionalCliente.isPresent()) {
			return ClienteController.toDTO(optionalCliente.get());
		}
		return ClienteDTO.NULL_VALUE;
	}
	
	ClienteDTO removeCliente(final Long id) {
		final Optional<ClienteEntity> optionalCliente = this.ClienteRepository.findById(id);
		if(optionalCliente.isPresent()) {
			final ClienteEntity clienteEntity = optionalCliente.get();
			this.ClienteRepository.delete(clienteEntity);
			return ClienteController.toDTO(clienteEntity);
		}
		return ClienteDTO.NULL_VALUE;
	}
	
	Long insertCliente(final ClienteDTO ClienteDTO) {
		final ClienteEntity clienteEntity = ClienteController.toEntity(ClienteDTO);
		this.ClienteRepository.save(clienteEntity);
		return clienteEntity.getId();
	}
	
	ClienteDTO updateCliente(final Long id, final ClienteDTO clienteDTO) {
		final Optional<ClienteEntity> optionalCliente = this.ClienteRepository.findById(id);
		if(optionalCliente.isPresent()) {
			final ClienteEntity clienteEntity = optionalCliente.get();
			final ClienteDTO oldCliente = ClienteController.toDTO(clienteEntity);
			ClienteController.updateEntityFromDTO(clienteDTO, clienteEntity);
			this.ClienteRepository.save(clienteEntity);
			return oldCliente;
		}
		return ClienteDTO.NULL_VALUE;
	}	
	

}
