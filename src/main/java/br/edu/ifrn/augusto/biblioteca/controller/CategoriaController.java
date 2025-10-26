package br.edu.ifrn.augusto.biblioteca.controller;

import br.edu.ifrn.augusto.biblioteca.model.Categoria;
import br.edu.ifrn.augusto.biblioteca.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}