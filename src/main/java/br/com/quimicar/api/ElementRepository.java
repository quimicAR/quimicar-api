package br.com.quimicar.api;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<ElementEntity, Number> {
    ElementEntity findByNumber(Number number);
}
