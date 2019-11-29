package helpdesk.helpdesk._Chamado;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

import helpdesk.helpdesk.Cliente.ClienteDTO;
import helpdesk.helpdesk.Cliente.ClienteEntity;
import helpdesk.helpdesk.Config.ConfigDTO;
import helpdesk.helpdesk.Config.ConfigEntity;
import helpdesk.helpdesk.GrupoAcesso.GrupoAcessoDTO;
import helpdesk.helpdesk.GrupoAcesso.GrupoAcessoEntity;
import helpdesk.helpdesk.TipoAtividade.TipoAtividadeDTO;
import helpdesk.helpdesk.TipoAtividade.TipoAtividadeEntity;
import helpdesk.helpdesk.Usuario.UsuarioDTO;
import helpdesk.helpdesk.Usuario.UsuarioEntity;

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
		final Date dataAbertura = chamadoDTO.getDataAbertura();
		final Date dataAlvo = chamadoDTO.getDataAlvo();
		final String prioridadeChamado = chamadoDTO.getPrioridadeChamado();

		final Long clienteId = chamadoDTO.getCliente().getId();
		final String clienteCPFOuCNPJ = chamadoDTO.getCliente().getCpfOuCnpj();
		final String clienteNome = chamadoDTO.getCliente().getNomeCliente();
		final String email = chamadoDTO.getCliente().getNomeCliente();
		final String telefone = chamadoDTO.getCliente().getNomeCliente();
		final String celular = chamadoDTO.getCliente().getCelular();
		final String endereco = chamadoDTO.getCliente().getEndereco();
		final String numero = chamadoDTO.getCliente().getNumero();
		final String bairro = chamadoDTO.getCliente().getBairro();
		final String cidade = chamadoDTO.getCliente().getCidade();
		final String estado = chamadoDTO.getCliente().getEstado();
		final String statusCliente = chamadoDTO.getCliente().getEstado();

		final Long usuarioId = chamadoDTO.getResponsavel().getId();
		final String nomeUsuario = chamadoDTO.getResponsavel().getNomeUsuario();
		final String loginUsuario = chamadoDTO.getResponsavel().getLoginUsuario();
		final String senhaUsuario = chamadoDTO.getResponsavel().getSenhaUsuario();
		final Long grupoId = chamadoDTO.getResponsavel().getGrupoAcesso().getId();
		final String nomeGrupo = chamadoDTO.getResponsavel().getGrupoAcesso().getNomeGrupo();

		final Long tipoId = chamadoDTO.getTipoAtividade().getId();
		final String descricaoAtiv = chamadoDTO.getTipoAtividade().getDescricao();

		return new ChamadoEntity(id, solicitante, titulo, descricao, status, dataAbertura, dataAlvo, prioridadeChamado,
				new ClienteEntity(clienteId, clienteNome, clienteCPFOuCNPJ, email, telefone, celular, endereco, numero,
						bairro, cidade, estado, statusCliente),
				new TipoAtividadeEntity(tipoId, descricaoAtiv), new UsuarioEntity(usuarioId, nomeUsuario, loginUsuario,
						senhaUsuario, new GrupoAcessoEntity(grupoId, nomeGrupo)));
	}

	private static ChamadoDTO toDTO(final ChamadoEntity chamadoEntity) {
		final Long id = chamadoEntity.getId();
		final String solicitante = chamadoEntity.getSolicitante();
		final String titulo = chamadoEntity.getTitulo();
		final String descricao = chamadoEntity.getDescricao();
		final String status = chamadoEntity.getStatus();
		final Date dataAbertura = chamadoEntity.getDataAbertura();
		final Date dataAlvo = chamadoEntity.getDataAlvo();
		final String prioridadeChamado = chamadoEntity.getPrioridadeChamado();

		final Long clienteId = chamadoEntity.getCliente().getId();
		final String clienteCPFOuCNPJ = chamadoEntity.getCliente().getCpfOuCnpj();
		final String clienteNome = chamadoEntity.getCliente().getNomeCliente();
		final String email = chamadoEntity.getCliente().getNomeCliente();
		final String telefone = chamadoEntity.getCliente().getNomeCliente();
		final String celular = chamadoEntity.getCliente().getCelular();
		final String endereco = chamadoEntity.getCliente().getEndereco();
		final String numero = chamadoEntity.getCliente().getNumero();
		final String bairro = chamadoEntity.getCliente().getBairro();
		final String cidade = chamadoEntity.getCliente().getCidade();
		final String estado = chamadoEntity.getCliente().getEstado();
		final String statusCliente = chamadoEntity.getCliente().getStatus();

		final Long usuarioId = chamadoEntity.getResponsavel().getId();
		final String nomeUsuario = chamadoEntity.getResponsavel().getNomeUsuario();
		final String loginUsuario = chamadoEntity.getResponsavel().getLoginUsuario();
		final String senhaUsuario = chamadoEntity.getResponsavel().getSenhaUsuario();
		final Long grupoId = chamadoEntity.getResponsavel().getGrupoAcesso().getId();
		final String nomeGrupo = chamadoEntity.getResponsavel().getGrupoAcesso().getNomeGrupo();

		final Long tipoId = chamadoEntity.getTipoAtividade().getId();
		final String descricaoAtiv = chamadoEntity.getTipoAtividade().getDescricao();

		return new ChamadoDTO(id, solicitante, titulo, descricao, status, dataAbertura, dataAlvo, prioridadeChamado,
			   new ClienteDTO(clienteId, clienteNome, clienteCPFOuCNPJ, email, telefone, celular, endereco, numero,
							  bairro, cidade, estado, statusCliente),
			   new TipoAtividadeDTO(tipoId, descricaoAtiv), new UsuarioDTO(usuarioId, nomeUsuario, loginUsuario,
							        senhaUsuario, new GrupoAcessoDTO(grupoId, nomeGrupo)));
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

		chamadoEntity.setCliente(new ClienteEntity(chamadoDTO.getCliente().getId(),
												   chamadoDTO.getCliente().getNomeCliente(), 
												   chamadoDTO.getCliente().getCpfOuCnpj(),
												   chamadoDTO.getCliente().getEndereco(), 
												   chamadoDTO.getCliente().getNumero(),
												   chamadoDTO.getCliente().getBairro(), 
												   chamadoDTO.getCliente().getCidade(),
												   chamadoDTO.getCliente().getEstado(), 
												   chamadoDTO.getCliente().getEmail(),
												   chamadoDTO.getCliente().getTelefone(), 
												   chamadoDTO.getCliente().getCelular(),
												   chamadoDTO.getCliente().getStatus()));
		
		
		chamadoEntity.setTipoAtividade(new TipoAtividadeEntity(chamadoDTO.getTipoAtividade().getId(), 
															   chamadoDTO.getTipoAtividade().getDescricao()));
		
		chamadoEntity.setResposavel(new UsuarioEntity(chamadoDTO.getResponsavel().getId(), 
													  chamadoDTO.getResponsavel().getNomeUsuario(),
													  chamadoDTO.getResponsavel().getLoginUsuario(),
													  chamadoDTO.getResponsavel().getSenhaUsuario(),
													  new GrupoAcessoEntity(chamadoDTO.getResponsavel().getGrupoAcesso().getId(), 
															  			    chamadoDTO.getResponsavel().getGrupoAcesso().getNomeGrupo())));

	}

	List<ChamadoDTO> getAllChamados() {
		final List<ChamadoDTO> chamados = new ArrayList<>();
		this.ChamadoRepository.findAll().forEach(chamadoEntity -> chamados.add(ChamadoController.toDTO(chamadoEntity)));
		return chamados;
	}

	ChamadoDTO getChamado(final Long id) {
		final Optional<ChamadoEntity> optionalChamado = this.ChamadoRepository.findById(id);
		if (optionalChamado.isPresent()) {
			return ChamadoController.toDTO(optionalChamado.get());
		}
		return ChamadoDTO.NULL_VALUE;
	}

	ChamadoDTO removeChamado(final Long id) {
		final Optional<ChamadoEntity> optionalChamado = this.ChamadoRepository.findById(id);
		if (optionalChamado.isPresent()) {
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
		if (optionalChamado.isPresent()) {
			final ChamadoEntity chamadoEntity = optionalChamado.get();
			final ChamadoDTO oldChamado = ChamadoController.toDTO(chamadoEntity);
			ChamadoController.updateEntityFromDTO(chamadoDTO, chamadoEntity);
			this.ChamadoRepository.save(chamadoEntity);
			return oldChamado;
		}
		return ChamadoDTO.NULL_VALUE;
	}

}
