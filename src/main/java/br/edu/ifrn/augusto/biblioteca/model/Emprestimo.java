package br.edu.ifrn.augusto.biblioteca.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name="emprestimo")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoEfetiva;
    @Enumerated(EnumType.STRING)
    private Status status;
    private float valorMulta;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    @JsonBackReference
    private Usuario usuario;

    @OneToMany(mappedBy = "emprestimo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemEmprestimo> itens;

    public enum Status {
        ATIVO,
        DEVOLVIDO,
        ATRASADO
    }

    public Long getId() {
        return this.id;
    }

    public LocalDate getDataEmprestimo() {
        return this.dataEmprestimo;
    }
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return this.dataDevolucaoPrevista;
    }
    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoEfetiva() {
        return this.dataDevolucaoEfetiva;
    }
    public void setDataDevolucaoEfetiva(LocalDate dataDevolucaoEfetiva) {
        this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
    }

    public Status getStatus() {
        return this.status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public float getValorMulta() {
        return this.valorMulta;
    }
    public void setValorMulta(float valorMulta) {
        this.valorMulta = valorMulta;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemEmprestimo> getItens() {
        return this.itens;
    }
    public void setItens(List<ItemEmprestimo> itens) {
        this.itens = itens;
    }
}
