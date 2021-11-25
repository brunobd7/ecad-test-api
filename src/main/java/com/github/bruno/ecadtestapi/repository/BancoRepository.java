package com.github.bruno.ecadtestapi.repository;

import com.github.bruno.ecadtestapi.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<Banco,Long>{
}
