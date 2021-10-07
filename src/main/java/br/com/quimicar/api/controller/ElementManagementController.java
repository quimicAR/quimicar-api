package br.com.quimicar.api.controller;

import br.com.quimicar.api.entity.ElementEntity;
import br.com.quimicar.api.service.ElementManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/management")
@CrossOrigin
public class ElementManagementController {

    private final ElementManagementService elementManagementService;

    @Autowired
    public ElementManagementController(ElementManagementService elementManagementService) {
        this.elementManagementService = elementManagementService;
    }

    @PostMapping(value = "/elements")
    public ResponseEntity<ElementEntity> save(@RequestBody ElementEntity element) {
        return new ResponseEntity<>(elementManagementService.save(element), HttpStatus.OK);
    }

    @DeleteMapping(value = "/elements/{atomicNumber}")
    public void deleteByAtomicNumber(@PathVariable Integer atomicNumber) {
        elementManagementService.deleteByNumber(atomicNumber);
    }

    @PutMapping(value = "/elements/{atomicNumber}")
    public ResponseEntity<ElementEntity> updateElement(@PathVariable Integer atomicNumber, @RequestBody ElementEntity element) {
        return new ResponseEntity<>(elementManagementService.updateElement(atomicNumber, element), HttpStatus.OK);
    }
}
