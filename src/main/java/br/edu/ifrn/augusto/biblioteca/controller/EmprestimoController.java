package br.edu.ifrn.augusto.biblioteca.controller;

import br.edu.ifrn.augusto.biblioteca.model.Emprestimo;
import br.edu.ifrn.augusto.biblioteca.repository.EmprestimoRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoController(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    @PostMapping
    public Emprestimo criarEmprestimo(@RequestBody Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    @GetMapping("/usuario/{id}")
    public List<Emprestimo> buscarPorUsuario(@PathVariable Long id, @RequestParam Emprestimo.Status status) {
        return emprestimoRepository.findByUsuarioIdAndStatus(id, status);
    }

    @GetMapping("/atrasados")
    public List<Emprestimo> listarAtrasados() {
        return emprestimoRepository.findAtrasados(LocalDate.now());
    }
}