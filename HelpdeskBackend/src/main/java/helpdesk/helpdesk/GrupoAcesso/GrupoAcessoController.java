package helpdesk.helpdesk.GrupoAcesso;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

@Controller
public class GrupoAcessoController {

	private final GrupoAcessoRepository grupoAcessoRepository;
	
	GrupoAcessoController(GrupoAcessoRepository grupoAcessoRepository) {
	    this.grupoAcessoRepository = grupoAcessoRepository;
	}
	
	private static GrupoAcessoEntity toEntity(final GrupoAcessoDTO grupoAcessoDTO) {
		
		final Long id = grupoAcessoDTO.getId();
		final String nomeGrupo = grupoAcessoDTO.getNomeGrupo();
		return new GrupoAcessoEntity(id, nomeGrupo);
	}
	
	private static GrupoAcessoDTO toDTO(final GrupoAcessoEntity grupoAcessoEntity) {
		final String nomeGrupo = grupoAcessoEntity.getNomeGrupo();
		final Long id = grupoAcessoEntity.getId();
		return new GrupoAcessoDTO(id,nomeGrupo);
	}
	
	private static void updateEntityFromDTO(final GrupoAcessoDTO grupoAcessoDTO, final GrupoAcessoEntity grupoAcessoEntity) {
		grupoAcessoEntity.setNomeGrupo(grupoAcessoDTO.getNomeGrupo());
	}
	
	List<GrupoAcessoDTO> getAllGruposAcesso(){
		final List<GrupoAcessoDTO> gruposAcesso = new ArrayList<>();
		this.grupoAcessoRepository.findAll().forEach(grupoAcessoEntity -> gruposAcesso.add(GrupoAcessoController.toDTO(grupoAcessoEntity)));
		return gruposAcesso;
	}
	
	GrupoAcessoDTO getGrupoAcesso(final Long id) {
		final Optional<GrupoAcessoEntity> optionalGrupoAcesso = this.grupoAcessoRepository.findById(id);
		if(optionalGrupoAcesso.isPresent()) {
			return GrupoAcessoController.toDTO(optionalGrupoAcesso.get());
		}
		return GrupoAcessoDTO.NULL_VALUE;
	}
	
	GrupoAcessoDTO removeGrupoAcesso(final Long id) {
		final Optional<GrupoAcessoEntity> optionalGrupoAcesso = this.grupoAcessoRepository.findById(id);
		if(optionalGrupoAcesso.isPresent()) {
			final GrupoAcessoEntity grupoAcessoEntity = optionalGrupoAcesso.get();
			this.grupoAcessoRepository.delete(grupoAcessoEntity);
			return GrupoAcessoController.toDTO(grupoAcessoEntity);
		}
		return GrupoAcessoDTO.NULL_VALUE;
	}
	
	Long insertGrupoAcesso(final GrupoAcessoDTO grupoAcessoDTO) {
		final GrupoAcessoEntity grupoAcessoEntity = GrupoAcessoController.toEntity(grupoAcessoDTO);
		this.grupoAcessoRepository.save(grupoAcessoEntity);
		return grupoAcessoEntity.getId();
	}
	
	GrupoAcessoDTO updateGrupoAcesso(final Long id, final GrupoAcessoDTO grupoAcessoDTO) {
		final Optional<GrupoAcessoEntity> optionalGrupoAcesso = this.grupoAcessoRepository.findById(id);
		if(optionalGrupoAcesso.isPresent()) {
			final GrupoAcessoEntity grupoAcessoEntity = optionalGrupoAcesso.get();
			final GrupoAcessoDTO oldUsuario = GrupoAcessoController.toDTO(grupoAcessoEntity);
			GrupoAcessoController.updateEntityFromDTO(grupoAcessoDTO, grupoAcessoEntity);
			this.grupoAcessoRepository.save(grupoAcessoEntity);
			return oldUsuario;
		}
		return GrupoAcessoDTO.NULL_VALUE;
	}
	
	/*public boolean isExistsGrupoAcessoByIdentifier(final Long id) {
		return this.grupoAcessoRepository.existsById(id);
	}*/
}
