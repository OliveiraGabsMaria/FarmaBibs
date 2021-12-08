package br.com.farmabibs.FarmaBibs.Model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoriafarm")
public class CategoriaFarm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O atributo descrição não pode ficar vazio")
	private String descricao;
	
	@NotBlank(message = "O atributo industria farmaceutica não pode fcar vazio")
	private String industria;
	
	@NotNull(message = "O atributo lote não pode ficar vazio")
	@Size(max = 6, message = "O lote deve ter seis caracteres no máximo")
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datacompra = new java.sql.Date(System.currentTimeMillis());

	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Medicamentos> medicamentos;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getIndustria() {
		return industria;
	}


	public void setIndustria(String industria) {
		this.industria = industria;
	}


	public Date getDatacompra() {
		return datacompra;
	}


	public void setDatacompra(Date datacompra) {
		this.datacompra = datacompra;
	}


	public List<Medicamentos> getMedicamentos() {
		return medicamentos;
	}


	public void setMedicamentos(List<Medicamentos> medicamentos) {
		this.medicamentos = medicamentos;
	}
	
	
}
