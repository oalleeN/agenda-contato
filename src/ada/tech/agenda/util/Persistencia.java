package ada.tech.agenda.util;

import ada.tech.agenda.model.Contato;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Persistencia {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static String caminho = "agenda.json";

    public static void gravarContatos(List<Contato> contatos) {
        String formatoJson = gson.toJson(contatos);

        try (FileWriter escrever = new FileWriter(caminho)) {
            escrever.write(formatoJson);
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static List<Contato> lerArquivoAgenda() {

        List<Contato> agendaContatos = new ArrayList<>();

        try (Reader ler = new FileReader(caminho)) {
            Type listaDeContatos = new TypeToken<Collection<Contato>>(){}.getType();

            agendaContatos = gson.fromJson(ler, listaDeContatos);
        } catch (IOException e) {
            System.out.println("Erro ao ler Agenda de Contatos");
        }

        return agendaContatos;
    }


}
