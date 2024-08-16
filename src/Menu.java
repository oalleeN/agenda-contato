import ada.tech.agenda.exception.ContatoNaoEncontradoException;
import ada.tech.agenda.exception.TelefoneExistenteException;

import java.util.Scanner;

public class Menu {

    private final Scanner entrada;
    private Agenda agenda; // variavel local agenda dentro classe Menu

    public Menu() {
        this.entrada = new Scanner(System.in);
        agenda= new Agenda(); // instancia da agenda
    }

    public void iniciar() {

        int opcao = 0;

        do {
            String opcoes = STR."""

                    ####################
                    ##     𝗔𝗚𝗘𝗡𝗗𝗔     ##
                    ####################

                    >>>> Menu <<<<
                    1 - Adicionar Contato
                    2 - Detalhar Contato
                    3 - Editar Contato
                    4 - Remover Contato
                    5 - Sair

                    """;

            Util.escrever(opcoes);
            opcao = Integer.parseInt(Util.ler(entrada, "Digite a opcao:"));

            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:
                    menuRemoverContato();
                    break;
                default:
                    Util.erro("Opcao invalida");
                    break;
            }

        } while (opcao <= 4);

    }

    public void adicionarContato() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o seu primeiro nome: ");
        String nome = sc.nextLine();

        System.out.println("Informe o seu sobrenome: ");
        String sobrenome = sc.nextLine();

        System.out.println("Informe o seu telefone: ");
        String telefone = sc.nextLine();

        System.out.println("Informe o meu Email: ");
        String email = sc.nextLine();

        Contato novoContato = new Contato(nome,sobrenome,telefone,email);

        try {
            agenda.adicionarContato(novoContato);// add conttao na agenda
        }catch (TelefoneExistenteException e){
            System.out.println("**********************************************");
            System.out.println(e.getMessage()); // printa a mensagem contida no TelefoneExistenteException.java
            System.out.println("**********************************************");
        }

    }

    public void menuRemoverContato() {
        Scanner sc = new Scanner(System.in);
        System.out.println("******************");
        System.out.println("EXCLUIR CONTATO"); // printa a mensagem contida no TelefoneExistenteException.java
        System.out.println("******************");
        System.out.print("Informe um numero de tefone: ");
        String numeroTelefone = sc.nextLine();

        try {
            agenda.excluirContato(numeroTelefone);
            System.out.println();
            System.out.println("CONTATO EXCLUIDO COM SUCESSO");
            System.out.println();
        } catch (ContatoNaoEncontradoException e) {
            System.out.println();
            System.out.println("CONTATO NÂO ENCONTRADO");
            System.out.println();
        }

    }

}
