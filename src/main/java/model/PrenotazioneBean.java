package model;

public class PrenotazioneBean {

    private String nome;
    private int persone;
    private String giorno;
    private String email;
    private String ora;
    private String cellulare;

    public PrenotazioneBean(){

    }

    public PrenotazioneBean(String nome,int persone,String giorno,String email,String ora,String cellulare){

        this.nome = nome;
        this.persone = persone;
        this.giorno = giorno;
        this.email = email;
        this.ora = ora;
        this.cellulare = cellulare;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPersone() {
        return persone;
    }

    public void setPersone(int persone) {
        this.persone = persone;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    @Override
    public String toString() {
        return "PrenotazioneBean{" +
                "nome='" + nome + '\'' +
                ", persone=" + persone +
                ", giorno='" + giorno + '\'' +
                ", email='" + email + '\'' +
                ", ora=" + ora +
                ", cellulare=" + cellulare +
                '}';
    }
}
