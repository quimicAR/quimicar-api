package br.com.quimicar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.quimicar.api.entity.ElementEntity;

public interface ElementRepository extends JpaRepository<ElementEntity, Number> {
    ElementEntity findByNumber(Number number);
}
