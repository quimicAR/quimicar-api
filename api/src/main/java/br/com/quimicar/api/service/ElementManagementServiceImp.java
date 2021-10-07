package br.com.quimicar.api.service;

import br.com.quimicar.api.entity.ElementEntity;
import br.com.quimicar.api.repository.ElementManagementRepository;
import org.springframework.stereotype.Service;

@Service
public class ElementManagementServiceImp implements ElementManagementService {

    private final ElementManagementRepository elementManagementRepository;

    public ElementManagementServiceImp(ElementManagementRepository elementManagementRepository) {
        this.elementManagementRepository = elementManagementRepository;
    }

    @Override
    public void deleteByNumber(Integer number) {
        elementManagementRepository.deleteByNumber(number);
    }

    @Override
    public ElementEntity updateElement(Integer number, ElementEntity element) {
        System.out.println(element);
        return element;
    }

    @Override
    public ElementEntity save(ElementEntity element) {
        return elementManagementRepository.save(element);
    }
}
