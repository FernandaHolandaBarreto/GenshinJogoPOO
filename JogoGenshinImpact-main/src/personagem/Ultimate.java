package personagem;

import util.ConsoleIO;

public class Ultimate implements Habilidades {

    private String nomeDoSupremo;



    @Override
    public void executar(String atacar) {
        ConsoleIO.println("Usando Supremo: " + atacar);
    }

    @Override
    public String toString() {
        return "Personagem.Ultimate{" +
                "nomeDoSupremo='" + nomeDoSupremo + '\'' +
                '}';
    }

    public String getNomeDoSupremo() {
        return nomeDoSupremo;
    }

    public void setNomeDoSupremo(String nomeDoSupremo) {
        this.nomeDoSupremo = nomeDoSupremo;
    }
}
