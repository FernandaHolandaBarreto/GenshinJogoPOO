package jogabilidade;
import util.ConsoleIO; import jogador.Jogador; import personagem.ColecaoPersonagens; import sistemas.ConteudoExtra;
public class GuiaDeAventureiro {
 private final Missoes missoes=new Missoes(); private final ConteudoExtra extra;
 public GuiaDeAventureiro(){this(new ConteudoExtra());} public GuiaDeAventureiro(ConteudoExtra e){extra=e;}
 public void abrir(Jogador jogador,ColecaoPersonagens colecao){String op;do{ConsoleIO.println("\n===== GUIA DE AVENTUREIRO =====\n1 - Missões diárias\n2 - Monstros\n3 - Especialidade local\n4 - Domínios\n5 - Missões\n0 - Voltar");op=ConsoleIO.readln("Escolha: ");switch(op){case "1"->missoes.menu(jogador);case "2"->extra.guiaMonstros(jogador);case "3"->extra.guiaEspecialidades(jogador);case "4"->extra.guiaDominios(jogador);case "5"->extra.guiaMissoes(jogador);case "0"->{}default->ConsoleIO.println("Opção inválida!");}}while(!op.equals("0"));}
}
