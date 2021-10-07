package br.com.quimicar.api.service;

import br.com.quimicar.api.entity.ElementEntity;

public interface ElementManagementService {

    void deleteByNumber(Integer number);

    ElementEntity updateElement(Integer number, ElementEntity element);

    ElementEntity save(ElementEntity element);
}
