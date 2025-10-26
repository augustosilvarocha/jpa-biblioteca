package br.edu.ifrn.augusto.biblioteca.repository;

import br.edu.ifrn.augusto.biblioteca.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}