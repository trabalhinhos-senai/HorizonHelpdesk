package helpdesk.helpdesk.Usuario;


import org.springframework.data.repository.CrudRepository;

interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {
	
	boolean existsByLoginUsuario(String login);
}
