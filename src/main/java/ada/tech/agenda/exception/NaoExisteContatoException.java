package ada.tech.agenda.exception;

public class NaoExisteContatoException extends Exception {

    public NaoExisteContatoException() {
        super("NÃO HÁ CONTATOS EXISTENTES!\n");
    }

}
