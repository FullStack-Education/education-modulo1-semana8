package br.com.fullstack.education.service;

import br.com.fullstack.education.model.Curso;
import br.com.fullstack.education.model.Professor;
import org.springframework.stereotype.Service;

@Service
public class CursoProfessorService extends ProfessorService {

    private final CursoService cursoService;

    public CursoProfessorService(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    public boolean removerProfessor(Integer id) throws Exception {
        Professor professor = buscarPorId(id);
        for(Curso curso : cursoService.buscarTodos()) {
            curso.getProfessores().remove(professor);
        }
        return excluir(professor);
    }

}
