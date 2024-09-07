package ada.tech.agenda.model;

import java.io.*;
import java.util.Scanner;

public class Login {
    
    private String emailColetado;
    private String senhaColetada;

    public void verificarExistenciaLogin() throws IOException {
        File arquivo = new File("DadosUsuario.TXT");

        if (arquivo.exists()) {
            fazerLogin();
        } else {
            criarLogin();
        }
    }

    public void criarLogin() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Infome seu e-mail para cadastro: ");
        String login = sc.nextLine();
        System.out.print("Informe uma senha para cadastro: ");
        String senha = sc.nextLine();

        sc.close();

        try {
            FileWriter writer = new FileWriter("DadosUsuario.txt");
            writer.write(login + "\n");
            writer.write(senha + "\n");
            writer.close();
            System.out.println("Seu cadastro foi criado com sucesso");
        } catch (IOException e) {
            System.out.println("Não foi possivel criar o seu cadastro");
            e.printStackTrace();
        }

    }

    public void fazerLogin() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu email: ");
        String login = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

        validarLogin(login,senha);

    }

    public void validarLogin(String email, String senha) throws IOException {
        coletarDadosLogin();
        if (email.equals(emailColetado) && senha.equals(senhaColetada)) {
            System.out.println("Login efetuado com sucesso");
            // colocar para iniciar o menu agenda
        } else {
            System.out.println("Login e Senha errada");
            fazerLogin(); // Pratica escrota, não usar
        }
    }

    private void coletarDadosLogin() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("DadosUsuario.txt"));
        String[] dados = new String[2];
        for (int i = 0; i < 2; i++) {
            String linha = br.readLine();
            dados[i] = linha;
        }
        this.emailColetado = dados[0];
        this.senhaColetada = dados[1];
        br.close();
    }
}
