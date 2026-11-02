package personagem;

/** Representa um elemento do universo do jogo; não é um tipo de personagem. */
public class Elemento {
    private final String nome;
    private final String descricao;

    public Elemento(String nome, String descricao) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("O elemento precisa ter um nome.");
        this.nome = nome;
        this.descricao = descricao == null ? "" : descricao;
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    @Override public String toString() { return nome + (descricao.isBlank() ? "" : " - " + descricao); }
}
