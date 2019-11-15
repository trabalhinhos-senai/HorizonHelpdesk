package helpdesk.helpdesk.ClienteEndereco;

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
@RequestMapping("/clienteEndereco")
public class ClienteEnderecoService {
	
private final ClienteEnderecoController  clienteEnderecoController ;
	
	ClienteEnderecoService(final ClienteEnderecoController  clienteEnderecoController ){
		this.clienteEnderecoController  = clienteEnderecoController ;
	}

	@GetMapping("/list")
	public List<ClienteEnderecoDTO> List(){
		return this.clienteEnderecoController .getAllClienteEnderecos();
    }
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ClienteEnderecoDTO> getClienteEndereco(@PathVariable(value = "id") @Valid Long id) {
		final ClienteEnderecoDTO clienteEnderecoDTO = this.clienteEnderecoController .getClienteEndereco(id);
		if(clienteEnderecoDTO.equals(ClienteEnderecoDTO.NULL_VALUE)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(clienteEnderecoDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteEnderecoDTO> removeClienteEndereco(@PathVariable final Long id){
		final ClienteEnderecoDTO removedClienteEndereco = this.clienteEnderecoController .removeClienteEndereco(id);
		if(removedClienteEndereco.equals(ClienteEnderecoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedClienteEndereco, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteEnderecoDTO> updateClienteEndereco(@PathVariable final Long id, @RequestBody final ClienteEnderecoDTO clienteEnderecoDTO){
		final ClienteEnderecoDTO oldClienteEndereco = this.clienteEnderecoController .updateClienteEndereco(id, clienteEnderecoDTO);
		if(oldClienteEndereco.equals(ClienteEnderecoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(oldClienteEndereco, HttpStatus.OK);
	}
	
	@PostMapping
	public Long insertClienteEndereco(@RequestBody final ClienteEnderecoDTO clienteEnderecoDTO){
		return this.clienteEnderecoController .insertClienteEndereco(clienteEnderecoDTO);
	}

}
