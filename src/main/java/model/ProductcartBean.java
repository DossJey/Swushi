package model;

public class ProductcartBean extends ProductBean {


    private int quantita;

    public ProductcartBean(){

    }

    public ProductcartBean(int idprod,String nome, Double prezzo,String descrizione, int quantita){

        super(idprod,nome,prezzo,descrizione);
        this.quantita = quantita;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}
