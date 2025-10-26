package br.edu.ifrn.augusto.biblioteca.controller;

import br.edu.ifrn.augusto.biblioteca.repository.*;
import br.edu.ifrn.augusto.biblioteca.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    @GetMapping("/disponiveis")
    public List<Livro> listarLivrosDisponiveis() {
        return livroRepository.findLivrosDisponiveis();
    }

    @GetMapping("/categoria/{nome}")
    public List<Livro> buscarPorCategoria(@PathVariable String nome) {
        return livroRepository.findByCategoriaNome(nome);
    }

    @GetMapping("/autor/{nome}")
    public List<Livro> buscarPorAutor(@PathVariable String nome) {
        return livroRepository.findByAutoresNomeContainingIgnoreCaseOrderByAnoPublicacaoAsc(nome);
    }

    @GetMapping("/contagem/categoria")
    public List<Object[]> contarLivrosPorCategoria() {
        return livroRepository.contarLivrosPorCategoria();
    }
}
