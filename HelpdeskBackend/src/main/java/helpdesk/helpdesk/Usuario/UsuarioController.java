package helpdesk.helpdesk.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

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

		return new UsuarioEntity(id, nomeUsuario, loginUsuario, senhaUsuario);
	} 
	
	private static UsuarioDTO toDTO(final UsuarioEntity usuarioEntity) {
		final Long id = usuarioEntity.getId();
		final String nomeUsuario = usuarioEntity.getNomeUsuario();
		final String loginUsuario = usuarioEntity.getLoginUsuario();
		final String senhaUsuario = usuarioEntity.getSenhaUsuario();
		
		final String grupoAcessoNome = usuarioEntity.getGrupoAcesso().getNomeGrupo();
		final Long configEntityId = usuarioEntity.getConfigEntity().getId();
		
		return new UsuarioDTO(id, nomeUsuario, loginUsuario, senhaUsuario, grupoAcessoNome, configEntityId);
	}
	
	private static void updateEntityFromDTO(final UsuarioDTO usuarioDTO, final UsuarioEntity usuarioEntity) {
		usuarioEntity.setId(usuarioDTO.getId());
		usuarioEntity.setNomeUsuario(usuarioDTO.getNomeUsuario());
		usuarioEntity.setLoginUsuario(usuarioDTO.getLoginUsuario());
		usuarioEntity.setSenhaUsuario(usuarioDTO.getSenhaUsuario());
		
		
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
	
	public boolean isExistsUsuarioByIdentifier(final Long id) {
		return this.usuarioRepository.existsById(id);
	}
	
}
