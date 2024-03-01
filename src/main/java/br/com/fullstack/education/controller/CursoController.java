package br.com.fullstack.education.controller;

import br.com.fullstack.education.model.Curso;
import br.com.fullstack.education.model.Professor;
import br.com.fullstack.education.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    /** Buscar todos */
    @GetMapping
    public List<Curso> get() {
        return cursoService.buscarTodos();
    }

    /** Busca por ID */
    @GetMapping("{id}")
    public Curso getId(@PathVariable Integer id) throws Exception {
        return cursoService.buscarPorId(id);
    }

    /** Criação */
    @PostMapping
    public Curso post(@RequestBody Curso curso) throws Exception {
        return cursoService.salvar(curso);
    }

    /** Edição */
    @PutMapping("{id}")
    public Curso put(@PathVariable Integer id, @RequestBody Curso curso) throws Exception {
        return cursoService.salvar(id, curso);
    }

    /** Exclusão */
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id) throws Exception {
        return cursoService.excluir(id);
    }

    /** Adicionar professor a um curso */
    @PostMapping("{id}/add-professor")
    public Curso postProfessor(@PathVariable Integer id, @RequestBody Professor professor) throws Exception {
        return cursoService.adicionarProfessor(id, professor.getId());
    }

    /** Adicionar professor a um curso com PATH VARIABLE / PATH PARAM */
    @PostMapping("{id}/add-professor/{professorId}")
    public Curso postProfessorPorId(@PathVariable Integer id, @PathVariable Integer professorId) throws Exception {
        return cursoService.adicionarProfessor(id, professorId);
    }

}
