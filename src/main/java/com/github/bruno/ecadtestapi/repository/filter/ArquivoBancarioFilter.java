package com.github.bruno.ecadtestapi.repository.filter;

import com.github.bruno.ecadtestapi.enums.TipoArquivo;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ArquivoBancarioFilter {

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataInicial;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataFinal;

    private TipoArquivo tipoArquivo;

    private String nomeArquivo;

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public TipoArquivo getTipoArquivo() {
        return tipoArquivo;
    }

    public void setTipoArquivo(TipoArquivo tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
}
