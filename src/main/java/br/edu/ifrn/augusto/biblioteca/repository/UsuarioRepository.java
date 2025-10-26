package br.edu.ifrn.augusto.biblioteca.repository;
import br.edu.ifrn.augusto.biblioteca.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    List<Usuario> findByNomeContaining(String nome);
}
