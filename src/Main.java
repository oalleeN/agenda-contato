import ada.tech.agenda.exception.ContatoNaoEncontradoException;

public class Main {
    public static void main(String[] args) throws ContatoNaoEncontradoException {

        Agenda agenda = new Agenda();

        Menu menu=new Menu();
        menu.iniciar();
    }
}
