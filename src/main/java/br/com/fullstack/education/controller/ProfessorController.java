package br.com.fullstack.education.controller;

import br.com.fullstack.education.model.Professor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("professores")
public class ProfessorController {

    /** Buscar todos */
    @GetMapping
    public List<Professor> get() {
        return Professor.getProfessoresCadastrados();
    }

    /** Busca por ID */
    @GetMapping("{id}")
    public Professor getId(@PathVariable Integer id) throws Exception {
        return Professor.buscarPorId(id);
    }

    /** Criação */
    @PostMapping
    public Professor post(@RequestBody Professor professor) throws Exception {
        return Professor.salvar(professor);
    }

    /** Edição */
    @PutMapping("{id}")
    public Professor put(@PathVariable Integer id, @RequestBody Professor professor) throws Exception {
        return Professor.salvar(id, professor);
    }

    /** Exclusão */
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id) throws Exception {
        return Professor.excluir(id);
    }

}
