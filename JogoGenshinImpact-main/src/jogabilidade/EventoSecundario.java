package jogabilidade;
import jogador.Jogador;
import util.ConsoleIO;
public class EventoSecundario extends Eventos {
    public EventoSecundario() { super("Evento secundário", 460); }
    @Override public void executar(Jogador jogador) {
        ConsoleIO.println("Você concluiu o evento secundário!");
        jogador.adicionarGemas(getRecompensaEmGemas());
    }
}
