package com.unialfa.escola.controller;

import com.unialfa.escola.model.Aluno;
import com.unialfa.escola.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlunoController {
    //chama o service, que possui todas a regras da aplicação
    @Autowired
    private AlunoService service;
    //inicia o HTML
    @RequestMapping("/")
    public String iniciar(Model model) {
        model.addAttribute("bemVindo","Cadastro de Alunos");
        return "formulario";
    }
    //salva os dados do form
    @PostMapping("salvar")
    public String salvar(Aluno aluno){
        service.salvar(aluno);
        return "redirect:/lista";
    }
    //exibi a lista
    @GetMapping("lista")
    public String listar(Model model){
        model.addAttribute("bemVindo", "Lista de Alunos");
        model.addAttribute("alunos",service.listar());
        return "lista";
    }
    //aqui da pra arrumar
    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Integer id, Model model) {
        model.addAttribute("bemVindo", "Tela de Cadastros");
        model.addAttribute("alunos", service.buscarId(id));
        return "formulario";
    }
    //exclui pelo id
    @GetMapping("/remover/{id}")
    public String remover(Aluno aluno){
        service.remover(aluno);
        return "redirect:/lista";
    }
}
