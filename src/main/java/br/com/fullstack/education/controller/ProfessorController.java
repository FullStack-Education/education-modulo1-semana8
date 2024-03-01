package br.com.fullstack.education.controller;

import br.com.fullstack.education.model.Professor;
import br.com.fullstack.education.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    /** Buscar todos */
    @GetMapping
    public List<Professor> get() {
        return professorService.buscarTodos();
    }

    /** Busca por ID */
    @GetMapping("{id}")
    public Professor getId(@PathVariable Integer id) throws Exception {
        return professorService.buscarPorId(id);
    }

    /** Criação */
    @PostMapping
    public Professor post(@RequestBody Professor professor) throws Exception {
        return professorService.salvar(professor);
    }

    /** Edição */
    @PutMapping("{id}")
    public Professor put(@PathVariable Integer id, @RequestBody Professor professor) throws Exception {
        return professorService.salvar(id, professor);
    }

    /** Exclusão */
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id) throws Exception {
        return professorService.excluir(id);
    }

}
