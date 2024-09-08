package ada.tech.agenda.model;

public class Contato {

    private String nome;
    private String sobreNome;
    private String telefone;
    private String email;
    private int ID;

    public Contato(String nome, String sobreNome, String telefone, String email, int ID) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.telefone = telefone;
        this.email = email;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return String.format("""

                / ====== DADOS DO CONTATO =======
                | ID: %s
                | Nome: %s %s
                | Telefone: %s
                | E-mail: %s
                \\ ==============================
                """,ID, nome, sobreNome, telefone, email);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getID() { return ID; }

    public void setID(int ID) { this.ID = ID; }
}
