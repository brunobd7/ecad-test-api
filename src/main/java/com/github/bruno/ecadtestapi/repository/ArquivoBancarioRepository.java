package com.github.bruno.ecadtestapi.repository;

import com.github.bruno.ecadtestapi.enums.TipoArquivo;
import com.github.bruno.ecadtestapi.model.ArquivoBancario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ArquivoBancarioRepository extends JpaRepository<ArquivoBancario,Long> {

    //TODO IMPLEMENTAR QUERY NATIVA
//    @Query(value = "", nativeQuery = true)
//    public List<ArquivoBancario> filtrarArquivos(LocalDate dataInicial, LocalDate dataFinal, TipoArquivo tipoArquivo);
}
