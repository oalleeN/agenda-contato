package ada.tech.agenda.exception;

public class NaoExisteContatoException extends Exception {

    public NaoExisteContatoException() {
        super("Nao a contatos existentes");
    }

}
