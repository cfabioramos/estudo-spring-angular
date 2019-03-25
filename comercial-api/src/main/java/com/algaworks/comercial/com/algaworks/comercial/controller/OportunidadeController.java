package com.algaworks.comercial.com.algaworks.comercial.controller;

import com.algaworks.comercial.com.algaworks.comercial.model.Oportunidade;
import com.algaworks.comercial.com.algaworks.comercial.repository.OportunidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

    @Autowired
    private OportunidadeRepository repository;

    @GetMapping
    public List<Oportunidade> listar() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oportunidade> buscar(@PathVariable Long id) {

        Optional<Oportunidade> oportunidade = this.repository.findById(id);

        if(!oportunidade.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oportunidade.get());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Oportunidade adicionar(@Valid @RequestBody Oportunidade oportunidade) {
        return this.repository.save(oportunidade);
    }

}
