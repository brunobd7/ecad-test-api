package com.github.bruno.ecadtestapi.repository;

import com.github.bruno.ecadtestapi.model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira,Long> {
}
