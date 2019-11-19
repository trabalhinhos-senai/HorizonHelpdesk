package helpdesk.helpdesk.Config;

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
@RequestMapping("/config")
public class ConfigService {
	
private final ConfigController configController;
	
	ConfigService(final ConfigController configController){
		this.configController = configController;
	}

	@GetMapping("/list")
	public List<ConfigDTO> List(){
		return this.configController.getAllConfigs();
    }
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ConfigDTO> getConfig(@PathVariable(value = "id") @Valid Long id) {
		final ConfigDTO configDTO = this.configController.getConfig(id);
		if(configDTO.equals(ConfigDTO.NULL_VALUE)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(configDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ConfigDTO> removeConfig(@PathVariable final Long id){
		final ConfigDTO removedConfig = this.configController.removeConfig(id);
		if(removedConfig.equals(ConfigDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedConfig, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ConfigDTO> updateConfig(@PathVariable final Long id, @RequestBody final ConfigDTO configDTO){
		final ConfigDTO oldConfig = this.configController.updateConfig(id, configDTO);
		if(oldConfig.equals(ConfigDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(oldConfig, HttpStatus.OK);
	}
	
	@PostMapping
	public Long insertConfig(@RequestBody final ConfigDTO configDTO){
		return this.configController.insertConfig(configDTO);
	}

}
