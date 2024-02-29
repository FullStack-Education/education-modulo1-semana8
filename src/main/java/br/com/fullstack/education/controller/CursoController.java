package br.com.fullstack.education.controller;

import br.com.fullstack.education.model.Curso;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {

    /** Buscar todos */
    @GetMapping
    public List<Curso> get() {
        return Curso.getCursosCadastrados();
    }

    /** Busca por ID */
    @GetMapping("{id}")
    public Curso getId(@PathVariable Integer id) throws Exception {
        return Curso.buscarPorId(id);
    }

    /** Criação */
    @PostMapping
    public Curso post(@RequestBody Curso curso) throws Exception {
        return Curso.salvar(curso);
    }

    /** Edição */
    @PutMapping("{id}")
    public Curso put(@PathVariable Integer id, @RequestBody Curso curso) throws Exception {
        return Curso.salvar(id, curso);
    }

    /** Exclusão */
    @DeleteMapping("{id}")
    public String delete(@PathVariable Integer id) {
        return "DELETE /cursos/" + id;
    }

}
