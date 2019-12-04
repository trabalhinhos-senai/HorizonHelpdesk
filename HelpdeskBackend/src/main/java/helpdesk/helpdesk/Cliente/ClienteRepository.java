package helpdesk.helpdesk.Cliente;

import org.springframework.data.repository.CrudRepository;

interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {

	boolean existsByCpfOuCnpj(String cpfOuCnpj);
}
