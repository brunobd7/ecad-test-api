package com.github.bruno.ecadtestapi.resources;

import com.github.bruno.ecadtestapi.model.ArquivoBancario;
import com.github.bruno.ecadtestapi.model.Banco;
import com.github.bruno.ecadtestapi.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/bancos")
public class BancoResource {

    @Autowired
    BancoRepository repository;

    @GetMapping
    public ResponseEntity findAll(){

        List<Banco> listaBancos = repository.findAll();

        if(Objects.nonNull(listaBancos) && !listaBancos.isEmpty()){
            return ResponseEntity.ok(listaBancos);
        }else {
            return  ResponseEntity.noContent().build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Banco> findById(@PathVariable Long id){

        Banco bancoSalvo = repository.findById(id).orElse(null);

        return Objects.isNull(bancoSalvo) ? ResponseEntity.noContent().build() : ResponseEntity.ok(bancoSalvo);
    }
}
