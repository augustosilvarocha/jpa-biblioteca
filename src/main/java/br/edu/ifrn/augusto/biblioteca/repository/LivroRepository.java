package br.edu.ifrn.augusto.biblioteca.repository;
import br.edu.ifrn.augusto.biblioteca.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long>{
    List<Livro> findByQuantidadeDisponivelGreaterThanOrderByTituloAsc(int quantidade);
    List<Livro> findByCategoriaNome(String categoriaNome);
    List<Livro> findByAutoresNomeContainingIgnoreCaseOrderByAnoPublicacaoAsc(String nomeAutor);
    @Query("SELECT l.categoria.nome, COUNT(l) " +
            "FROM Livro l " +
            "GROUP BY l.categoria.nome " +
            "ORDER BY COUNT(l) DESC")
    List<Object[]> contarLivrosPorCategoria();

    @Query("SELECT l FROM Livro l WHERE l.quantidadeDisponivel > 0")
    List<Livro> findLivrosDisponiveis();
}
