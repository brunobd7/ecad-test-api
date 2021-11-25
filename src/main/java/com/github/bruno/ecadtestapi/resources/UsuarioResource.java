package com.github.bruno.ecadtestapi.resources;

import com.github.bruno.ecadtestapi.model.Banco;
import com.github.bruno.ecadtestapi.model.Usuario;
import com.github.bruno.ecadtestapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity findAll(){

        List<Usuario> listaUsuarios = usuarioRepository.findAll();

        if(Objects.nonNull(listaUsuarios) && !listaUsuarios.isEmpty()){
            return ResponseEntity.ok(listaUsuarios);
        }else {
            return  ResponseEntity.noContent().build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){

        Usuario usuarioEncontrado = usuarioRepository.findById(id).orElse(null);

        return Objects.isNull(usuarioEncontrado) ? ResponseEntity.noContent().build() : ResponseEntity.ok(usuarioEncontrado);
    }
}
