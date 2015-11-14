package danilo.si4p.spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import danilo.si4p.spring.entidades.Matricula;
import danilo.si4p.spring.repositorios.AlunoRepositorio;
import danilo.si4p.spring.repositorios.DisciplinaRepositorio;
import danilo.si4p.spring.repositorios.MatriculaRepositorio;

@Controller
public class MatriculaController 
{
	@Autowired
	private MatriculaRepositorio matriculaRepositorio;
	@Autowired
	private AlunoRepositorio alunoRepositorio;
	@Autowired
	private DisciplinaRepositorio disciplinaRepositorio;
	
	@RequestMapping(value = "/matricula")
	public String listaEditaMatriculas(Matricula matricula, Model model)
	{
		if(matricula.getId() != null)
		{
			model.addAttribute("matricula", matriculaRepositorio.findOne(matricula.getId()));
		}else
			model.addAttribute("matricula", new Matricula());
		
		model.addAttribute("matriculas", matriculaRepositorio.findAll());
		model.addAttribute("alunos", alunoRepositorio.findAllOrderByNome());
		model.addAttribute("disciplinas", disciplinaRepositorio.findAllOrderByNome());
		return "Matriculas";
	}
	
	@RequestMapping(value = "/matricula/save")
	public String salvar(Matricula matricula) 
	{
		matriculaRepositorio.save(matricula);
		return "redirect:/matricula";
	}
	
	@RequestMapping(value = "/matricula/del")
	public String deletar(Matricula matricula) 
	{
		matriculaRepositorio.delete(matricula);
		return "redirect:/matricula";
	}
}
