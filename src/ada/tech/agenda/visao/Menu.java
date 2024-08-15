package ada.tech.agenda.visao;

import ada.tech.agenda.modelo.Contato;
import ada.tech.agenda.utilitario.Util;

import java.util.Scanner;

public class Menu {

    private final Scanner entrada;

    public Menu() {
        this.entrada = new Scanner(System.in);
    }

    public void iniciar() {

        int opcao = 0;

        do {

            String lista = "";

            String opcoes = String.format("""
                    
                            ##################
                            ##### AGENDA #####
                            ##################
                            
                            >>>> Contatos <<<<
                            %s
                            
                            >>>> Menu <<<<
                            1 - Adicionar Contato
                            2 - Detalhar Contato
                            3 - Editar Contato
                            4 - Remover Contato
                            5 - Sair
                            
                            """, lista);

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

    }

}