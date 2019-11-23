package helpdesk.helpdesk.GrupoAcesso;

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

import helpdesk.helpdesk.Usuario.UsuarioDTO;
import helpdesk.helpdesk.Usuario.UsuarioService;


@RestController
@RequestMapping("api/grupoacesso")
public class GrupoAcessoService {
	private final GrupoAcessoController grupoAcessoController;
	
	public static final GrupoAcessoDTO[] DEFAULT_GRUPO = new GrupoAcessoDTO [] {
			new GrupoAcessoDTO(1l, "Admin"),
			new GrupoAcessoDTO(2l, "User")
		};
	
	GrupoAcessoService(final GrupoAcessoController grupoAcessoController){
		this.grupoAcessoController = grupoAcessoController;
		Arrays.asList(GrupoAcessoService.DEFAULT_GRUPO).forEach(dto -> this.grupoAcessoController.insertGrupoAcesso(dto));
	}

	@GetMapping("/list")
	public List<GrupoAcessoDTO> List(){
		return this.grupoAcessoController.getAllGruposAcesso();
    }
	
	@GetMapping("/get/{id}")
	public ResponseEntity<GrupoAcessoDTO> getGrupoAcesso(@PathVariable(value = "id") @Valid Long id) {
		final GrupoAcessoDTO grupoAcessoDTO = this.grupoAcessoController.getGrupoAcesso(id);
		if(grupoAcessoDTO.equals(GrupoAcessoDTO.NULL_VALUE)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(grupoAcessoDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<GrupoAcessoDTO> removeGrupoAcesso(@PathVariable final Long id){
		final GrupoAcessoDTO removed = this.grupoAcessoController.removeGrupoAcesso(id);
		if(removed.equals(GrupoAcessoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removed, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GrupoAcessoDTO> updateGrupoAcesso(@PathVariable final Long id, @RequestBody final GrupoAcessoDTO grupoAcessoDTO){
		final GrupoAcessoDTO oldGrupoAcesso = this.grupoAcessoController.updateGrupoAcesso(id, grupoAcessoDTO);
		if(oldGrupoAcesso.equals(GrupoAcessoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(oldGrupoAcesso, HttpStatus.OK);
	}
	
	@PostMapping
	public Long insertGrupoAcesso(@RequestBody final GrupoAcessoDTO grupoAcessoDTO){
		return this.grupoAcessoController.insertGrupoAcesso(grupoAcessoDTO);
	}
}
