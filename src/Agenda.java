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

        String Seletor = Menu.subMenuEditarContato();

        if (Seletor == "Nome") {
            System.out.print("Informe o primeiro nome: ");
            String novoNome = sc.next();
            listaContatos[indice].setNome(novoNome);
            System.out.print("Informe o seu sobrenome: ");
            String novoSobrenome = sc.next();
            listaContatos[indice].setSobreNome(novoSobrenome);
        }

        if (Seletor == "Telefone") {
            System.out.print("Informe o novo numero: ");
            String novoNumero = sc.next();
            listaContatos[indice].setTelefone(novoNumero);
        }

        if (Seletor == "Email") {
            System.out.print("Informe o novo email: ");
            String novoEmail = sc.next();
            listaContatos[indice].setEmail(novoEmail);
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

    public Contato[] getListaContatos(){
        return listaContatos;
    }







//    public void exibirAgendaCompleta() {
//        System.out.println();
//        System.out.println("------------------------");
//        System.out.println("   CONTATOS DA AGENDA  ");
//        System.out.println("------------------------");
//        System.out.println();
//        System.out.println("ID  | Nome Completo   | Telefone       | E-mail");
//        for (int i = 0; i < listaContatos.length; i++) {
//            System.out.println(String.format("%-3d | %-15s | %-12s | %s",
//                    listaContatos[i].getID(),
//                    listaContatos[i].getNome() + " " + listaContatos[i].getSobreNome(),
//                    listaContatos[i].getTelefone(),
//                    listaContatos[i].getEmail()
//            ));;
//        }
//        System.out.println();
//    }

}
