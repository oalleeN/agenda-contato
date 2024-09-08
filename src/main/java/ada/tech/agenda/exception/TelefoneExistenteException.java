package ada.tech.agenda.exception;

public class TelefoneExistenteException extends Exception {

    public TelefoneExistenteException() {
        super("O TELEFONE JÁ EXISTE NESTA AGENDA!\n");
    }

}
