package br.com.construcoes.tucano.compra;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import br.com.construcoes.tucano.cliente.Cliente;
import br.com.construcoes.tucano.produto.Produto;

public class Compra implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private BigDecimal valorTotal;
	private Cliente cliente;
	private List<Produto> listaProdutos;
	
	public Compra() {
	}

	public Compra(Long codigo, BigDecimal valorTotal, Cliente cliente, List<Produto> listaProdutos) {
		super();
		this.codigo = codigo;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.listaProdutos = listaProdutos;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((listaProdutos == null) ? 0 : listaProdutos.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (listaProdutos == null) {
			if (other.listaProdutos != null)
				return false;
		} else if (!listaProdutos.equals(other.listaProdutos))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Compra [codigo=" + codigo + ", valorTotal=" + valorTotal + ", cliente=" + cliente + ", listaProdutos="
				+ listaProdutos + "]";
	}
	
	

}
