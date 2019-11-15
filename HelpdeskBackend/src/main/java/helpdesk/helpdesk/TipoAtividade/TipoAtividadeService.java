package helpdesk.helpdesk.TipoAtividade;

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
@RequestMapping("/tipoatividade")
public class TipoAtividadeService {

		private final TipoAtividadeController tipoAtividadeController;
		
		TipoAtividadeService(final TipoAtividadeController tipoAtividadeController){
			this.tipoAtividadeController = tipoAtividadeController;
		}

		@GetMapping("/list")
		public List<TipoAtividadeDTO> List(){
			return this.tipoAtividadeController.getAllTipoAtividade();
	    }
		
		@GetMapping("/get/{id}")
		public ResponseEntity<TipoAtividadeDTO> getUsuario(@PathVariable(value = "id") @Valid Long id) {
			final TipoAtividadeDTO tipoAtividadeDTO = this.tipoAtividadeController.getTipoAtividade(id);
			if(tipoAtividadeDTO.equals(TipoAtividadeDTO.NULL_VALUE)){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(tipoAtividadeDTO, HttpStatus.OK);
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<TipoAtividadeDTO> removeUsuario(@PathVariable final Long id){
			final TipoAtividadeDTO removedUsuario = this.tipoAtividadeController.removeTipoAtividade(id);
			if(removedUsuario.equals(TipoAtividadeDTO.NULL_VALUE)) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(removedUsuario, HttpStatus.OK);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<TipoAtividadeDTO> updateTipoAtividade(@PathVariable final Long id, @RequestBody final TipoAtividadeDTO tipoAtividadeDTO){
			final TipoAtividadeDTO oldTipoAtividade = this.tipoAtividadeController.updateTipoAtividade(id, tipoAtividadeDTO);
			if(oldTipoAtividade.equals(TipoAtividadeDTO.NULL_VALUE)) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(oldTipoAtividade, HttpStatus.OK);
		}
		
		@PostMapping
		public Long insertUsuario(@RequestBody final TipoAtividadeDTO tipoAtividadeDTO){
			return this.tipoAtividadeController.insertTipoAtividade(tipoAtividadeDTO);
		}
	
}
