public class Main {

    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        // Quando for colocar Scanner é basicamente isso //
        // String nome = "";
        // String sobreNome = "";
        // String telefone = "";
        // String email = "";
        // Contato novoContato = new Contato(nome, sobreNome, telefone, email);
        // agenda.adicionarContato(novoContato);

        //Quando for fazer o Scanner não precisa colocar Nome1,Nome2,Nome3
        //Utilize apenas nome,sobrenome,telefone,email que ele vai sobrescrever

        //Simulando Scanner //
        String nome1 = "Lucas";
        String sobreNome1 = "Campos";
        String telefone1 = "11997756525";
        String email1 = "teste01@ada.com.br";
        Contato novoContato1 = new Contato(nome1, sobreNome1, telefone1, email1);
        agenda.adicionarContato(novoContato1);

        String nome2 = "Pedro";
        String sobreNome2 = "Jose";
        String telefone2 = "11997755525";
        String email2 = "teste02@ada.com.br";
        Contato novoContato2 = new Contato(nome2, sobreNome2, telefone2, email2);
        agenda.adicionarContato(novoContato2);

        String nome3 = "Maria";
        String sobreNome3 = "Silva";
        String telefone3 = "11997755525";
        String email3 = "teste03@ada.com.br";
        Contato novoContato3 = new Contato(nome3, sobreNome3, telefone3, email3);
        agenda.adicionarContato(novoContato3);

        String teste01 = String.valueOf(agenda);

        System.out.println(teste01);

    }
}
