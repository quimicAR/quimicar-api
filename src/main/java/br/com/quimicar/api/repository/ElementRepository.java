package br.com.quimicar.api.repository;

import br.com.quimicar.api.entity.ElementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.UUID;

public interface ElementRepository extends JpaRepository<ElementEntity, UUID> {
    @NonNull
    ElementEntity findByNumber(Integer number);
    @NonNull
    void deleteByNumber(Integer number);

}