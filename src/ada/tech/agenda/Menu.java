package ada.tech.agenda;

import ada.tech.agenda.exception.ContatoNaoEncontradoException;
import ada.tech.agenda.exception.TelefoneExistenteException;
import ada.tech.agenda.model.Agenda;
import ada.tech.agenda.model.Contato;
import ada.tech.agenda.util.Util;

import java.util.Scanner;

public class Menu {

    private final Scanner entrada;
    private Agenda agenda;

    public Menu() {
        this.entrada = new Scanner(System.in);
        agenda = new Agenda();
    }

    public void iniciar() {

        int opcao = 0;

        do {
            System.out.println();
            agenda.exibirAgendaCompleta();

            String opcoes = """
                    
                    / ============================== \\
                    |             𝗔𝗚𝗘𝗡𝗗𝗔             |
                    \\ ============================== /
                    
                    / ============ Menu ============ \\
                    | 1 - Adicionar Contato          |
                    | 2 - Detalhar Contato           |
                    | 3 - Editar Contato             |
                    | 4 - Remover Contato            |
                    | 5 - Sair                       |
                    \\ ============================== /
                    """;

            Util.escrever(opcoes);
            System.out.print("Digite uma opção: ");
            String opcaoString = entrada.next();

            try {
                opcao = Integer.parseInt(opcaoString);
                entrada.nextLine();
            } catch (NumberFormatException e) {
                System.err.println("ERRO! Informe uma opção válida!\n");
                continue;
            }

            // Mensagem de erro para opções inválidas
            if (opcao < 1 || opcao > 5) {
                Util.erro("ERRO! Informe uma opção válida!");
            }

            System.out.println();

            switch (opcao) {
                case 1:
                    menuAdicionarContato();
                    break;

                case 2:
                    menuDetalharContato();
                    break;

                case 3:
                    menuEditarContato();
                    break;

                case 4:
                    menuRemoverContato();
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    break;
            }

        } while (opcao != 5);
    }

    public void menuAdicionarContato() {

        System.out.print("Informe o seu primeiro nome: ");
        String nome = entrada.nextLine();

        System.out.print("\nInforme o seu sobrenome: ");
        String sobrenome = entrada.nextLine();

        String telefone;
        while (true) {
            System.out.print("\nInforme o seu telefone: ");
            telefone = entrada.nextLine();

            if (telefone.matches("\\d+")) {
                break;
            } else {
                System.out.println("\nERRO! O telefone deve conter apenas números.");
            }
        }

        String email;
        while (true) {
            System.out.print("\nInforme o seu e-mail: ");
            email = entrada.nextLine();

            if (email.contains("@")) {
                break;
            } else {
                System.out.println("\nERRO! O e-mail deve conter '@' e ter um formato válido.");
            }
        }

        int ID = 0;

        Contato novoContato = new Contato(nome, sobrenome, telefone, email, ID);

        try {
            agenda.adicionarContato(novoContato);
            System.out.println("\nCONTATO ADICIONADO!");
        } catch (TelefoneExistenteException e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    public void menuRemoverContato() {
        System.out.println("/ ============================== \\");
        System.out.println("|         EXCLUIR CONTATO         |");
        System.out.println("\\ ============================== /");
        System.out.print("\nInforme um número de tefone: ");
        String numeroTelefone = entrada.nextLine();

        try {
            agenda.excluirContato(numeroTelefone);
            System.out.println("\nCONTATO EXCLUIDO COM SUCESSO!");
        } catch (ContatoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void menuEditarContato() {
        System.out.print("Qual contato você deseja editar: ");
        String buscarTelefone = entrada.nextLine();
        try {
            agenda.editarContato(buscarTelefone);
        } catch (ContatoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void menuDetalharContato() {
        System.out.print("Qual contato você deseja detalhar: ");
        String telefone = entrada.next();
        try {
            agenda.detalharContato(telefone);
        } catch (ContatoNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String subMenuEditarContato() {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println();
            System.out.println("/ ============================== \\");
            System.out.println("|         EDITAR CONTATO         |");
            System.out.println("\\ ============================= /");
            System.out.println("\nQual informação deseja editar? \n");
            System.out.println("/ ============================== \\");
            System.out.println("| 1 - Nome Completo              |");
            System.out.println("| 2 - Telefone                   |");
            System.out.println("| 3 - E-mail                     |");
            System.out.println("| 4 - Voltar ao menu principal   |");
            System.out.println("\\ ============================= /");

            System.out.print("\nDigite a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    return "Nome";
                case 2:
                    return "Telefone";
                case 3:
                    return "Email";
                case 4:
                    return "";
                default:
                    Util.erro("Opção inválida");
            }
        } while (opcao != 4);

        return "";
    }
}