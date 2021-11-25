package com.github.bruno.ecadtestapi.repository;

import com.github.bruno.ecadtestapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
