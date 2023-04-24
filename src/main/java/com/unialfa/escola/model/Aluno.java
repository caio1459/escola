package com.unialfa.escola.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Aluno {
    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    private String endereco;
    private LocalDateTime dataCadastro;
}
