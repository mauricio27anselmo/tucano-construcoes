package br.com.construcoes.tucano.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.construcoes.tucano.utilitarios.Resposta;

@Service
public class ClienteBo {
	
	@Autowired
	private ClienteDao dao;

	public List<Cliente> listarClientes(){
		return dao.listarClientes();
	}
	
	public Resposta adicionarCliente(Cliente cliente) {
		return dao.adicionarCliente(cliente);
	}
}
