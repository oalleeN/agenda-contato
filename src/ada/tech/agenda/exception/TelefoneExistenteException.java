package ada.tech.agenda.exception;

public class TelefoneExistenteException extends Exception {

    public TelefoneExistenteException() {
        super("O telefone ja existe nesta agenda");
    }

}
