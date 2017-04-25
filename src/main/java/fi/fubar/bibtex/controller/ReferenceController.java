package fi.fubar.bibtex.controller;

import fi.fubar.bibtex.domain.Reference;
import fi.fubar.bibtex.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReferenceController {

    @Autowired
    private ReferenceService referenceService;

    @RequestMapping(value = "/references", method = RequestMethod.GET)
    public String list(Model model, @RequestParam(value = "search", required = false, defaultValue = "") String search) {
        if (search.isEmpty()) {
            model.addAttribute("references", referenceService.findAll());
        } else {
            System.out.println("SEARCHING: " + search);
            model.addAttribute("search", search);
            model.addAttribute("references", referenceService.search(search));
        }
        return "index";
    }

    @RequestMapping(value = "/references/{type}/edit/{id}", method = RequestMethod.GET)
    public String list(Model model, @PathVariable String type, @PathVariable Long id) {
        Reference ref = referenceService.findByTypeAndId(type, id);
        if (ref != null) {
            model.addAttribute("reference", ref);
            return "edit-" + type;
        } else {
            return "redirect:/";
        }

    }

    @RequestMapping(value = "/references/add", method = RequestMethod.GET)
    public String add(Model model) {
        return "add-reference";
    }

}
