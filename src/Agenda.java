import ada.tech.agenda.modelo.Contato;

public class Agenda {
  private Contato[] contatos;
  private int tamanho;

  public Agenda() {
      this.contatos = new Contato[1];
      this.tamanho = 0;
  }

  public void addContato(Contato contact) {
      if (tamanho == contatos.length) {
        ajustarAcrescimo();
      }
      contatos[tamanho] = contact;
      tamanho++;
  }

  private void ajustarAcrescimo() {
    Contato[] contatosAtualizados = new Contato[contatos.length * 2];
      for (int i = 0; i < contatos.length; i++) {
        contatosAtualizados[i] = contatos[i];
      }
      contatos = contatosAtualizados;
  }

  public Contato[] getContatos() {
    Contato[] contactsCopy = new Contato[tamanho];
    for (int i = 0; i < tamanho; i++) {
        contactsCopy[i] = contatos[i];
    }
    return contactsCopy;
  }
}