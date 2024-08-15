import java.util.Scanner;

public class Util {

    public static void escrever(String mensagem) {
        System.out.println(mensagem);
    }

    public static void erro(String mensagem) {
        System.err.println(mensagem);
    }

    public static String ler(Scanner entrada, String questao) {
        System.out.println(questao);
        return entrada.nextLine();
    }
}
