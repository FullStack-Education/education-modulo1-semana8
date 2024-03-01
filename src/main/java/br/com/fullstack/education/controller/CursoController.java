package br.com.fullstack.education.controller;

import br.com.fullstack.education.model.Curso;
import br.com.fullstack.education.model.Professor;
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
    public boolean delete(@PathVariable Integer id) throws Exception {
        return Curso.excluir(id);
    }

    /** Adicionar professor a um curso */
    @PostMapping("{id}/add-professor")
    public Curso postProfessor(@PathVariable Integer id, @RequestBody Professor professor) throws Exception {
        return Curso.adicionarProfessor(id, professor.getId());
    }

    /** Adicionar professor a um curso com PATH VARIABLE / PATH PARAM */
    @PostMapping("{id}/add-professor/{professorId}")
    public Curso postProfessorPorId(@PathVariable Integer id, @PathVariable Integer professorId) throws Exception {
        return Curso.adicionarProfessor(id, professorId);
    }

}
