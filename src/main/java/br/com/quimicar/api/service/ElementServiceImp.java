package br.com.quimicar.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import br.com.quimicar.api.entity.Element;
import br.com.quimicar.api.repository.ElementRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ElementServiceImp implements ElementService {

    private final ElementRepository elementsRepository;

    @Override
    @PreAuthorize("permitAll()")
    public List<Element> findAll() {
        try {
            return elementsRepository.findByOrderByNumberAsc();
        }
        catch (Exception error) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Elements Not Found", error);
        }
    }

    @Override
    @PreAuthorize("permitAll()")
    public List<String> findAllCategories() {
        try {
            return Arrays.asList("Noble Gases", "Alkali Metals", "Alkaline Earth Metals",
                    "Post Transition Metals", "Transition Metals", "Lanthanoids", "Actinoids", "Non Metal");
        }
        catch (Exception error) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Categories Not Found", error);
        }
    }


    @Override
    @PreAuthorize("permitAll()")
    public Element findByNumber(Integer number) {
        try {
            return elementsRepository.findByNumber(number);
        }
        catch (Exception error) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Element Not Found", error);
        }
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
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
    @PreAuthorize("hasRole('ADMIN')")
    public Element updateElement(Integer number, Element element) {
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
    @PreAuthorize("hasRole('ADMIN')")
    public Element save(Element element) {
        try {
            return elementsRepository.save(element);
        }
        catch (Exception error) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Could not create element", error);
        }
    }

}