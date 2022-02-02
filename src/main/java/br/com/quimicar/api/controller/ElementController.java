package br.com.quimicar.api.controller;

import br.com.quimicar.api.entity.Element;
import br.com.quimicar.api.service.ElementService;
import br.com.quimicar.api.utils.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class ElementController {
    private final ElementService elementService;

    @GetMapping(value="/elements")
    @JsonView(View.ElementListView.class)
    public ResponseEntity<List<Element>> findAll() {
        log.info("Get All elements");
        return ResponseEntity.ok().body(elementService.findAll());
    }

    @GetMapping(value="/categories")
    public ResponseEntity<List<String>> findAllCategories() {
        log.info("Get All Categories");
        return ResponseEntity.ok().body(elementService.findAllCategories());
    }

    @GetMapping(value = "/elements/{atomicNumber}")
    @JsonView(View.ElementDetailsView.class)
    public ResponseEntity<Element> getByAtomicNumber(@PathVariable Integer atomicNumber) {
        log.info("Get Element by Atomic number: {}", atomicNumber);
        return ResponseEntity.ok().body(elementService.findByNumber(atomicNumber));
    }

    @PostMapping(value = "/elements")
    public ResponseEntity<Element> save(@RequestBody Element element) {
       log.info("Saving element: {}", element.getName());
       URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/elements").toUriString());
       return ResponseEntity.created(uri).body(elementService.save(element));
    }

    @DeleteMapping(value = "/elements/{atomicNumber}")
    public ResponseEntity<?> deleteByAtomicNumber(@PathVariable Integer atomicNumber) {
        log.info("Deleting Element by Atomic number: {}", atomicNumber);
        elementService.deleteByNumber(atomicNumber);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/elements/{atomicNumber}")
    public ResponseEntity<Element> updateElement(@PathVariable Integer atomicNumber, @RequestBody Element element) {
        log.info("Updating Element by Atomic number: {} - {}", atomicNumber, element.getName());
        return ResponseEntity.ok().body(elementService.updateElement(atomicNumber, element));
    }
}
