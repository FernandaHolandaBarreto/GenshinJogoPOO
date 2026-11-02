package jogabilidade;
import jogador.Jogador;
import util.ConsoleIO;
public class EventoPrincipal extends Eventos {
    public EventoPrincipal() { super("Evento principal", 1000); }
    @Override public void executar(Jogador jogador) {
        ConsoleIO.println("Você concluiu o evento principal!");
        jogador.adicionarGemas(getRecompensaEmGemas());
    }
}
