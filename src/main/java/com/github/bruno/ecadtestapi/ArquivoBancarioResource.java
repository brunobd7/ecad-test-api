package com.github.bruno.ecadtestapi;

import com.github.bruno.ecadtestapi.model.ArquivoBancario;
import com.github.bruno.ecadtestapi.repository.ArquivoBancarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/arquivos-bancarios")
public class ArquivoBancarioResource {

    @Autowired
    ArquivoBancarioRepository repository;

    @GetMapping
    public ResponseEntity<?> listarTodos(){

        List<ArquivoBancario> listaArquivos = repository.findAll();

        if(Objects.nonNull(listaArquivos) && !listaArquivos.isEmpty()){
            return ResponseEntity.ok(listaArquivos);
        }else {
            return  ResponseEntity.noContent().build();
        }

    }
}
