package br.com.quimicar.api.service;

import java.util.List;
import br.com.quimicar.api.entity.Element;

public interface ElementService {
    List<Element> findAll();

    List<String> findAllCategories();

    Element findByNumber(Integer number);

    void deleteByNumber(Integer number);

    Element updateElement(Integer number, Element element);

    Element save(Element element);
}
