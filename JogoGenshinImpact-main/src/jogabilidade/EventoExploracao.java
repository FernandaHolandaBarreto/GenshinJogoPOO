package jogabilidade;
import jogador.Jogador;
import util.ConsoleIO;
public class EventoExploracao extends Eventos {
    public EventoExploracao() { super("Explorar região nova", 400); }
    @Override public void executar(Jogador jogador) {
        ConsoleIO.println("Você concluiu a exploração especial!");
        jogador.adicionarGemas(getRecompensaEmGemas());
    }
}
