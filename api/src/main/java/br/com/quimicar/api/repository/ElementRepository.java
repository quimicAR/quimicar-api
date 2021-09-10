package br.com.quimicar.api.repository;

import br.com.quimicar.api.entity.ElementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<ElementEntity, String> {
    ElementEntity findByNumber(Number number);
}