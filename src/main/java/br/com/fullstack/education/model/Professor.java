package br.com.fullstack.education.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Professor {

    private static Integer proximoId = 1;
    @Getter private static List<Professor> professoresCadastrados = new ArrayList<>();

    @Setter(AccessLevel.NONE) private Integer id;
    private String nome;
    private String especialidade;

    public static Professor salvar(Professor professor) throws Exception {
        if (validar(professor)) {
            professor.id = proximoId++;
            professoresCadastrados.add(professor);
        }
        return professor;
    }

    public static Professor salvar(Integer id, Professor professor) throws Exception {
        if (validar(professor)) {
            Professor cadastrado = buscarPorId(id);
            cadastrado.setNome(professor.getNome());
            cadastrado.setEspecialidade(professor.getEspecialidade());
            return cadastrado;
        }
        return null;
    }

    public static boolean excluir(Integer id) throws Exception {
        Professor professor = buscarPorId(id);
        professoresCadastrados.remove(professor);
        return true;
    }

    public static Professor buscarPorId(Integer id) throws Exception {
        for (Professor professor : professoresCadastrados) {
            if (professor.getId().equals(id)) {
                return professor;
            }
        }
        throw new Exception("Professor não encontrado");
    }

    private static boolean validar(Professor professor) throws Exception {
        if (professor.getNome() == null || professor.getNome().isBlank()) {
            throw new Exception("Nome é obrigatório");
        }

        if (professor.getEspecialidade() == null || professor.getEspecialidade().isBlank()) {
            throw new Exception("Especialidade é obrigatório");
        }

        return true;
    }
}
