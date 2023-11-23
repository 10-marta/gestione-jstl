package it.accenture.gara.model;

import java.util.Objects;

public class Atleta {
    private String id;
    private String nome;
    private String cognome;
    private String categoria;
    private String societa;

    public Atleta(String id, String nome, String cognome, String categoria, String societa) {
        super();
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.categoria = categoria;
        this.societa = societa;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getCognome() {return cognome;}

    public void setCognome(String cognome) {this.cognome = cognome;}

    public String getCategoria() {return categoria;}

    public void setCategoria(String categoria) {this.categoria = categoria;}

    public String getSocieta() {return societa;}

    public void setSocieta(String societa) {this.societa = societa;}

    @Override
    public String toString() {
        return "Atleta{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", societa='" + societa + '\'' +
                '}';
    }

    public Atleta update(Atleta item){
        this.nome=item.getNome();
        this.cognome=item.getCognome();
        this.categoria=item.getCategoria();
        this.societa=item.getSocieta();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atleta atleta = (Atleta) o;
        return Objects.equals(id, atleta.id) && Objects.equals(nome, atleta.nome) && Objects.equals(cognome, atleta.cognome)
                && Objects.equals(categoria, atleta.categoria) && Objects.equals(societa, atleta.societa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cognome, categoria, societa);
    }
}
