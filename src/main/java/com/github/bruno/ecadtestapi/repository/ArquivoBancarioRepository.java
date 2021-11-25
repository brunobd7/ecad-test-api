package com.github.bruno.ecadtestapi.repository;

import com.github.bruno.ecadtestapi.model.ArquivoBancario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArquivoBancarioRepository extends JpaRepository<ArquivoBancario,Long> {
}
