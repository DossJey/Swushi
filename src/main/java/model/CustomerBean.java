
package model;

public class CustomerBean {


    private String nome;
    private String cognome;
    private String password;
    private String username;
    private String email;
    private int isAdmin;


    public CustomerBean() {

    }

    public CustomerBean(String nome, String cognome, String password, String username,String email) {

        super();
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.username = username;
        this.email = email;
    }

    //GETS

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public String getEmail(){
        return email;
    }

    //SETS

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsadmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email){ this.email = email; }


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CustomerBean that = (CustomerBean) object;
        return isAdmin == that.isAdmin && java.util.Objects.equals(nome, that.nome) && java.util.Objects.equals(cognome, that.cognome) && java.util.Objects.equals(password, that.password) && java.util.Objects.equals(username, that.username);
    }

    @Override
    public String toString() {
        return "CustomerBean{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }


}