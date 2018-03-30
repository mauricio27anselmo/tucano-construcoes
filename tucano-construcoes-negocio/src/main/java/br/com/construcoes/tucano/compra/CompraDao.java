package br.com.construcoes.tucano.compra;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.construcoes.tucano.utilitarios.Resposta;

@Repository
public class CompraDao {
	private List<Compra> compras;
	
	public CompraDao() {
		compras = new ArrayList<Compra>();
	}
		
	public List<Compra> listarCompras(){
		return compras;
	}
	
	public Resposta adicionarCompra(Compra compra) {
		try {
			compras.add(compra);
			return new Resposta(true, "Compra realizada com sucesso");
		}catch(Exception ex) {
			return new Resposta(false, "Falha ao realizar compra");
		}
	}
}
