package helpdesk.helpdesk;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import helpdesk.helpdesk.Chamado.ChamadoEntity;
import helpdesk.helpdesk.Cliente.ClienteEntity;

@SpringBootApplication
public class HelpdeskApplication {
	
	public static void main(String[] args) {
				
		SpringApplication.run(HelpdeskApplication.class, args);	
		
	}

}
