package br.edu.ifrn.augusto.biblioteca.model;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="livro_autor")
public class LivroAutor{
    @EmbeddedId
    private LivroAutorId id;

    @ManyToOne
    @MapsId("autorId")
    @JoinColumn(name="autor_id")
    private Autor autor;

    @ManyToOne
    @MapsId("livroId")
    @JoinColumn(name="livro_id")
    private Livro livro;

    public LivroAutor(Livro livro, Autor autor){
        this.livro = livro;
        this.autor = autor;
        this.id = new LivroAutorId(livro.getId(), autor.getId());
    }

    public LivroAutorId getId() {
        return this.id;
    }

    public Autor getAutor() {
        return this.autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Livro getLivro() {
        return this.livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
