package ada.tech.agenda.exception;

public class ContatoNaoEncontradoException extends Exception {

    public ContatoNaoEncontradoException() {
        super("O contato nao existe na agenda");
    }
}
