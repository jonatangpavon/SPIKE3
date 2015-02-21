package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SiniestroController {

	@Autowired
	private SiniestroService siniestroService;

	@RequestMapping("/index")
	public String greeting(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "index";
	}

	@RequestMapping(value = "/siniestro", method = RequestMethod.GET)
	public String getSiniestroList(ModelMap model) {
		model.addAttribute("siniestroList", siniestroService.listSiniestro());
		return "siniestro";
	}

	@RequestMapping(value = "/siniestro/save", method = RequestMethod.POST)
	public View createSiniestro(@ModelAttribute Siniestro sini, ModelMap model) {
		if (StringUtils.hasText(sini.getId())) {
			siniestroService.updateSiniestro(sini);
		} else {
			siniestroService.addSiniestro(sini);
		}
		return new RedirectView("/SPIKE3/siniestro");
	}

	@RequestMapping(value = "/siniestro/delete", method = RequestMethod.GET)
	public View deletePerson(@ModelAttribute Siniestro sini, ModelMap model) {
		siniestroService.deleteSiniestro(sini);
		return new RedirectView("/SPIKE3/siniestro");
	}

}
