package helpdesk.helpdesk.Chamado;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

@Controller
public class ChamadoController {
	
	private final ChamadoRepository ChamadoRepository;
	
	ChamadoController(final ChamadoRepository ChamadoRepository) {
	    this.ChamadoRepository = ChamadoRepository;
	}
	
	private static ChamadoEntity toEntity(final ChamadoDTO chamadoDTO) {
		final Long id = chamadoDTO.getId();
		final String solicitante = chamadoDTO.getSolicitante();
		final String titulo = chamadoDTO.getTitulo();
		final String descricao = chamadoDTO.getDescricao();
		final String status = chamadoDTO.getStatus();
		final String dataAbertura = chamadoDTO.getDataAbertura();
		final String dataAlvo = chamadoDTO.getDataAlvo();
		
		final String prioridadeChamado = chamadoDTO.getPrioridadeChamado();
		
		return new ChamadoEntity(id, solicitante, titulo, descricao, status, dataAbertura, dataAlvo, prioridadeChamado);
	} 
	
	private static ChamadoDTO toDTO(final ChamadoEntity chamadoEntity) {
		final Long id = chamadoEntity.getId();
		final String solicitante = chamadoEntity.getSolicitante();
		final String titulo = chamadoEntity.getTitulo();
		final String descricao = chamadoEntity.getDescricao();
		final String status = chamadoEntity.getStatus();
		final String dataAbertura = chamadoEntity.getDataAbertura();
		final String dataAlvo = chamadoEntity.getDataAlvo();
		final String prioridadeChamado = chamadoEntity.getPrioridadeChamado();
		return new ChamadoDTO(id, solicitante, titulo, descricao, status, dataAbertura, dataAlvo, prioridadeChamado);
	}
	
	private static void updateEntityFromDTO(final ChamadoDTO chamadoDTO, final ChamadoEntity chamadoEntity) {
		chamadoEntity.setId(chamadoDTO.getId());
		chamadoEntity.setSolicitante(chamadoDTO.getSolicitante());
		chamadoEntity.setTitulo(chamadoDTO.getTitulo());
		chamadoEntity.setDescricao(chamadoDTO.getDescricao());
		chamadoEntity.setStatus(chamadoDTO.getStatus());
		chamadoEntity.setDataAbertura(chamadoDTO.getDataAbertura());
		chamadoEntity.setDataAlvo(chamadoDTO.getDataAlvo());
		
		chamadoEntity.setPrioridadeChamado(chamadoDTO.getPrioridadeChamado());
			
	}
	
	List<ChamadoDTO> getAllChamados(){
		final List<ChamadoDTO> chamados = new ArrayList<>();
		this.ChamadoRepository.findAll().forEach(chamadoEntity -> chamados.add(ChamadoController.toDTO(chamadoEntity)));
		return chamados;
	}
	
	ChamadoDTO getChamado(final Long id) {
		final Optional<ChamadoEntity> optionalChamado = this.ChamadoRepository.findById(id);
		if(optionalChamado.isPresent()) {
			return ChamadoController.toDTO(optionalChamado.get());
		}
		return ChamadoDTO.NULL_VALUE;
	}
	
	ChamadoDTO removeChamado(final Long id) {
		final Optional<ChamadoEntity> optionalChamado = this.ChamadoRepository.findById(id);
		if(optionalChamado.isPresent()) {
			final ChamadoEntity chamadoEntity = optionalChamado.get();
			this.ChamadoRepository.delete(chamadoEntity);
			return ChamadoController.toDTO(chamadoEntity);
		}
		return ChamadoDTO.NULL_VALUE;
	}
	
	Long insertChamado(final ChamadoDTO ChamadoDTO) {
		final ChamadoEntity chamadoEntity = ChamadoController.toEntity(ChamadoDTO);
		this.ChamadoRepository.save(chamadoEntity);
		return chamadoEntity.getId();
	}
	
	ChamadoDTO updateChamado(final Long id, final ChamadoDTO chamadoDTO) {
		final Optional<ChamadoEntity> optionalChamado = this.ChamadoRepository.findById(id);
		if(optionalChamado.isPresent()) {
			final ChamadoEntity chamadoEntity = optionalChamado.get();
			final ChamadoDTO oldChamado = ChamadoController.toDTO(chamadoEntity);
			ChamadoController.updateEntityFromDTO(chamadoDTO, chamadoEntity);
			this.ChamadoRepository.save(chamadoEntity);
			return oldChamado;
		}
		return ChamadoDTO.NULL_VALUE;
	}	
	
}
