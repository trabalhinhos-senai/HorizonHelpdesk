package helpdesk.helpdesk.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

import helpdesk.helpdesk.Config.ConfigDTO;
import helpdesk.helpdesk.Config.ConfigEntity;
import helpdesk.helpdesk.GrupoAcesso.GrupoAcessoDTO;
import helpdesk.helpdesk.GrupoAcesso.GrupoAcessoEntity;

@Controller
public class UsuarioController {
	
	private final UsuarioRepository usuarioRepository;
	
	UsuarioController(final UsuarioRepository usuarioRepository) {
	    this.usuarioRepository = usuarioRepository;
	}
	
	private static UsuarioEntity toEntity(final UsuarioDTO usuarioDTO) {
		final Long id = usuarioDTO.getId();
		final String nomeUsuario = usuarioDTO.getNomeUsuario();
		final String loginUsuario = usuarioDTO.getLoginUsuario();
		final String senhaUsuario = usuarioDTO.getSenhaUsuario();

		final Long grupoId = usuarioDTO.getGrupoAcesso().getId();
		final String nomeGrupo = usuarioDTO.getGrupoAcesso().getNomeGrupo();
		
		/*final Long configId = usuarioDTO.getConfig().getId();
		final String configEmpresa = usuarioDTO.getConfig().getNomeEmpresa();
		final String configEndereco = usuarioDTO.getConfig().getEnderecoCompletoEmpresa();
		final String configEmail = usuarioDTO.getConfig().getEmailEmpresa();
		final String configTelefone = usuarioDTO.getConfig().getTelefoneEmpresa();*/
		
		return new UsuarioEntity(id, nomeUsuario, loginUsuario, senhaUsuario, new GrupoAcessoEntity(grupoId, nomeGrupo)/*, 
				new ConfigEntity(configId, configEmpresa, configTelefone, configEmail, configEndereco)*/);
	} 
	
	private static UsuarioDTO toDTO(final UsuarioEntity usuarioEntity) {
		final Long id = usuarioEntity.getId();
		final String nomeUsuario = usuarioEntity.getNomeUsuario();
		final String loginUsuario = usuarioEntity.getLoginUsuario();
		final String senhaUsuario = usuarioEntity.getSenhaUsuario();
		
		final Long grupoId = usuarioEntity.getGrupoAcesso().getId();
		final String nomeGrupo = usuarioEntity.getGrupoAcesso().getNomeGrupo();
		
		/*final Long configId = usuarioEntity.getConfig().getId();
		final String configEmpresa = usuarioEntity.getConfig().getNomeEmpresa();
		final String configEndereco = usuarioEntity.getConfig().getEnderecoCompletoEmpresa();
		final String configEmail = usuarioEntity.getConfig().getEmailEmpresa();
		final String configTelefone = usuarioEntity.getConfig().getTelefoneEmpresa();*/
		
		return new UsuarioDTO(id, nomeUsuario, loginUsuario, senhaUsuario, new GrupoAcessoDTO(grupoId, nomeGrupo)/*, new ConfigDTO(configId, configEmpresa, configTelefone, configEmail, configEndereco)*/);
	}
	
	private static void updateEntityFromDTO(final UsuarioDTO usuarioDTO, final UsuarioEntity usuarioEntity) {
		//usuarioEntity.setId(usuarioDTO.getId());
		usuarioEntity.setNomeUsuario(usuarioDTO.getNomeUsuario());
		usuarioEntity.setLoginUsuario(usuarioDTO.getLoginUsuario());
		usuarioEntity.setSenhaUsuario(usuarioDTO.getSenhaUsuario());
		
		usuarioEntity.setGrupoAcesso(new GrupoAcessoEntity(usuarioDTO.getGrupoAcesso().getId(), usuarioDTO.getGrupoAcesso().getNomeGrupo()));
		
		/*usuarioEntity.setConfig(new ConfigEntity(usuarioDTO.getConfig().getId(), usuarioDTO.getConfig().getNomeEmpresa(), usuarioDTO.getConfig().getTelefoneEmpresa(), 
									usuarioEntity.getConfig().getEmailEmpresa(), usuarioEntity.getConfig().getEnderecoCompletoEmpresa()));*/
		
	}
	
	List<UsuarioDTO> getAllUsuarios(){
		final List<UsuarioDTO> usuarios = new ArrayList<>();
		this.usuarioRepository.findAll().forEach(usuarioEntity -> usuarios.add(UsuarioController.toDTO(usuarioEntity)));
		return usuarios;
	}
	
	UsuarioDTO getUsuario(final Long id) {
		final Optional<UsuarioEntity> optionalUsuario = this.usuarioRepository.findById(id);
		if(optionalUsuario.isPresent()) {
			return UsuarioController.toDTO(optionalUsuario.get());
		}
		return UsuarioDTO.NULL_VALUE;
	}
	
	UsuarioDTO removeUsuario(final Long id) {
		final Optional<UsuarioEntity> optionalUsuario = this.usuarioRepository.findById(id);
		if(optionalUsuario.isPresent()) {
			final UsuarioEntity usuarioEntity = optionalUsuario.get();
			this.usuarioRepository.delete(usuarioEntity);
			return UsuarioController.toDTO(usuarioEntity);
		}
		return UsuarioDTO.NULL_VALUE;
	}
	
	Long insertUsuario(final UsuarioDTO usuarioDTO) {
		final UsuarioEntity usuarioEntity = UsuarioController.toEntity(usuarioDTO);
		this.usuarioRepository.save(usuarioEntity);
		return usuarioEntity.getId();
	}
	
	UsuarioDTO updateUsuario(final Long id, final UsuarioDTO usuarioDTO) {
		final Optional<UsuarioEntity> optionalUsuario = this.usuarioRepository.findById(id);
		if(optionalUsuario.isPresent()) {
			final UsuarioEntity usuarioEntity = optionalUsuario.get();
			final UsuarioDTO oldUsuario = UsuarioController.toDTO(usuarioEntity);
			UsuarioController.updateEntityFromDTO(usuarioDTO, usuarioEntity);
			this.usuarioRepository.save(usuarioEntity);
			return oldUsuario;
		}
		return UsuarioDTO.NULL_VALUE;
	}
	
}
