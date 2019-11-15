package helpdesk.helpdesk.ClienteContato;

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

@RestController
@RequestMapping("/clienteContato")
public class ClienteContatoService {
	
private final ClienteContatoController clienteContatoController;
	
	ClienteContatoService(final ClienteContatoController clienteContatoController){
		this.clienteContatoController = clienteContatoController;
	}

	@GetMapping("/list")
	public List<ClienteContatoDTO> List(){
		return this.clienteContatoController.getAllClienteContatos();
    }
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ClienteContatoDTO> getClienteContato(@PathVariable(value = "id") @Valid Long id) {
		final ClienteContatoDTO clienteContatoDTO = this.clienteContatoController.getClienteContato(id);
		if(clienteContatoDTO.equals(ClienteContatoDTO.NULL_VALUE)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(clienteContatoDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteContatoDTO> removeUsuario(@PathVariable final Long id){
		final ClienteContatoDTO removedUsuario = this.clienteContatoController.removeClienteContato(id);
		if(removedUsuario.equals(ClienteContatoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedUsuario, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteContatoDTO> updateUsuario(@PathVariable final Long id, @RequestBody final ClienteContatoDTO clienteContatoDTO){
		final ClienteContatoDTO oldClienteContato = this.clienteContatoController.updateClienteContato(id, clienteContatoDTO);
		if(oldClienteContato.equals(ClienteContatoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(oldClienteContato, HttpStatus.OK);
	}
	
	@PostMapping
	public Long insertClienteContato(@RequestBody final ClienteContatoDTO clienteContatoDTO){
		return this.clienteContatoController.insertClienteContato(clienteContatoDTO);
	}

}
