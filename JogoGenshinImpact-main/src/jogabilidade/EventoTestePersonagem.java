package jogabilidade;
import jogador.Jogador;
import util.ConsoleIO;
public class EventoTestePersonagem extends Eventos {
    public EventoTestePersonagem() { super("Teste de personagens", 40); }
    @Override public void executar(Jogador jogador) {
        ConsoleIO.println("Você concluiu o teste de personagem!");
        jogador.adicionarGemas(getRecompensaEmGemas());
    }
}
