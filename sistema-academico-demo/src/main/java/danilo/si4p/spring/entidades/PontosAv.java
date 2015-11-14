package danilo.si4p.spring.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PontosAv 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPontosAv;
	private double pontos;
	@ManyToOne
	private Aluno aluno;
	@ManyToOne
	private Avaliacao avaliacao;
	
	public Long getIdPontosAv() {
		return idPontosAv;
	}
	public void setIdPontosAv(Long idPontosAv) {
		this.idPontosAv = idPontosAv;
	}
	public double getPontos() {
		return pontos;
	}
	public void setPontos(double pontos) {
		this.pontos = pontos;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
}
