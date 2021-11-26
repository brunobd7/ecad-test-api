package com.github.bruno.ecadtestapi.repository.arquivosbancarios;

import com.github.bruno.ecadtestapi.model.ArquivoBancario;
import com.github.bruno.ecadtestapi.repository.filter.ArquivoBancarioFilter;

import java.util.List;

public interface ArquivoBancarioRepositoryQuery{

    public List<ArquivoBancario> filtrarArquivos(ArquivoBancarioFilter arquivoBancarioFilter);
}
