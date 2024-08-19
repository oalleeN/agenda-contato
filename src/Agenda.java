import ada.tech.agenda.exception.ContatoNaoEncontradoException;
import ada.tech.agenda.exception.TelefoneExistenteException;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Agenda {

    public int retornaIndiceElemento(Contato[] arrayContatos, String telefone) {

        for (int i = 0; i < arrayContatos.length; i++) {

            if (arrayContatos[i].getTelefone().equals(telefone)) {
                return i;
            }
        }

        return -1;
    }

    Contato[] listaContatos; // declaracao array listaContatos

    public Agenda() {     // construtor
        listaContatos = new Contato[0]; // inicializando a listaContatos vazia
    }

    public void adicionarContato(Contato novoContato) throws TelefoneExistenteException {
        consultarContatoExistente(novoContato);
        int novoTamanho = listaContatos.length + 1;  // declarando variavel que é o tamanho atual +1
        Contato[] contatoBackup = new Contato[novoTamanho]; // declarando uma nova lista usando o novo tamanho

        for (int i = 0; i < listaContatos.length; i++) {
            contatoBackup[i] = listaContatos[i];   // copiando os itens da lista atual para a nova lista
        }

        contatoBackup[contatoBackup.length - 1] = novoContato; // add ultimo item na nova posicao da lista

        listaContatos = contatoBackup;

        definirID();
    }

    @Override
    public String toString() {
        return Arrays.toString(listaContatos);
    }

    public void consultarContatoExistente(Contato novoContato) throws TelefoneExistenteException {

        // logica para verificar se o novo telefone cadastrado nao é repetido para lancar excessao - trhows
        for (int i = 0; i < listaContatos.length; i++) {
            if (Objects.equals(listaContatos[i].getTelefone(), novoContato.getTelefone())) {
                throw new TelefoneExistenteException();
            }
        }
    }

    public void excluirContato(String telefone) throws ContatoNaoEncontradoException {

        int indice = retornaIndiceElemento(listaContatos, telefone);

        if (indice == -1) {
            throw new ContatoNaoEncontradoException(); //A MSG ESTA NO MENU
        }

        int novoTamanho = listaContatos.length - 1;
        Contato[] contatoBackup = new Contato[novoTamanho];

        for (int i = 0, j = 0; i < listaContatos.length; i++) {
            if (i != indice) {
                contatoBackup[j++] = listaContatos[i];
            }
        }

        listaContatos = contatoBackup;

        definirID();
    }

    public void editarContato(String telefone) throws ContatoNaoEncontradoException {
        Scanner sc = new Scanner(System.in);
        int indice = retornaIndiceElemento(listaContatos, telefone);

        if (indice == -1) {
            throw new ContatoNaoEncontradoException(); //A MSG ESTA NO MENU
        }

        String seletor = Menu.subMenuEditarContato();

        if (seletor.equals("Nome")) {
            System.out.print("\nInforme o primeiro nome: ");
            String novoNome = sc.next();
            listaContatos[indice].setNome(novoNome);
            System.out.print("\nInforme o seu sobrenome: ");
            String novoSobrenome = sc.next();
            listaContatos[indice].setSobreNome(novoSobrenome);
            System.out.println("\nCONTATO EDITADO!");
        }

        if (seletor.equals("Telefone")) {
            System.out.print("\nInforme o novo número: ");
            String novoNumero = sc.next();

            if (retornaIndiceElemento(listaContatos, novoNumero) != -1 || !novoNumero.matches("\\d+")) {
                System.out.println("ERRO! Este número não pode ser adicionado.");
            } else {
                listaContatos[indice].setTelefone(novoNumero);
                System.out.println("\nCONTATO EDITADO!");
            }
        }

        if (seletor.equals("Email")) {
            System.out.print("\nInforme o seu e-mail: ");
            String novoEmail = sc.nextLine();

            if (!novoEmail.contains("@")) {
                System.out.println("ERRO! O e-mail deve conter '@' e ter um formato válido.");
            } else {
                listaContatos[indice].setEmail(novoEmail);
                System.out.println("\nCONTATO EDITADO!");
            }
        }
    }

    public void detalharContato(String telefone) throws ContatoNaoEncontradoException {

        int indice = retornaIndiceElemento(listaContatos, telefone);

        if (indice == -1) {
            throw new ContatoNaoEncontradoException(); //A MSG ESTA NO MENU
        }

        System.out.println(listaContatos[indice]);
    }

    public void definirID() {
        for (int i = 0; i < listaContatos.length; i++) {
            listaContatos[i].setID(i+1);
        }
    }

    public String formatarNome(String nome) {
        return Character.toUpperCase(nome.charAt(0)) + nome.substring(1).toLowerCase();
    }

    private String formatarTelefone(String telefone) {
        if (telefone.length() == 11) {
            return String.format("(%s) %s-%s",
                    telefone.substring(0, 2),
                    telefone.substring(2, 7),
                    telefone.substring(7));
        }

        return telefone;
    }

    public void exibirAgendaCompleta() {

        int tamanhoId = 3;
        int tamanhoNome = 15;
        int tamanhoTelefone = 18;
        int tamanhoEmail = 25;

        System.out.println("=" + "-".repeat(tamanhoId + tamanhoNome + tamanhoTelefone + tamanhoEmail + 11) + "=");
        System.out.printf("| %-" + tamanhoId + "s | %-" + tamanhoNome + "s | %-" + tamanhoTelefone + "s | %-" + tamanhoEmail + "s |%n",
                "ID", "Nome Completo", "Telefone", "E-mail");
        System.out.println("=" + "-".repeat(tamanhoId + tamanhoNome + tamanhoTelefone + tamanhoEmail + 11) + "=");

        for (Contato contato : listaContatos) {
            System.out.printf("| %-" + tamanhoId + "d | %-" + tamanhoNome + "s | %-" + tamanhoTelefone + "s | %-" + tamanhoEmail + "s |%n",
                    contato.getID(),
                    formatarNome(contato.getNome()) + " " + formatarNome(contato.getSobreNome()),
                    formatarTelefone(contato.getTelefone()),
                    contato.getEmail()
            );
            System.out.println("=" + "-".repeat(tamanhoId + tamanhoNome + tamanhoTelefone + tamanhoEmail + 11) + "=");
        }
        System.out.println();
    }
}
