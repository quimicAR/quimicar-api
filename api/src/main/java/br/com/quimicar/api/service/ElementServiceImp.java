package br.com.quimicar.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import br.com.quimicar.api.entity.ElementEntity;
import br.com.quimicar.api.repository.ElementRepository;

@Service
public class ElementServiceImp implements ElementService {
    @Autowired
    private ElementRepository elementsRepository;

    public List<ElementEntity> listElements() {
        return elementsRepository.findAll();
    }

    public ElementEntity findByNumber(Number number) {
        return elementsRepository.findByNumber(number);
    }

    public ElementEntity save(ElementEntity element) {
        return elementsRepository.save(element);
    }

}