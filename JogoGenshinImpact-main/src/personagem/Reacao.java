package personagem;

/** Reação elemental produzida pela combinação de elementos. */
public class Reacao {
    private final String nome;
    private final String descricao;
    public Reacao(String nome, String descricao) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("A reação precisa ter um nome.");
        this.nome = nome; this.descricao = descricao == null ? "" : descricao;
    }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    @Override public String toString() { return nome + " - " + descricao; }
}
