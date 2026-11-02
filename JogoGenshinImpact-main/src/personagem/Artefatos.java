package personagem;

/** Equipamento independente que pode ser associado a um personagem. */
public class Artefatos {
    private final String nomeDasReliquias;
    private final int quantidadeDePecas;
    private final String sobreAsPecas;

    public Artefatos(String nomeDasReliquias, int quantidadeDePecas, String sobreAsPecas) {
        if (nomeDasReliquias == null || nomeDasReliquias.isBlank()) throw new IllegalArgumentException("O artefato precisa ter um nome.");
        if (quantidadeDePecas < 1) throw new IllegalArgumentException("A quantidade de peças deve ser positiva.");
        this.nomeDasReliquias = nomeDasReliquias;
        this.quantidadeDePecas = quantidadeDePecas;
        this.sobreAsPecas = sobreAsPecas == null ? "" : sobreAsPecas;
    }
    public String getNomeDasReliquias() { return nomeDasReliquias; }
    public int getQuantidadeDePecas() { return quantidadeDePecas; }
    public String getSobreAsPecas() { return sobreAsPecas; }
    @Override public String toString() { return nomeDasReliquias + " (" + quantidadeDePecas + " peças) - " + sobreAsPecas; }
}
