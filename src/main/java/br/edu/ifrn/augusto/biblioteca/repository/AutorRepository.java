package br.edu.ifrn.augusto.biblioteca.repository;

import br.edu.ifrn.augusto.biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}