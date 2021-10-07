package br.com.quimicar.api.repository;

import br.com.quimicar.api.entity.ElementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ElementManagementRepository extends JpaRepository<ElementEntity, Integer>, JpaSpecificationExecutor<ElementEntity> {
    void deleteByNumber(Integer number);
}