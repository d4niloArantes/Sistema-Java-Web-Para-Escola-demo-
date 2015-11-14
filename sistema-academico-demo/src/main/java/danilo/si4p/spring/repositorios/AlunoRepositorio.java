package danilo.si4p.spring.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import danilo.si4p.spring.entidades.Aluno;

public interface AlunoRepositorio extends CrudRepository<Aluno, Long>
{
	@Query("from Aluno order by nome")
	public List<Aluno> findAllOrderByNome();
}
