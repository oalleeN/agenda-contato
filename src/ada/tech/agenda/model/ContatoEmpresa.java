package ada.tech.agenda.model;

import ada.tech.agenda.util.AdaptadorContato;

public class ContatoEmpresa extends Contato {

    private String cnpj;
    private String logradouro;
    private String segmento;

    private String tipo = "ContatoEmpresa";

    public ContatoEmpresa(String nome, String telefone, String email, int ID, String cnpj, String logradouro, String segmento) {
        super(nome, "", telefone, email, ID);
        this.setCnpj(cnpj);
        this.logradouro = logradouro;
        this.segmento = segmento;
    }

    @Override
    public String toString() {
        return String.format("""

                / ====== DADOS DA EMPRESA =======
                | ID: %s
                | Nome: %s %s
                | Telefone: %s
                | E-mail: %s
                | Logradouro: %s
                | Segmento: %s
                | CNPJ: %s
                \\ ==============================
                """,getID(), getNome(), getTelefone(), getEmail(), getLogradouro(), getSegmento(), getCnpj());
    }

    public String getCnpj() {
        return cnpj;
    }

    private int calcularDV(String cnpj, int posInicial) {

        int peso = 2;
        int somaDigitos = 0;

        for(int i = posInicial; i >= 0; i--) {

            char digitoCNPJ = cnpj.charAt(i);
            int digitoNum = Character.getNumericValue(digitoCNPJ);
            int valor = digitoNum * peso;
            somaDigitos += valor;

            peso++;

            if(peso == 10) {
                peso = 2;
            }
        }

        int calcularDv = somaDigitos % 11;

        if(calcularDv == 0 || calcularDv == 1) {
            return 0;
        } else {
            return 11 - calcularDv;
        }
    }

    public void setCnpj(String cnpj) {

        if(cnpj.length() == 14) {

            int digitoUm = calcularDV(cnpj, 11);
            int digitoDois = calcularDV(cnpj, 12);

            char dvUmToChar = (char) (digitoUm + '0');
            char dvDoisToChar = (char) (digitoDois + '0');

            if(dvUmToChar == cnpj.charAt(12) && dvDoisToChar == cnpj.charAt(13)) {
                this.cnpj = cnpj;
            } else {
                throw new IllegalArgumentException("CNPJ INVÁLIDO");
            }
        } else {
            throw new IllegalArgumentException("CNPJ deve ter 14 dígitos");
        }
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }
}
