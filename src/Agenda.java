import java.util.Arrays;

public class Agenda {
    Contato[] listaContatos;        // declaracao array listaContatos

    public Agenda(){     // construtor
        listaContatos=new Contato[0]; // inicializando a listaContatos vazia
    }

    public void adicionarContato(Contato novoContato) {
        int novoTamanho = listaContatos.length + 1;  // declarando variavel que é o tamanho atual +1
        Contato[] contatoBackup = new Contato[novoTamanho]; // declarando uma nova lista usando o novo tamanho

        for (int i = 0; i < listaContatos.length; i++) {
            contatoBackup[i] = listaContatos[i];   // copiando os itens da lista atual para a nova lista
        }

        contatoBackup[contatoBackup.length - 1] = novoContato; // add ultimo item na nova posicao da lista

        listaContatos = contatoBackup;
    }

    @Override
    public String toString() {
        return Arrays.toString(listaContatos);
    }
}
