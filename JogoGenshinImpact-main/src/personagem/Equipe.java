package personagem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Equipe agrega personagens que existem independentemente dela. */
public class Equipe {
    private final List<Personagem> membros = new ArrayList<>();
    private String tipoDeReacaoDaEquipe;
    private String tipoDeElemento;

    public Equipe(String tipoDeReacaoDaEquipe, String tipoDeElemento) {
        this.tipoDeReacaoDaEquipe = tipoDeReacaoDaEquipe;
        this.tipoDeElemento = tipoDeElemento;
    }
    public boolean adicionarMembro(Personagem personagem) {
        if (personagem == null || membros.size() >= 4 || membros.contains(personagem)) return false;
        membros.add(personagem); return true;
    }
    public boolean removerMembro(Personagem personagem) { return membros.remove(personagem); }
    public List<Personagem> getMembros() { return Collections.unmodifiableList(membros); }
    public int getQtdDeAliados() { return membros.size(); }
    public String getTipoDeReacaoDaEquipe() { return tipoDeReacaoDaEquipe; }
    public void setTipoDeReacaoDaEquipe(String valor) { tipoDeReacaoDaEquipe = valor; }
    public String getTipoDeElemento() { return tipoDeElemento; }
    public void setTipoDeElemento(String valor) { tipoDeElemento = valor; }
    @Override public String toString() { return "Equipe com " + membros.size() + "/4 personagens | Reação: " + tipoDeReacaoDaEquipe + " | Elemento: " + tipoDeElemento; }
}
