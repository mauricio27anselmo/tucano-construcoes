package br.com.construcoes.tucano.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.construcoes.tucano.compra.Compra;
import br.com.construcoes.tucano.compra.CompraBo;
import br.com.construcoes.tucano.utilitarios.Resposta;

@RestController(value = "/compra")
public class CompraRestDto {

	@Autowired
	private CompraBo bo;
	
	@RequestMapping (method= RequestMethod.GET, value="/compra", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Compra> listarCompras(){
		return bo.listarCompras();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/compra", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Resposta adicionarProdutoCompra(@RequestBody Compra registro) {
		return bo.adicionarCompra(registro);
	}
}
