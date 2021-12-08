package br.com.farmabibs.FarmaBibs.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_medicamentos")
public class Medicamentos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O atributo nome não pode estar vazio")
	private String nome;
	
	@NotNull(message = "O atributo numero de registro não pode estar vazio")
	@Size(max = 7, message = "O atributo deve ter no máximo 7 caracteres")
	private int registro;
	
	@NotNull(message = "O atributo preço não pode estar vazio")
	private int preco;
	
	@ManyToOne
	@JsonIgnoreProperties("medicamentos")
	private CategoriaFarm categoria;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public CategoriaFarm getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaFarm categoria) {
		this.categoria = categoria;
	}


}
