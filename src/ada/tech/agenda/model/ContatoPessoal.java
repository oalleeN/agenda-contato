package ada.tech.agenda.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContatoPessoal extends Contato {

    private String apelido;
    private Relacao relacao;
    private LocalDate aniversario;

    public ContatoPessoal(String nome, String sobreNome, String telefone, String email, int ID, String apelido, Relacao relacao, LocalDate aniversario) {
        super(nome, sobreNome, telefone, email, ID);
        this.apelido = apelido;
        this.relacao = relacao;
        this.aniversario = aniversario;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Relacao getRelacao() {
        return relacao;
    }

    public void setRelacao(Relacao relacao) {
        this.relacao = relacao;
    }

    public LocalDate getAniversario() {
        return aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    @Override
    public String toString() {
        return String.format("""
            
            / ====== DADOS DO CONTATO PESSOAL =======
            | Nome: %s %s
            | Telefone: %s
            | E-mail: %s
            | Apelido: %s
            | Relação: %s
            | Aniversário: %s
            \\ ============================================
            """, getNome(), getSobreNome(), getTelefone(), getEmail(), apelido, relacao.name(), aniversario.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
