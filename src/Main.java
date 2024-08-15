import ada.tech.agenda.visao.Menu;
import ada.tech.agenda.modelo.Contato;

public class Main {

    public static void main(String[] args) {

        int contador = 1 ;
        Contato[] contato = new Contato[contador];
        contato[0] = new Contato("Rafael", "Silva", "11997456560", "teste@dawda.com");

        System.out.println(contato[0]);

        int novoTamanho = contador + 1;
        Contato[] contatoBackup = new Contato[novoTamanho];

        for (int i = 0; i < contato.length; i++) {
            contatoBackup[i] = new Contato(
                    contato[i].getNome(),
                    contato[i].getSobreNome(),
                    contato[i].getTelefone(),
                    contato[i].getEmail()
            );
        }

        contato = contatoBackup; // Aqui ele vai sobrescrever o contato com o armazenamento do contatoBackup e tamanhanho
        // do array dele nesse caso agora contato tem array tamanho 2 porque lá em cima deixei o contatoBackup com 2;

        contato[1] = new Contato("Luiz", "Silva", "11997456660", "teste@dawda.com");

        // REPETINDO PROCESSO

        novoTamanho = contato.length + 1;
        contatoBackup = new Contato[novoTamanho];

        for (int i = 0; i < contato.length; i++) {
            contatoBackup[i] = new Contato(
                    contato[i].getNome(),
                    contato[i].getSobreNome(),
                    contato[i].getTelefone(),
                    contato[i].getEmail()
            );
        }

        contato = contatoBackup;

        contato[2] = new Contato("Pedro", "Silva", "11997457777", "teste@dawda.com");

        // REPETINDO PROCESSO

        novoTamanho = contato.length + 1;
        contatoBackup = new Contato[novoTamanho];

        for (int i = 0; i < contato.length; i++) {
            contatoBackup[i] = new Contato(
                    contato[i].getNome(),
                    contato[i].getSobreNome(),
                    contato[i].getTelefone(),
                    contato[i].getEmail()
            );
        }

        contato = contatoBackup;

        contato[3] = new Contato("Pedro", "Silva", "11997457777", "teste@dawda.com");

        for (int i = 0; i < contato.length; i++) {
            System.out.println(contato[i]);
        }
    }
}
