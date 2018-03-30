package br.com.construcoes.tucano.produto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDao {
	
	private List<Produto> materiais;
	
	public ProdutoDao() {
		Produto material1 = new Produto(123456L, "Cadeado Grande", Tipo.Ferro, "PAPAIZ", 
				new BigDecimal(5.60).setScale(2, RoundingMode.HALF_EVEN));
		Produto material2 = new Produto(123485L, "Caibro Angelim Vermelho", Tipo.Madeira, "MADEREIRA TOBIAS", 
				new BigDecimal(5.60).setScale(2, RoundingMode.HALF_EVEN));
		Produto material3 = new Produto(582456L, "Tinta Suvinil Branco Acrílico Fosco", Tipo.Tinta, "SUVINIL", 
				new BigDecimal(65.80).setScale(2, RoundingMode.HALF_EVEN));
		Produto material4 = new Produto(125566L, "Argamassa Especial Grandes Formatos", Tipo.Revestimentos, "CIMENTOS NASSAU", 
				new BigDecimal(40.55).setScale(2, RoundingMode.HALF_EVEN));
		Produto material5 = new Produto(156246L, "Porcelanato Polido", Tipo.Revestimentos, "CIMENTOS NASSAU", 
				new BigDecimal(2.60).setScale(2, RoundingMode.HALF_EVEN));
		Produto material6 = new Produto(123456L, "Caibro Angelim Vermelho", Tipo.Madeira, "MADEREIRA TOBIAS", 
				new BigDecimal(3.50).setScale(2, RoundingMode.HALF_EVEN));
		Produto material7 = new Produto(123456L, "Cadeado Grande", Tipo.Ferro, "PAPAIZ", 
				new BigDecimal(5.60).setScale(2, RoundingMode.HALF_EVEN));
		materiais = new ArrayList<Produto>();
		materiais.add(material1);
		materiais.add(material2);
		materiais.add(material3);
		materiais.add(material4);
		materiais.add(material5);
		materiais.add(material6);
		materiais.add(material7);
	}
	
	public List<Produto> listarMateriais() {
		return materiais;
	}

}
