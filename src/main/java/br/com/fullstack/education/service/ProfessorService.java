package br.com.fullstack.education.service;

import br.com.fullstack.education.model.Professor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    public Professor salvar(Professor professor) throws Exception {
        if (validar(professor)) {
            return Professor.inserir(professor);
        }
        return null;
    }

    public Professor salvar(Integer id, Professor professor) throws Exception {
        if (validar(professor)) {
            Professor cadastrado = buscarPorId(id);
            cadastrado.setNome(professor.getNome());
            cadastrado.setEspecialidade(professor.getEspecialidade());
            return cadastrado;
        }
        return null;
    }

    public List<Professor> buscarTodos() {
        return Professor.getProfessoresCadastrados();
    }

    public Professor buscarPorId(Integer id) throws Exception {
        return Professor.buscarPorId(id);
    }

    private boolean validar(Professor professor) throws Exception {
        if (professor.getNome() == null || professor.getNome().isBlank()) {
            throw new Exception("Nome é obrigatório");
        }

        if (professor.getEspecialidade() == null || professor.getEspecialidade().isBlank()) {
            throw new Exception("Especialidade é obrigatório");
        }

        return true;
    }

    public boolean excluir(Integer id) throws Exception {
        Professor professor = buscarPorId(id);
        return excluir(professor);
    }

    public boolean excluir(Professor professor) {
        return Professor.excluir(professor);
    }

}
