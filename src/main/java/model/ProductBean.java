package model;

import java.util.Objects;

public class ProductBean {

    private int idprod;
    private String nome;
    private double prezzo;
    private String descrizione;

    public ProductBean() {

    }


    public ProductBean(int idprod, String nome, double prezzo, String descrizione) {

        this.idprod = idprod;
        this.nome = nome;
        this.prezzo = prezzo;

        this.descrizione = descrizione;

    }


    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }


    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "ProductBean{" +
                "idprod=" + idprod +
                ", nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBean that = (ProductBean) o;
        return idprod == that.idprod && Double.compare(that.prezzo, prezzo) == 0 && Objects.equals(nome, that.nome) && Objects.equals(descrizione, that.descrizione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idprod, nome, prezzo, descrizione);
    }
}