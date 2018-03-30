package br.com.construcoes.tucano.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.construcoes.tucano.produto.Produto;
import br.com.construcoes.tucano.produto.ProdutoBo;

@RestController(value = "/produto")
public class ProdutoRestDto {
	
	@Autowired
	private ProdutoBo bo;
	
	@RequestMapping(method = RequestMethod.GET, value = "/produto", produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Produto> listarClientes() {
		return bo.listarMateriais();
	}
	
}
