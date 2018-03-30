package br.com.construcoes.tucano.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoBo {
	
	@Autowired
	private ProdutoDao dao;
	
	public List<Produto> listarMateriais(){
		return dao.listarMateriais();
	}
}
