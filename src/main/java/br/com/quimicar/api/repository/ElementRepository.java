package br.com.quimicar.api.repository;

import br.com.quimicar.api.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

public interface ElementRepository extends JpaRepository<Element, UUID> {
    @NonNull
    Element findByNumber(Integer number);
    @NonNull
    void deleteByNumber(Integer number);

    List<Element> findByOrderByNumberAsc();


}