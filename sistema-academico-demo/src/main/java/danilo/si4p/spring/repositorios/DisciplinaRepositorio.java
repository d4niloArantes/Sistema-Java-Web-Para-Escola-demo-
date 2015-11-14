package danilo.si4p.spring.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import danilo.si4p.spring.entidades.Disciplina;

public interface DisciplinaRepositorio extends CrudRepository<Disciplina, Long> 
{
	@Query("from Disciplina order by nome")
	public List<Disciplina> findAllOrderByNome();
}
