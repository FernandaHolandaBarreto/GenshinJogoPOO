package jogabilidade;

import jogador.Jogador;

// Modelo abstrato de um evento: cada evento define sua própria execução. //
public abstract class Eventos {
    private final String nomeDoEvento;
    private final int recompensaEmGemas;

    protected Eventos(String nomeDoEvento, int recompensaEmGemas) {
        if (nomeDoEvento == null || nomeDoEvento.isBlank()) throw new IllegalArgumentException("O evento precisa ter um nome.");
        if (recompensaEmGemas < 0) throw new IllegalArgumentException("A recompensa não pode ser negativa.");
        this.nomeDoEvento = nomeDoEvento;
        this.recompensaEmGemas = recompensaEmGemas;
    }
    public String getNomeDoEvento() { return nomeDoEvento; }
    public int getRecompensaEmGemas() { return recompensaEmGemas; }
    public abstract void executar(Jogador jogador);
    @Override public String toString() { return nomeDoEvento + " (" + recompensaEmGemas + " gemas)"; }
}
