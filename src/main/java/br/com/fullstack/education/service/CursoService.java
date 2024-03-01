package br.com.fullstack.education.service;

import br.com.fullstack.education.model.Curso;
import br.com.fullstack.education.model.Professor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final ProfessorService professorService;

    public CursoService(ProfessorService professorService) {
        this.professorService = professorService;
    }

    public Curso salvar(Curso curso) throws Exception {
        if (validar(curso)) {
            return Curso.inserir(curso);
        }
        return null;
    }

    public Curso salvar(Integer id, Curso curso) throws Exception {
        if (validar(curso)) {
            Curso cadastrado = buscarPorId(id);
            cadastrado.setNome(curso.getNome());
            cadastrado.setDescricao(curso.getDescricao());
            cadastrado.setCargaHoraria(curso.getCargaHoraria());
            return cadastrado;
        }
        return null;
    }

    public List<Curso> buscarTodos() {
        return Curso.getCursosCadastrados();
    }

    public Curso buscarPorId(Integer id) throws Exception {
        return Curso.buscarPorId(id);
    }

    private boolean validar(Curso curso) throws Exception {
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new Exception("Nome é obrigatório");
        }

        if (curso.getCargaHoraria() == null || curso.getCargaHoraria() < 100) {
            throw new Exception("Carga horária não informada ou menor que 100");
        }

        return true;
    }

    public boolean excluir(Integer id) throws Exception {
        Curso curso = buscarPorId(id);
        return Curso.excluir(curso);
    }

    public Curso adicionarProfessor(Integer id, Integer professorId) throws Exception {
        Curso curso = buscarPorId(id);
        Professor professor = professorService.buscarPorId(professorId);
        Curso.adicionarProfessor(curso, professor);
        return curso;
    }

}
