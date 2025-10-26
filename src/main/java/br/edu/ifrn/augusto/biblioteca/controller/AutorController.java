package br.edu.ifrn.augusto.biblioteca.controller;

import br.edu.ifrn.augusto.biblioteca.model.Autor;
import br.edu.ifrn.augusto.biblioteca.repository.AutorRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autores")
public class AutorController {
    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public Autor criarAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }
}