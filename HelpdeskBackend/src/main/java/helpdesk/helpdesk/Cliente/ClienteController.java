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

	public static ClienteEntity toEntity(final ClienteDTO clienteDTO) {
		final Long id = clienteDTO.getId();
		final String nomeCliente = clienteDTO.getNomeCliente();
		final String cpfOuCnpj = clienteDTO.getCpfOuCnpj();
		final String email = clienteDTO.getEmail();
		final String telefone = clienteDTO.getTelefone();
		final String celular = clienteDTO.getCelular();
		final String endereco = clienteDTO.getEndereco();
		final String numero = clienteDTO.getNumero();
		final String bairro = clienteDTO.getBairro();
		final String cidade = clienteDTO.getCidade();
		final String estado = clienteDTO.getEstado();

		return new ClienteEntity(id, nomeCliente, cpfOuCnpj,email,telefone,celular,endereco,numero,bairro,cidade,estado);
	}

	private static ClienteDTO toDTO(final ClienteEntity clienteEntity) {
		final Long id = clienteEntity.getId();
		final String nomeCliente = clienteEntity.getNomeCliente();
		final String cpfOuCnpj = clienteEntity.getCpfOuCnpj();
		final String email = clienteEntity.getEmail();
		final String telefone = clienteEntity.getTelefone();
		final String celular = clienteEntity.getCelular();
		final String endereco = clienteEntity.getEndereco();
		final String numero = clienteEntity.getNumero();
		final String bairro = clienteEntity.getBairro();
		final String cidade = clienteEntity.getCidade();
		final String estado = clienteEntity.getEstado();

		return new ClienteDTO(id, nomeCliente, cpfOuCnpj,email,telefone,celular,endereco,numero,bairro,cidade,estado);
	}

	private static void updateEntityFromDTO(final ClienteDTO clienteDTO, final ClienteEntity clienteEntity) {
		clienteEntity.setId(clienteDTO.getId());
		clienteEntity.setNomeCliente(clienteDTO.getNomeCliente());
		clienteEntity.setCpfOuCnpj(clienteDTO.getCpfOuCnpj());
		clienteEntity.setEmail(clienteDTO.getEmail());
		clienteEntity.setTelefone(clienteDTO.getTelefone());
		clienteEntity.setCelular(clienteDTO.getCelular());
		clienteEntity.setEndereco(clienteDTO.getEndereco());
		clienteEntity.setNumero(clienteDTO.getNumero());
		clienteEntity.setBairro(clienteDTO.getBairro());
		clienteEntity.setCidade(clienteDTO.getCidade());
		clienteEntity.setEstado(clienteDTO.getEstado());

	}

	List<ClienteDTO> getAllClientes() {
		final List<ClienteDTO> clientes = new ArrayList<>();
		this.ClienteRepository.findAll().forEach(clienteEntity -> clientes.add(ClienteController.toDTO(clienteEntity)));
		return clientes;
	}

	ClienteDTO getCliente(final Long id) {
		final Optional<ClienteEntity> optionalCliente = this.ClienteRepository.findById(id);
		if (optionalCliente.isPresent()) {
			return ClienteController.toDTO(optionalCliente.get());
		}
		return ClienteDTO.NULL_VALUE;
	}

	ClienteDTO removeCliente(final Long id) {
		final Optional<ClienteEntity> optionalCliente = this.ClienteRepository.findById(id);
		if (optionalCliente.isPresent()) {
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
		if (optionalCliente.isPresent()) {
			final ClienteEntity clienteEntity = optionalCliente.get();
			final ClienteDTO oldCliente = ClienteController.toDTO(clienteEntity);
			ClienteController.updateEntityFromDTO(clienteDTO, clienteEntity);
			this.ClienteRepository.save(clienteEntity);
			return oldCliente;
		}
		return ClienteDTO.NULL_VALUE;
	}

}
