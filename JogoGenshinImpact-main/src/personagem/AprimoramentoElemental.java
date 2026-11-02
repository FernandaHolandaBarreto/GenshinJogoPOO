package personagem;

import util.ConsoleIO;

public class AprimoramentoElemental implements Habilidades {

    private String nomeDoAprimoramento;


    @Override
    public void executar(String atacar) {
        ConsoleIO.println("Usando aprimoramento elemental: " + atacar);
    }

    @Override
    public String toString() {
        return "Personagem.AprimoramentoElemental{" +
                "nomeDoAprimoramento='" + nomeDoAprimoramento + '\'' +
                '}';
    }

    public String getNomeDoAprimoramento() {
        return nomeDoAprimoramento;
    }

    public void setNomeDoAprimoramento(String nomeDoAprimoramento) {
        this.nomeDoAprimoramento = nomeDoAprimoramento;
    }
}
