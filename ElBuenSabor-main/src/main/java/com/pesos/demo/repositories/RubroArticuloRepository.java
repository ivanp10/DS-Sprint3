package com.pesos.demo.repositories;

import com.pesos.demo.entities.RubroArticulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroArticuloRepository extends JpaRepository <RubroArticulo, Long> {
}
