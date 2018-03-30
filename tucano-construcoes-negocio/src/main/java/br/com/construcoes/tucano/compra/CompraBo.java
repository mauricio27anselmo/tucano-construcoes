package br.com.construcoes.tucano.compra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.construcoes.tucano.utilitarios.Resposta;

@Service
public class CompraBo {
	
	@Autowired
	private CompraDao dao;
	
	public List<Compra> listarCompras(){
		return dao.listarCompras();
	}
	
	public Resposta adicionarCompra(Compra compra) {
		return dao.adicionarCompra(compra);
	}
}
