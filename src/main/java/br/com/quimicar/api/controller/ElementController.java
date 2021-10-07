package br.com.quimicar.api.controller;

import br.com.quimicar.api.entity.ElementEntity;
import br.com.quimicar.api.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ElementController {

    private final ElementService elementService;

    @Autowired
    public ElementController(ElementService elementService) {
        this.elementService = elementService;
    }

    @GetMapping(value="/elements")
    public ResponseEntity<List<ElementEntity>> getAll() {
        return new ResponseEntity<>(elementService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/elements/{atomicNumber}")
    public ResponseEntity<ElementEntity> getByAtomicNumber(@PathVariable Integer atomicNumber) {
        return new ResponseEntity<>(elementService.findByNumber(atomicNumber), HttpStatus.OK);
    }
}
