package br.com.quimicar.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quimicar.api.entity.ElementEntity;
@Repository
public interface ElementRepository extends JpaRepository<ElementEntity, Number> {
    
}
