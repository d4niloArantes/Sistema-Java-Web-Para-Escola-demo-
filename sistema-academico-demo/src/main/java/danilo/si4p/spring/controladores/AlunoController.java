package danilo.si4p.spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import danilo.si4p.spring.entidades.Aluno;
import danilo.si4p.spring.repositorios.AlunoRepositorio;

@Controller
public class AlunoController 
{
	@Autowired
	private AlunoRepositorio alunoRepositorio;
	
	@RequestMapping(value = "/aluno")
	public String listaEditaAlunos(Aluno aluno, Model model) 
	{
		if(aluno.getId() != null)
		{
			model.addAttribute("aluno", alunoRepositorio.findOne(aluno.getId()));
		}else
			model.addAttribute("aluno", new Aluno());
		
		model.addAttribute("alunos", alunoRepositorio.findAll());
		return "Alunos";
	}
	
	@RequestMapping(value = "/aluno/save")
	public String salvar(Aluno aluno) 
	{
		alunoRepositorio.save(aluno);
		return "redirect:/aluno";
	}
	
	@RequestMapping(value = "/aluno/del")
	public String deletar(Aluno aluno) 
	{
		alunoRepositorio.delete(aluno);
		return "redirect:/aluno";
	}
}