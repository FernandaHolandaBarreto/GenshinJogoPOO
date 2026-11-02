package personagem;
import util.ConsoleIO; import java.util.*;
public class ColecaoPersonagens {
 private final ArrayList<Personagem> personagens=new ArrayList<>();
 public void adicionarPersonagem(Personagem p){if(p==null)return; for(Personagem existente:personagens)if(existente.getNome().equals(p.getNome())){existente.adicionarConstelacao();ConsoleIO.println("Cópia convertida em constelação! "+existente.getNome()+" agora está C"+existente.getConstelacoes()+".");return;} personagens.add(p);ConsoleIO.println(p.getNome()+" foi adicionada à sua coleção no nível 1!");}
 public void mostrarColecao(){ConsoleIO.println("\n===== PERSONAGENS =====");if(personagens.isEmpty()){ConsoleIO.println("Você ainda não possui personagens.");return;}for(int i=0;i<personagens.size();i++)ConsoleIO.println((i+1)+" - "+personagens.get(i));}
 public boolean estaVazia(){return personagens.isEmpty();} public int getQuantidade(){return personagens.size();} public Personagem getPersonagem(int i){return i<0||i>=personagens.size()?null:personagens.get(i);} public List<Personagem> getPersonagens(){return Collections.unmodifiableList(personagens);}
}
