package com.livraria.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idvenda;
	private int idlivro;
	private int qtd;
	private double subtotal;
	
//	@ManyToOne
//	@JoinColumn(name = "idcliente")
//	private Cliente cliente;

	public Venda() {
	
	}

	public Venda(Long idvenda, int idlivro, int qtd, double subtotal, Cliente cliente) {
		this.idvenda = idvenda;
		this.idlivro = idlivro;
		this.qtd = qtd;
		this.subtotal = subtotal;
	}
	
	
	public Venda(Long idvenda, int idlivro, int qtd, double subtotal) {
		super();
		this.idvenda = idvenda;
		this.idlivro = idlivro;
		this.qtd = qtd;
		this.subtotal = subtotal;
	}

	public Long getIdvenda() {
		return idvenda;
	}

	public void setIdvenda(Long idvenda) {
		this.idvenda = idvenda;
	}

	public int getIdlivro() {
		return idlivro;
	}

	public void setIdlivro(int idlivro) {
		this.idlivro = idlivro;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idvenda == null) ? 0 : idvenda.hashCode());
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
		Venda other = (Venda) obj;
		if (idvenda == null) {
			if (other.idvenda != null)
				return false;
		} else if (!idvenda.equals(other.idvenda))
			return false;
		return true;
	}
}
