package ada.tech.agenda.exception;

public class ContatoNaoEncontradoException extends Exception {

    public ContatoNaoEncontradoException() {
        super("O CONTATO NÃO EXISTE NA AGENDA!\n");
    }
}
