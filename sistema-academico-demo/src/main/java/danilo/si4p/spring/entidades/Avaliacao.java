package danilo.si4p.spring.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avaliacao 
{
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descricao;
	private float maxPontos;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public float getMaxPontos() {
		return maxPontos;
	}
	
	public void setMaxPontos(float maxPontos) {
		this.maxPontos = maxPontos;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}