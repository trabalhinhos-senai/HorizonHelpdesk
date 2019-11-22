package helpdesk.helpdesk.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

import helpdesk.helpdesk.Config.ConfigController;
import helpdesk.helpdesk.Config.ConfigDTO;
import helpdesk.helpdesk.Config.ConfigEntity;
import helpdesk.helpdesk.Config.ConfigRepository;

@Controller
public class ConfigController {
	
	private final ConfigRepository configRepository;
	
	ConfigController(final ConfigRepository configRepository) {
	    this.configRepository = configRepository;
	}
	
	private static ConfigEntity toEntity(final ConfigDTO configDTO) {
		final Long id = configDTO.getId();
		final String nomeEmpresa = configDTO.getNomeEmpresa();
		final String telefoneEmpresa = configDTO.getTelefoneEmpresa();
		final String emailEmpresa = configDTO.getEmailEmpresa();
		final String enderecoCompletoEmpresa = configDTO.getEnderecoCompletoEmpresa();

		return new ConfigEntity(id, nomeEmpresa, telefoneEmpresa, emailEmpresa,enderecoCompletoEmpresa);
		
	} 
	
	private static ConfigDTO toDTO(final ConfigEntity configEntity) {
		final Long id = configEntity.getId();
		final String nomeEmpresa = configEntity.getNomeEmpresa();
		final String telefoneEmpresa = configEntity.getTelefoneEmpresa();
		final String emailEmpresa = configEntity.getEmailEmpresa();
		final String enderecoCompretoEmpresa = configEntity.getEnderecoCompletoEmpresa();
	
		return new ConfigDTO(id, nomeEmpresa, telefoneEmpresa, emailEmpresa,enderecoCompretoEmpresa);
	}
	
	private static void updateEntityFromDTO(final ConfigDTO configDTO, final ConfigEntity configEntity) {
		configEntity.setId(configDTO.getId());
		configEntity.setNomeEmpresa(configDTO.getNomeEmpresa());
		configEntity.setTelefoneEmpresa(configDTO.getTelefoneEmpresa());
		configEntity.setEmailEmpresa(configDTO.getEmailEmpresa());
		configEntity.setEnderecoCompletoEmpresa(configDTO.getEnderecoCompletoEmpresa());
		
		
	}
	
	List<ConfigDTO> getAllConfigs(){
		final List<ConfigDTO> Configs = new ArrayList<>();
		this.configRepository.findAll().forEach(configEntity -> Configs.add(ConfigController.toDTO(configEntity)));
		return Configs;
	}
	
	ConfigDTO getConfig(final Long id) {
		final Optional<ConfigEntity> optionalConfig = this.configRepository.findById(id);
		if(optionalConfig.isPresent()) {
			return ConfigController.toDTO(optionalConfig.get());
		}
		return ConfigDTO.NULL_VALUE;
	}
	
	ConfigDTO removeConfig(final Long id) {
		final Optional<ConfigEntity> optionalConfig= this.configRepository.findById(id);
		if(optionalConfig.isPresent()) {
			final ConfigEntity configEntity = optionalConfig.get();
			this.configRepository.delete(configEntity);
			return ConfigController.toDTO(configEntity);
		}
		return ConfigDTO.NULL_VALUE;
	}
	
	Long insertConfig(final ConfigDTO configDTO) {
		final ConfigEntity configEntity = ConfigController.toEntity(configDTO);
		this.configRepository.save(configEntity);
		return configEntity.getId();
	}
	
	ConfigDTO updateConfig(final Long id, final ConfigDTO configDTO) {
		final Optional<ConfigEntity> optionalConfig = this.configRepository.findById(id);
		if(optionalConfig.isPresent()) {
			final ConfigEntity configEntity = optionalConfig.get();
			final ConfigDTO oldConfig = ConfigController.toDTO(configEntity);
			ConfigController.updateEntityFromDTO(configDTO, configEntity);
			this.configRepository.save(configEntity);
			return oldConfig;
		}
		return ConfigDTO.NULL_VALUE;
	}
	
	public boolean isExistsConfigByIdentifier(final Long id) {
		return this.configRepository.existsById(id);
	}
	

}
