package br.com.fullstack.education.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Curso {

    private Integer id;
    @Setter private String nome;
    @Setter private String descricao;
    @Setter private Integer cargaHoraria;

    public void setId(Integer id) {
        this.id = id;
    }

}
