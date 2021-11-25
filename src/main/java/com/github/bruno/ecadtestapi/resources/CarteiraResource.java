package com.github.bruno.ecadtestapi.resources;

import com.github.bruno.ecadtestapi.model.Carteira;
import com.github.bruno.ecadtestapi.model.Usuario;
import com.github.bruno.ecadtestapi.repository.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/carteiras")
public class CarteiraResource {

    @Autowired
    CarteiraRepository carteiraRepository;

    @GetMapping
    public ResponseEntity findAll(){

        List<Carteira> carteiras = carteiraRepository.findAll();

        if(Objects.nonNull(carteiras) && !carteiras.isEmpty()){
            return ResponseEntity.ok(carteiras);
        }else {
            return  ResponseEntity.noContent().build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Carteira> findById(@PathVariable Long id){

        Carteira carteiraSalva = carteiraRepository.findById(id).orElse(null);

        return Objects.isNull(carteiraSalva) ? ResponseEntity.noContent().build() : ResponseEntity.ok(carteiraSalva);
    }
}
