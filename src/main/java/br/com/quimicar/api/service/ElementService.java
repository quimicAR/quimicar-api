package br.com.quimicar.api.service;

import java.util.List;
import br.com.quimicar.api.entity.ElementEntity;

public interface ElementService {
    List<ElementEntity> findAll();

    ElementEntity findByNumber(Integer number);

    void deleteByNumber(Integer number);

    ElementEntity updateElement(Integer number, ElementEntity element);

    ElementEntity save(ElementEntity element);
}
