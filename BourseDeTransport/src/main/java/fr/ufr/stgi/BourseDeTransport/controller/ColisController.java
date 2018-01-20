package fr.ufr.stgi.BourseDeTransport.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.ufr.stgi.BourseDeTransport.converter.ColisToColisFormConverter;
import fr.ufr.stgi.BourseDeTransport.domain.Colis;
import fr.ufr.stgi.BourseDeTransport.form.ColisForm;
import fr.ufr.stgi.BourseDeTransport.service.ColisService;

@Controller
public class ColisController {

	private ColisService colisService;
	
	private ColisToColisFormConverter colisToColisFormConverter;
	
	@Autowired
    public ColisController(ColisService colisService, ColisToColisFormConverter colisToColisFormConverter) {
		this.colisService = colisService;
		this.colisToColisFormConverter = colisToColisFormConverter;
	}



	@RequestMapping(value = "/colis", method = RequestMethod.POST)
    public String saveOrUpdateColis(@Valid ColisForm colisForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "colis/colisform";
        }

        Colis savedColis = colisService.saveOrUpdateColisForm(colisForm);

        return "redirect:/colis/show/" + savedColis.getId();
    }
	
	@RequestMapping("/")
    public String redirToList(){
        return "redirect:/colis/list";
    }

    @RequestMapping({"/colis/list", "/colis"})
    public String listColis(Model model){
        model.addAttribute("colisList", colisService.listAll());
        return "colis/list";
    }

    @RequestMapping("/colis/show/{id}")
    public String getColis(@PathVariable String id, Model model){
        model.addAttribute("colis", colisService.getById(Long.valueOf(id)));
        return "colis/show";
    }

    @RequestMapping("colis/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Colis colis = colisService.getById(Long.valueOf(id));
        ColisForm colisForm = colisToColisFormConverter.convert(colis);
        model.addAttribute("colisForm", colisForm);
        return "colis/colisform";
    }

    @RequestMapping("/colis/new")
    public String newColis(Model model){
        model.addAttribute("colisForm", new ColisForm());
        return "colis/colisform";
    }


    @RequestMapping("/colis/delete/{id}")
    public String delete(@PathVariable String id){
        colisService.delete(Long.valueOf(id));
        return "redirect:/colis/list";
    }
}
