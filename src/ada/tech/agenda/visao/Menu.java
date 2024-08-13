package ada.tech.agenda.visao;

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

                String lista="";

                String opcoes = STR."""

                    ##################
                    ##### AGENDA #####
                    ##################

                    >>>> Contatos <<<<
                    \{lista}

                    >>>> Menu <<<<
                    1 - Adicionar Contato
                    2 - Detalhar Contato
                    3 - Editar Contato
                    4 - Remover Contato
                    5 - Sair

                    """;

                Util.escrever(opcoes);
                opcao =  Integer.parseInt(Util.ler(entrada, "Digite a opcao:"));

                switch (opcao){
                    case 1:
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

            } while(opcao <= 4);

    }

}