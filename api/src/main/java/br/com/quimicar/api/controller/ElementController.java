package br.com.quimicar.api.controller;


import br.com.quimicar.api.entity.ElementEntity;
import br.com.quimicar.api.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ElementController {
    @Autowired
    private final ElementService elementService;

    public ElementController(ElementService elementService) {
        this.elementService = elementService;
    }

    @GetMapping(value="/elements")
    public List<ElementEntity> getAll() {
        return elementService.listElements();
    }

}
