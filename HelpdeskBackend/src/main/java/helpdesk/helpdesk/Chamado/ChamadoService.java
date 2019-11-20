package helpdesk.helpdesk.Chamado;

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
@RequestMapping("/api/chamado")
public class ChamadoService {

	private final ChamadoController chamadoController;
	
	ChamadoService(final ChamadoController chamadoController){
		this.chamadoController = chamadoController;
	}

	@GetMapping("/list")
	public List<ChamadoDTO> List(){
		return this.chamadoController.getAllChamados();
    }
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ChamadoDTO> getChamado(@PathVariable(value = "id") @Valid Long id) {
		final ChamadoDTO chamadoDTO = this.chamadoController.getChamado(id);
		if(chamadoDTO.equals(ChamadoDTO.NULL_VALUE)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(chamadoDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ChamadoDTO> removeChamado(@PathVariable final Long id){
		final ChamadoDTO removedChamado = this.chamadoController.removeChamado(id);
		if(removedChamado.equals(ChamadoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedChamado, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ChamadoDTO> updateChamado(@PathVariable final Long id, @RequestBody final ChamadoDTO chamadoDTO){
		final ChamadoDTO oldChamado = this.chamadoController.updateChamado(id, chamadoDTO);
		if(oldChamado.equals(ChamadoDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(oldChamado, HttpStatus.OK);
	}
	
	@PostMapping
	public Long insertChamado(@RequestBody final ChamadoDTO chamadoDTO){
		return this.chamadoController.insertChamado(chamadoDTO);
	}
	
}
