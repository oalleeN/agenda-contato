package ada.tech.agenda.model;

import ada.tech.agenda.Menu;
import ada.tech.agenda.exception.ContatoNaoEncontradoException;
import ada.tech.agenda.exception.TelefoneExistenteException;
import ada.tech.agenda.util.Persistencia;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Agenda {

    List<Contato> listaContatos;

    public Agenda() { // construtor


        this.listaContatos =  Persistencia.lerArquivoAgenda();
        if(listaContatos == null) {

            listaContatos = new ArrayList<>(); // inicializando a listaContatos vazia
        }
    }

/*    private void gravarContatos() {

        try (FileWriter escrever = new FileWriter("agenda.txt")) {
            escrever.write(listaContatos.toString());
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }*/

    public int retornaIndiceElemento(List<Contato> arrayContatos, String telefone) {
        for (int i = 0; i < arrayContatos.size(); i++) {

            if (arrayContatos.get(i).getTelefone().equals(telefone)) {
                return i;
            }
        }
        return -1;
    }

    public void adicionarContato(Contato novoContato) throws TelefoneExistenteException {
        int indice = retornaIndiceElemento(listaContatos, novoContato.getTelefone());

        if (indice != -1) {
            throw new TelefoneExistenteException();
        }

        listaContatos.add(novoContato);
        definirID();

        Persistencia.gravarContatos(this.listaContatos);
    }

    @Override
    public String toString() {
        return listaContatos.toString();
    }

    public void excluirContato(String telefone) throws ContatoNaoEncontradoException {

        int indice = retornaIndiceElemento(listaContatos, telefone);

        if (indice == -1) {
            throw new ContatoNaoEncontradoException();
        }

        listaContatos.remove(indice);

        definirID();

        //gravarContatos();
    }

    public void editarContato(String telefone) throws ContatoNaoEncontradoException {

        int indice = retornaIndiceElemento(listaContatos, telefone);

        if (indice == -1) {
            throw new ContatoNaoEncontradoException();
        }

        Contato contato = listaContatos.get(indice);

        String seletor = Menu.subMenuEditarContato();

        switch (seletor.toUpperCase()) {
            case "NOME":
                editarNome(contato);
                break;
            case "TELEFONE":
                editarTelefone(contato);
                break;
            case "EMAIL":
                editarEmail(contato);
                break;
            default:
                System.out.println("Opção inválida!");
        }

        //gravarContatos();
    }

    private void editarNome(Contato contato) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nInforme o primeiro nome: ");
        String novoNome = sc.next();
        contato.setNome(novoNome);
        System.out.print("\nInforme o seu sobrenome: ");
        String novoSobrenome = sc.next();
        contato.setSobreNome(novoSobrenome);
        System.out.println("\nCONTATO EDITADO!");
    }

    private void editarTelefone(Contato contato) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nInforme o novo número: ");
        String novoNumero = sc.next();

        if (retornaIndiceElemento(listaContatos, novoNumero) != -1 || !novoNumero.matches("\\d+")) {
            System.out.println("ERRO! Este número não pode ser adicionado.");
        } else {
            contato.setTelefone(novoNumero);
            System.out.println("\nCONTATO EDITADO!");
        }
    }

    private void editarEmail(Contato contato) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nInforme o seu e-mail: ");
        String novoEmail = sc.nextLine();

        if (!novoEmail.contains("@")) {
            System.out.println("ERRO! O e-mail deve conter '@' e ter um formato válido.");
        } else {
            contato.setEmail(novoEmail);
            System.out.println("\nCONTATO EDITADO!");
        }
    }

    public void detalharContato(String telefone) throws ContatoNaoEncontradoException {

        int indice = retornaIndiceElemento(listaContatos, telefone);

        if (indice == -1) {
            throw new ContatoNaoEncontradoException(); //A MSG ESTA NO MENU
        }

        System.out.println(listaContatos.get(indice));
    }

    private void definirID() {
        for (int i = 0; i < listaContatos.size(); i++) {
            listaContatos.get(i).setID(i+1);
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
