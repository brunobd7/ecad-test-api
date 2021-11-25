package com.github.bruno.ecadtestapi.model;

import com.github.bruno.ecadtestapi.enums.TipoArquivo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "arquivos_bancarios")
public class ArquivoBancario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_arquivo")
    private String nomeArquivo;

    @Column(name = "quantidade_linhas")
    private Integer quantidadeLinhas;

    @Column(name = "data_geracao")
    private LocalDate dataGeracao;

    @Column(name = "data_envio")
    private LocalDate dataEnvio;

    private BigDecimal valor;

    @Column(name = "tipo_arquivo")
    @Enumerated(EnumType.STRING)
    private TipoArquivo tipoArquivo;

    //RELACIONAMENTOS
    @ManyToOne
    @JoinColumn(name = "id_banco")
    private Banco banco;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuarioGerador;

    @ManyToOne
    @JoinColumn(name = "id_carteira")
    private Carteira carteira;
    //

}