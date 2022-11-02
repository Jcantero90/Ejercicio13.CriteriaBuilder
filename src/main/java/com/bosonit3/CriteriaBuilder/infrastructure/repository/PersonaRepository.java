package com.bosonit3.CriteriaBuilder.infrastructure.repository;

import com.bosonit3.CriteriaBuilder.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository <Persona, Integer> {
}
