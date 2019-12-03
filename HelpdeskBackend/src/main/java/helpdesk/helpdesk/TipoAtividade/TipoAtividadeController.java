package helpdesk.helpdesk.TipoAtividade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

@Controller
public class TipoAtividadeController {

	private final TipoAtividadeRepository tipoAtividadeRepository;

	TipoAtividadeController(final TipoAtividadeRepository tipoAtividadeRepository) {
		this.tipoAtividadeRepository = tipoAtividadeRepository;
	}

	private static TipoAtividadeEntity toEntity(final TipoAtividadeDTO tipoAtividadeDTO) {
		final Long id = tipoAtividadeDTO.getId();
		final String descricao = tipoAtividadeDTO.getDescricao();
		return new TipoAtividadeEntity(id, descricao);
	}

	private static TipoAtividadeDTO toDTO(final TipoAtividadeEntity tipoAtividadeEntity) {
		final long id = tipoAtividadeEntity.getId();
		final String descricao = tipoAtividadeEntity.getDescricao();
		return new TipoAtividadeDTO(id, descricao);
	}

	private static void updateEntityFromDTO(final TipoAtividadeDTO tipoAtividadeDTO,
			final TipoAtividadeEntity tipoAtividadeEntity) {
		tipoAtividadeEntity.setDescricao(tipoAtividadeDTO.getDescricao());
	}

	List<TipoAtividadeDTO> getAllTipoAtividade() {
		final List<TipoAtividadeDTO> atividades = new ArrayList<>();
		this.tipoAtividadeRepository.findAll()
				.forEach(tipoAtividadeEntity -> atividades.add(TipoAtividadeController.toDTO(tipoAtividadeEntity)));
		return atividades;
	}

	TipoAtividadeDTO getTipoAtividade(final Long id) {
		final Optional<TipoAtividadeEntity> optionalTipoAtividade = this.tipoAtividadeRepository.findById(id);
		if (optionalTipoAtividade.isPresent()) {
			return TipoAtividadeController.toDTO(optionalTipoAtividade.get());
		}
		return TipoAtividadeDTO.NULL_VALUE;
	}

	TipoAtividadeDTO removeTipoAtividade(final Long id) {
		final Optional<TipoAtividadeEntity> optionalTipoAtividade = this.tipoAtividadeRepository.findById(id);
		if (optionalTipoAtividade.isPresent()) {
			final TipoAtividadeEntity tipoAtividadeEntity = optionalTipoAtividade.get();
			this.tipoAtividadeRepository.delete(tipoAtividadeEntity);
			return TipoAtividadeController.toDTO(tipoAtividadeEntity);
		}
		return TipoAtividadeDTO.NULL_VALUE;
	}

	Long insertTipoAtividade(final TipoAtividadeDTO tipoAtividadeDTO) {

		if (this.tipoAtividadeRepository.existsByDescricao(tipoAtividadeDTO.getDescricao())) {

			return null;
		}

		final TipoAtividadeEntity tipoAtividadeEntity = TipoAtividadeController.toEntity(tipoAtividadeDTO);
		this.tipoAtividadeRepository.save(tipoAtividadeEntity);
		return tipoAtividadeEntity.getId();
	}

	TipoAtividadeDTO updateTipoAtividade(final Long id, final TipoAtividadeDTO tipoAtividadeDTO) {
		final Optional<TipoAtividadeEntity> optionalTipoAtividade = this.tipoAtividadeRepository.findById(id);
		if (optionalTipoAtividade.isPresent()) {
			final TipoAtividadeEntity tipoAtividadeEntity = optionalTipoAtividade.get();
			final TipoAtividadeDTO oldTipoAtividade = TipoAtividadeController.toDTO(tipoAtividadeEntity);
			TipoAtividadeController.updateEntityFromDTO(tipoAtividadeDTO, tipoAtividadeEntity);
			this.tipoAtividadeRepository.save(tipoAtividadeEntity);
			return oldTipoAtividade;
		}
		return TipoAtividadeDTO.NULL_VALUE;
	}

}
