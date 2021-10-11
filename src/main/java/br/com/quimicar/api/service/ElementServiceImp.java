package br.com.quimicar.api.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

import br.com.quimicar.api.entity.ElementEntity;
import br.com.quimicar.api.repository.ElementRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ElementServiceImp implements ElementService {

    private final ElementRepository elementsRepository;

    public ElementServiceImp(ElementRepository elementsRepository) {
        this.elementsRepository = elementsRepository;
    }

    @Override
    @PreAuthorize("permitAll()")
    public List<ElementEntity> findAll() {
        try {
            return elementsRepository.findAll();
        }
        catch (Exception error) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Elements Not Found", error);
        }
    }

    @Override
    @PreAuthorize("permitAll()")
    public ElementEntity findByNumber(Integer number) {
        try {
            return elementsRepository.findByNumber(number);
        }
        catch (Exception error) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Element Not Found", error);
        }
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteByNumber(Integer number) {
        try {
            elementsRepository.deleteByNumber(number);
        }
        catch (Exception error) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Could not delete element", error);
        }
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ElementEntity updateElement(Integer number, ElementEntity element) {
        try {
            System.out.println(element);
            return element;
        }
        catch (Exception error) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Could not update element", error);
        }
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ElementEntity save(ElementEntity element) {
        try {
            return elementsRepository.save(element);
        }
        catch (Exception error) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Could not create element", error);
        }
    }

}