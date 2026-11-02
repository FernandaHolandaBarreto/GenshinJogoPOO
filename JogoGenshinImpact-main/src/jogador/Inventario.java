package jogador;
import java.util.*;

// Inventário acumulável: materiais, armas e artefatos são guardados por nome. //
public class Inventario {
    private final Map<String,Integer> itens = new LinkedHashMap<>();
    public void adicionar(String nome, int quantidade) { if (nome != null && quantidade > 0) itens.merge(nome, quantidade, Integer::sum); }
    public int quantidade(String nome) { return itens.getOrDefault(nome, 0); }
    public boolean tem(String nome, int quantidade) { return quantidade(nome) >= quantidade; }
    public boolean consumir(String nome, int quantidade) { if (!tem(nome, quantidade)) return false; int novo=quantidade(nome)-quantidade; if(novo==0) itens.remove(nome); else itens.put(nome,novo); return true; }
    public void mostrar() { System.out.println("\n===== INVENTÁRIO ====="); if(itens.isEmpty()) System.out.println("Seu inventário está vazio."); else itens.forEach((n,q)->System.out.println(n+": "+q)); }
    public Map<String,Integer> getItens() { return Collections.unmodifiableMap(itens); }
}
