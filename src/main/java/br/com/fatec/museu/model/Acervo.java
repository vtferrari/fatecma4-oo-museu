package br.com.fatec.museu.model;

import javax.persistence.*;

@Table(name = "acervo")
@Entity
public class Acervo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String obra;
    @Column(length = 1024)
    private String descricao;
    private String autor;
    private String local;
    private String imagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "Acervo{" +
                "id=" + id +
                ", obra='" + obra + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
