package br.com.quimicar.api.service;

import org.springframework.stereotype.Service;

import java.util.List;

import br.com.quimicar.api.entity.ElementEntity;
import br.com.quimicar.api.repository.ElementRepository;

@Service
public class ElementServiceImp implements ElementService {

    private final ElementRepository elementsRepository;

    public ElementServiceImp(ElementRepository elementsRepository) {
        this.elementsRepository = elementsRepository;
    }

    @Override
    public List<ElementEntity> findAll() {
        return elementsRepository.findAll();
    }

    @Override
    public ElementEntity findByNumber(Integer number) {
        return elementsRepository.findByNumber(number);
    }

}