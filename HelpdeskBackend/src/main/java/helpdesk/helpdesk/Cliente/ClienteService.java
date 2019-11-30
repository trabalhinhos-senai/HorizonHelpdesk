package helpdesk.helpdesk.Cliente;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import helpdesk.helpdesk.OnInitDB;

@RestController
@RequestMapping("/api/cliente")
public class ClienteService {
	
	public static final ClienteDTO[] DEFAULT_CLIENTE = new ClienteDTO [] {
			new ClienteDTO(1l, "Ponchielli Ind.","110.220.330-40","Rua Emilio Marquardt","305","Ribeirão Souto","Pomerode","SC","igor.felipe@ponchielli.com","+55 47 3387-7000","+55 47 99276-6776","Ativo"),
			new ClienteDTO(2l, "Cartens, Ximira e Peixola", "22.512.532/0001-40","Rua Marques De Olinda","80","Botafogo","Rio de Janeiro","RJ","carstens@gmail.com","+55 21 3449-9604","","Ativo")
		};
	
	private final ClienteController clienteController;

	ClienteService(final ClienteController clienteController){
		this.clienteController = clienteController;
		Arrays.asList(ClienteService.DEFAULT_CLIENTE).forEach(dto -> this.clienteController.insertCliente(dto));
	}

	@GetMapping("/list")
	public List<ClienteDTO> List() {
		return this.clienteController.getAllClientes();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ClienteDTO> getUsuario(@PathVariable(value = "id") @Valid Long id) {
		final ClienteDTO clienteDTO = this.clienteController.getCliente(id);
		if (clienteDTO.equals(ClienteDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteDTO> removeUsuario(@PathVariable final Long id) {
		final ClienteDTO removedCliente = this.clienteController.removeCliente(id);
		if (removedCliente.equals(ClienteDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedCliente, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> updateCliente(@PathVariable final Long id,
			@RequestBody final ClienteDTO clienteDTO) {
		final ClienteDTO oldCliente = this.clienteController.updateCliente(id, clienteDTO);
		if (oldCliente.equals(ClienteDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(oldCliente, HttpStatus.OK);
	}

	@PostMapping
	public Long insertUsuario(@RequestBody final ClienteDTO clienteDTO) {
		return this.clienteController.insertCliente(clienteDTO);
	}

}
