package br.com.construcoes.tucano.cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.construcoes.tucano.utilitarios.Resposta;

@Repository
public class ClienteDao {

//	@Autowired
//	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	private List<Cliente> clientes;
	
	public ClienteDao() {
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
//		Cliente cliente1 = new Cliente(1L,"Mauricio", "teste@mail.com","4556789", "123.456.789-80", "(62)3506-5689", new Date(), Sexo.Masculino);
//		Cliente cliente2 = new Cliente(23L,"Marilia", "teste@mail.com","4556589", "123.456.787-85", "(62)3506-5689",  new Date(), Sexo.Feminino);
//		Cliente cliente3 = new Cliente(45L,"Mauro", "teste@mail.com","4556749", "123.456.789-98", "(62)3506-5689",  new Date(), Sexo.Masculino);
//		clientes = new ArrayList<Cliente>();
//		clientes.add(cliente1);
//		clientes.add(cliente2);
//		clientes.add(cliente3);
		
		
	}
	
//	public List<Cliente> listarClientes(){
////		return clientes;
//	}
//	
//	public Resposta adicionarCliente(Cliente cliente) {
////		try {
////			clientes.add(cliente);
////			return new Resposta(true, "Cliente cadastrado com sucesso");
////		}catch(Exception ex) {
////			return new Resposta(false, "Erro ao adicionar cliente");
////		}
//	}

}
