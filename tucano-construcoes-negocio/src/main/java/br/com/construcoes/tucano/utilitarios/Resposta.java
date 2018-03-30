package br.com.construcoes.tucano.utilitarios;

import java.io.Serializable;

public class Resposta implements Serializable{
	private static final long serialVersionUID = 8578578910073787662L;
	
	private boolean bemSucedido;
	private String mensagem;
	
	public Resposta() {
	}

	public Resposta(boolean bemSucedido, String mensagem) {
		super();
		this.bemSucedido = bemSucedido;
		this.mensagem = mensagem;
	}

	public boolean isBemSucedido() {
		return bemSucedido;
	}

	public void setBemSucedido(boolean bemSucedido) {
		this.bemSucedido = bemSucedido;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bemSucedido ? 1231 : 1237);
		result = prime * result + ((mensagem == null) ? 0 : mensagem.hashCode());
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
		Resposta other = (Resposta) obj;
		if (bemSucedido != other.bemSucedido)
			return false;
		if (mensagem == null) {
			if (other.mensagem != null)
				return false;
		} else if (!mensagem.equals(other.mensagem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Resposta [bemSucedido=" + bemSucedido + ", mensagem=" + mensagem + "]";
	}
	
	
	
}
