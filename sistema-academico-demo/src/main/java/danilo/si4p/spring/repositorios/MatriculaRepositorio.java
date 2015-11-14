package danilo.si4p.spring.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import danilo.si4p.spring.entidades.Matricula;

public interface MatriculaRepositorio extends CrudRepository<Matricula, Long> 
{	
	@Query("from Matricula order by aluno.nome")
	public List<Matricula> findAllOrderByNomeAluno();
	
	@Query("from Matricula order by disciplina.nome")
	public List<Matricula> findAllOrderByNomeDisciplina();
}
