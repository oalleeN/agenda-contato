package ada.tech.agenda.exception;

import ada.tech.agenda.modelo.Contato;

public class ContatoNaoEncontradoException extends Exception {

    public ContatoNaoEncontradoException() {
        super("O contato nao existe na agenda");
    }

}
