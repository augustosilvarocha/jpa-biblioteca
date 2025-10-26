package br.edu.ifrn.augusto.biblioteca.model;
import jakarta.persistence.*;

@Entity
@Table(name="item_emprestimo")
public class ItemEmprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="emprestimo_id")
    private Emprestimo emprestimo;

    @ManyToOne
    @JoinColumn(name="livro_id")
    private Livro livro;

    public Long getId() {
        return this.id;
    }

    public Emprestimo getEmprestimo() {
        return this.emprestimo;
    }
    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Livro getLivro() {
        return this.livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
