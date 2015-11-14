package danilo.si4p.spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import danilo.si4p.spring.entidades.Avaliacao;
import danilo.si4p.spring.repositorios.AvaliacaoRepositorio;

@Controller
public class AvaliacaoController 
{
	@Autowired
	private AvaliacaoRepositorio avaliacaoRepositorio;
	
	@RequestMapping(value = "/avaliacao")
	public String listaEditaAvaliacoes(Avaliacao avaliacao, Model model)
	{
		if(avaliacao.getId() != null)
		{
			model.addAttribute("avaliacao", avaliacaoRepositorio.findOne(avaliacao.getId()));
		}else
			model.addAttribute("avaliacao", new Avaliacao());
		
		model.addAttribute("avaliacoes", avaliacaoRepositorio.findAll());
		return "Avaliacoes";
	}
	
	@RequestMapping(value = "/avaliacao/save")
	public String salvar(Avaliacao avaliacao) 
	{
		avaliacaoRepositorio.save(avaliacao);
		return "redirect:/avaliacao";
	}
	
	@RequestMapping(value = "/avaliacao/del")
	public String deletar(Avaliacao avaliacao) 
	{
		avaliacaoRepositorio.delete(avaliacao);
		return "redirect:/avaliacao";
	}
}