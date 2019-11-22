package helpdesk.helpdesk.Usuario;

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

import helpdesk.helpdesk.Config.ConfigService;
import helpdesk.helpdesk.GrupoAcesso.GrupoAcessoService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioService {
	
	public static final UsuarioDTO[] DEFAULT_USUARIO = new UsuarioDTO [] {
			new UsuarioDTO(1l, "system admin", "admin", "admin123", GrupoAcessoService.DEFAULT_GRUPO[0], ConfigService.DEFAULT_CONFIG[0]),
			new UsuarioDTO(2l, "simple user", "user", "Password123", GrupoAcessoService.DEFAULT_GRUPO[1], ConfigService.DEFAULT_CONFIG[0])
		};
		
		private final UsuarioController usuarioController;
		
		UsuarioService(final UsuarioController usuarioController){
			this.usuarioController = usuarioController;
			Arrays.asList(UsuarioService.DEFAULT_USUARIO).forEach(dto -> this.usuarioController.insertUsuario(dto));
		}

	@GetMapping("/list")
	public List<UsuarioDTO> List(){
		return this.usuarioController.getAllUsuarios();
    }
	
	@GetMapping("/get/{id}")
	public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable(value = "id") @Valid Long id) {
		final UsuarioDTO usuarioDTO = this.usuarioController.getUsuario(id);
		if(usuarioDTO.equals(UsuarioDTO.NULL_VALUE)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UsuarioDTO> removeUsuario(@PathVariable final Long id){
		final UsuarioDTO removedUsuario = this.usuarioController.removeUsuario(id);
		if(removedUsuario.equals(UsuarioDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedUsuario, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable final Long id, @RequestBody final UsuarioDTO usuarioDTO){
		final UsuarioDTO oldUsuario = this.usuarioController.updateUsuario(id, usuarioDTO);
		if(oldUsuario.equals(UsuarioDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(oldUsuario, HttpStatus.OK);
	}
	
	@PostMapping
	public Long insertUsuario(@RequestBody final UsuarioDTO usuarioDTO){
		return this.usuarioController.insertUsuario(usuarioDTO);
	}
	
}
