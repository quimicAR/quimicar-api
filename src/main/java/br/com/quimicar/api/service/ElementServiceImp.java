package br.com.quimicar.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import br.com.quimicar.api.entity.Element;
import br.com.quimicar.api.repository.ElementRepository;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
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
                    "Post Transition Metals", "Transition Metals", "Lanthanoids", "Actinoids", "Non Metal", "Metalloids");
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
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteByNumber(Integer number) {
        try {
            elementsRepository.deleteByNumber(number);
        }
        catch (Exception error) {
            log.warn("Error to delete element: {}", error.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Could not delete element", error);
        }
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Element updateElement(Integer number, Element element) {
        try {
            Element update = elementsRepository.findByNumber(number);

            System.out.println(element);

            update.setNumber(element.getNumber());
            update.setName(element.getName());
            update.setAtomic_mass(element.getAtomic_mass());
            update.setAppearance(element.getAppearance());
            update.setBoil(element.getBoil());
            update.setCategory(element.getCategory());
            update.setDensity(element.getDensity());
            update.setMelt(element.getMelt());
            update.setMolar_heat(element.getMolar_heat());
            update.setDiscovered_by(element.getDiscovered_by());
            update.setNamed_by(element.getNamed_by());
            update.setPeriod(element.getPeriod());
            update.setPhase(element.getPhase());
            update.setSymbol(element.getSymbol());
            update.setSource(element.getSource());
            update.setSpectral_img(element.getSpectral_img());
            update.setSummary(element.getSummary());
            update.setXpos(element.getXpos());
            update.setYpos(element.getYpos());
            update.setElectron_configuration(element.getElectron_configuration());
            update.setElectron_configuration_semantic(element.getElectron_configuration_semantic());
            update.setElectron_affinity(element.getElectron_affinity());
            update.setElectronegativity_pauling(element.getElectronegativity_pauling());
            update.setElement_img(element.getElement_img());
            update.setEnabled(element.getEnabled() );

            elementsRepository.save(update);
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