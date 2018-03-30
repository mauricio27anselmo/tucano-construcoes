package br.com.construcoes.tucano.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.construcoes.tucano.cliente.Cliente;
import br.com.construcoes.tucano.cliente.ClienteBo;
import br.com.construcoes.tucano.utilitarios.Resposta;

@RestController(value = "/cliente")
public class ClienteRestDto {
	
	@Autowired
	private ClienteBo bo;
	
	@RequestMapping(method = RequestMethod.GET, value = "/cliente", produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Cliente> listarClientes() {
		return bo.listarClientes();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/cliente", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Resposta adicionarCliente(@RequestBody Cliente cliente) {
		return bo.adicionarCliente(cliente);
	}

}
