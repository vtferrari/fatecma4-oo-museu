package br.com.fatec.museu.controller;

import br.com.fatec.museu.dao.AcervoDAO;
import br.com.fatec.museu.model.Acervo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @Autowired
    private AcervoDAO dao;

    @RequestMapping("/")
    public String listarTodos(Model model) {
        model.addAttribute("obras", dao.findAll());
        return "template";
    }

    @GetMapping("/obra")
    public String paginaAcervo(Model model) {
        model.addAttribute("acervo", new Acervo());
        model.addAttribute("obras", dao.findAll());
        return "inserirObra";
    }

    @GetMapping("/obra/alterar/{id}")
    public String paginaAcervo(@PathVariable int id, Model model) {
        model.addAttribute("acervo", dao.findOne(id));
        model.addAttribute("obras", dao.findAll());
        return "inserirObra";
    }

    @PostMapping("/obra")
    public String inserirAcervo(@ModelAttribute Acervo acervo, Model model) {
        dao.save(acervo);
        model.addAttribute("acervo", new Acervo());
        model.addAttribute("obras", dao.findAll());
        return "inserirObra";
    }

    @PostMapping("/obra/deletar/{id}")
    public String deletarAcervo(@PathVariable int id, Model model) {
        dao.delete(id);
        model.addAttribute("acervo", new Acervo());
        model.addAttribute("obras", dao.findAll());
        return "redirect:/obra/";
    }
}