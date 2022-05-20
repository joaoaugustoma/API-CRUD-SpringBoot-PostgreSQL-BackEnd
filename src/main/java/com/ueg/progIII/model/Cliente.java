package com.ueg.progIII.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public @Data class Cliente {

    @Id
    private String cpf;

    @Column(name = "primeronome", nullable = false,	length = 200)
    private String primeiroNome;

    @Column(name = "sobreNome", nullable = false,	length = 200)
    private String sobreNome;

    @Column(name = "dataNascimento", nullable = false)
    private Date dataNascimento;

    @Column(name = "telefone", nullable = false, length = 13)
    private String telefone;

    @Column(name = "endereco", nullable = false , length = 500)
    private String endereco;

}
