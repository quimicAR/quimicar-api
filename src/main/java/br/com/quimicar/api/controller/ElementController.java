package br.com.quimicar.api.controller;

import br.com.quimicar.api.entity.ElementEntity;
import br.com.quimicar.api.service.ElementService;
import br.com.quimicar.api.utils.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ElementController {

    private final ElementService elementService;

    @Autowired
    public ElementController(ElementService elementService) {
        this.elementService = elementService;
    }

    @GetMapping(value="/elements")
    @JsonView(View.ElementListView.class)
    public ResponseEntity<List<ElementEntity>> findAll() {
        return new ResponseEntity<>(elementService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/elements/{atomicNumber}")
    @JsonView(View.ElementDetailsView.class)
    public ResponseEntity<ElementEntity> getByAtomicNumber(@PathVariable Integer atomicNumber) {
        return new ResponseEntity<>(elementService.findByNumber(atomicNumber), HttpStatus.OK);
    }

    @PostMapping(value = "/elements")
    public ResponseEntity<ElementEntity> save(@RequestBody ElementEntity element) {
        System.out.println(element.getName());
        return new ResponseEntity<>(elementService.save(element), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/elements/{atomicNumber}")
    public void deleteByAtomicNumber(@PathVariable Integer atomicNumber) {
        elementService.deleteByNumber(atomicNumber);
    }

    @PutMapping(value = "/elements/{atomicNumber}")
    public ResponseEntity<ElementEntity> updateElement(@PathVariable Integer atomicNumber, @RequestBody ElementEntity element) {
        return new ResponseEntity<>(elementService.updateElement(atomicNumber, element), HttpStatus.OK);
    }
}
