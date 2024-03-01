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
    @Getter private static final List<Professor> professoresCadastrados = new ArrayList<>();

    @Setter(AccessLevel.NONE) private Integer id;
    private String nome;
    private String especialidade;

    public static Professor inserir(Professor professor) {
        professor.id = proximoId++;
        professoresCadastrados.add(professor);
        return professor;
    }

    public static boolean excluir(Professor professor) {
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

}
