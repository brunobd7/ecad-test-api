package com.github.bruno.ecadtestapi.repository;

import com.github.bruno.ecadtestapi.enums.TipoArquivo;
import com.github.bruno.ecadtestapi.model.ArquivoBancario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ArquivoBancarioRepository extends JpaRepository<ArquivoBancario,Long> {

    @Query(value = "select a.id, a.nome_arquivo, a.quantidade_linhas, a.data_geracao, a.data_envio, a.valor, a.tipo_arquivo, " +
            " b.nome nome_banco, u.nome nome_usuario, c.nome_beneficiario" +
            " from arquivos_bancarios a " +
            " inner join bancos b on b.id = a.id_banco inner join carteiras c on c.id = a.id_carteira inner join usuarios u on u.id = a.id_usuario " +
            " where " +
            "      a.nome_arquivo like '%?1%' AND a.tipo_arquivo= '?2' " +
            "  AND (a.data_envio BETWEEN '?3' AND '?4' OR a.data_geracao BETWEEN '?3' AND '?4')", nativeQuery = true)
    public List<ArquivoBancario> filtrarArquivos(String nomeArquivo, TipoArquivo tipoArquivo, LocalDate dataInicial, LocalDate dataFinal);
}
