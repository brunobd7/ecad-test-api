package com.github.bruno.ecadtestapi.resources;

import com.github.bruno.ecadtestapi.model.ArquivoBancario;
import com.github.bruno.ecadtestapi.repository.ArquivoBancarioRepository;
import com.github.bruno.ecadtestapi.repository.filter.ArquivoBancarioFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/arquivos-bancarios")
public class ArquivoBancarioResource {

    @Autowired
    ArquivoBancarioRepository repository;

//    @GetMapping
//    public ResponseEntity findAll(){
//
//        List<ArquivoBancario> listaArquivos = repository.findAll();
//
//        if(Objects.nonNull(listaArquivos) && !listaArquivos.isEmpty()){
//            return ResponseEntity.ok(listaArquivos);
//        }else {
//            return  ResponseEntity.noContent().build();
//        }
//
//    }

    @GetMapping
    public ResponseEntity filtrar(ArquivoBancarioFilter arquivoBancarioFilter){
        List<ArquivoBancario> listaArquivos = listaArquivos = repository
                .filtrarArquivos(arquivoBancarioFilter.getNomeArquivo(), arquivoBancarioFilter.getTipoArquivo(), arquivoBancarioFilter.getDataInicial(),arquivoBancarioFilter.getDataFinal());

        if (Objects.nonNull(listaArquivos) && !listaArquivos.isEmpty()) {
            return ResponseEntity.ok(listaArquivos);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArquivoBancario> findById(@PathVariable Long id){

        ArquivoBancario arquivoSalvo = repository.findById(id).orElse(null);

        return Objects.isNull(arquivoSalvo) ? ResponseEntity.noContent().build() : ResponseEntity.ok(arquivoSalvo);
    }
}
