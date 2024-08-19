import ada.tech.agenda.exception.ContatoNaoEncontradoException;
import ada.tech.agenda.exception.TelefoneExistenteException;

import java.util.Scanner;

public class Menu {

    private final Scanner entrada;
    private Agenda agenda; // variavel local agenda dentro classe Menu

    public Menu() {
        this.entrada = new Scanner(System.in);
        agenda = new Agenda(); // instancia da agenda
    }

    public void iniciar() { //throws ContatoNaoEncontradoException {

        int opcao = 0;

        do {
            String opcoes = """
                                        
                    / ============================== \\
                    |             𝗔𝗚𝗘𝗡𝗗𝗔             |
                    \\ ============================== /
                                        
                    / ============ Menu ============ \\
                    | 1 - Adicionar Contato          |
                    | 2 - Detalhar Contato           |
                    | 3 - Editar Contato             |
                    | 4 - Remover Contato            |
                    | 5 - Listar Contatos            |
                    | 6 - Sair                       |
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
                    listarContatos();
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    break;
            }

        } while (opcao != 6);
    }

    public void menuAdicionarContato() {
        System.out.print("Informe o seu primeiro nome: ");
        String nome = entrada.nextLine();

        System.out.print("\nInforme o seu sobrenome: ");
        String sobrenome = entrada.nextLine();

        System.out.print("\nInforme o seu telefone: ");
        String telefone = entrada.nextLine();

        System.out.print("\nInforme o meu Email: ");
        String email = entrada.nextLine();

        int ID = 0;

        Contato novoContato = new Contato(nome, sobrenome, telefone, email, ID);

        try {
            agenda.adicionarContato(novoContato);
            System.out.println("\nCONTATO ADICIONADO!");
        } catch (TelefoneExistenteException e) {
            System.err.println(e.getMessage());
        }
    }

    public void menuRemoverContato() {
        System.out.println("\\ ============================== \\");
        System.out.println("=         EXCLUIR CONTATO         =");
        System.out.println("\\ ============================== /");
        System.out.print("\nInforme um número de tefone: ");
        String numeroTelefone = entrada.nextLine();

        try {
            agenda.excluirContato(numeroTelefone);
            System.out.println("\nCONTATO EXCLUIDO COM SUCESSO!");
        } catch (ContatoNaoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public void menuEditarContato() { //throws ContatoNaoEncontradoException
        System.out.print("Qual contato você deseja editar: ");
        String buscarTelefone = entrada.nextLine();
        try {
            agenda.editarContato(buscarTelefone);
            System.out.println("\nCONTATO EDITADO!");
        } catch (ContatoNaoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public void menuDetalharContato() {//throws ContatoNaoEncontradoException
        System.out.print("Qual contato você deseja detalhar: ");
        String telefone = entrada.next();
        try {
            agenda.detalharContato(telefone);
        } catch (ContatoNaoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public static String subMenuEditarContato() {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        String seletor = "";
        do {
            System.out.println();
            System.out.println("**********************");
            System.out.println("EDITAR CONTATO");
            System.out.println("**********************");
            System.out.println();
            System.out.println("Qual informação deseja editar: ");
            System.out.println();
            System.out.println("1 - Nome Completo");
            System.out.println("2 - Telefone");
            System.out.println("3 - E-mail");
            System.out.println("4 - Voltar ao menu principal");

            System.out.print("Digite a opção desejada: ");
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
                    Menu menu = new Menu();
                    menu.iniciar();
                default:
                    Util.erro("Opcao invalida");
            }
        } while (opcao != 4);

        return seletor;
    }


    public void listarContatos() {
        System.out.println();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("                     CONTATOS DA AGENDA  ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
        System.out.println("ID  | Nome Completo   | Telefone       | E-mail");
        Contato[] contatos = agenda.getListaContatos();
        for (int i = 0; i < contatos.length; i++) {
            System.out.println(String.format("%-3d | %-15s | %-12s | %s",
                    contatos[i].getID(),
                    contatos[i].getNome() + " " + contatos[i].getSobreNome(),
                    contatos[i].getTelefone(),
                    contatos[i].getEmail()
            ));

            System.out.println();
        }
    }
}

    /*public void subMenuDetalharContato () {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("********************** ");
            System.out.println("DETALHAR CONTATO");
            System.out.println("********************** ");
            System.out.println();
            System.out.println("1 - Exibir a agenda completa");
            System.out.println("2 - Exibir contato único");
            System.out.println("3 - Voltar ao menu prinicipal");
            System.out.println();
            System.out.print("Digite a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    agenda.exibirAgendaCompleta();
                    break;
                case 2:
                    menuDetalharContato();
                    break;
                case 3:
                    Menu menu=new Menu();
                    menu.iniciar();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 3);
    }*/