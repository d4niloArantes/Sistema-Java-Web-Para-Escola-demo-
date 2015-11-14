package danilo.si4p.spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import danilo.si4p.spring.entidades.Disciplina;
import danilo.si4p.spring.repositorios.DisciplinaRepositorio;

@Controller
public class DisciplinaController 
{
	@Autowired
	private DisciplinaRepositorio diciplinaRepositorio;
	
	@RequestMapping(value = "/disciplina")
	public String listaEditaAlunos(Disciplina disci, Model model) 
	{
		if(disci.getId() != null)
		{
			model.addAttribute("disciplina", diciplinaRepositorio.findOne(disci.getId()));
		}else
			model.addAttribute("disciplina", new Disciplina());
		
		model.addAttribute("disciplinas", diciplinaRepositorio.findAll());
		return "Disciplinas";
	}
	
	@RequestMapping(value = "/disciplina/save")
	public String salvar(Disciplina disci) 
	{
		diciplinaRepositorio.save(disci);
		return "redirect:/disciplina";
	}
	
	@RequestMapping(value = "/disciplina/del")
	public String deletar(Disciplina disci) 
	{
		diciplinaRepositorio.delete(disci);
		return "redirect:/disciplina";
	}
}
