package br.edu.ifrn.augusto.biblioteca.repository;
import br.edu.ifrn.augusto.biblioteca.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
public interface EmprestimoRepository extends JpaRepository<Emprestimo,Long> {
    List<Emprestimo> findByUsuarioIdAndStatus(Long idUsuario, Emprestimo.Status status);

    @Query("SELECT e FROM Emprestimo e " +
            "LEFT JOIN FETCH e.usuario " +
            "LEFT JOIN FETCH e.itens i " +
            "LEFT JOIN FETCH i.livro " +
            "WHERE e.dataDevolucaoPrevista < :dataAtual " +
            "AND e.status = br.edu.ifrn.augusto.biblioteca.model.Emprestimo.Status.ATIVO")
    List<Emprestimo> findAtrasados(@Param("dataAtual") LocalDate dataAtual);
}
