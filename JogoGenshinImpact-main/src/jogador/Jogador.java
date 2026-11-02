package jogador;
public class Jogador {
  private String nome, viajante; private int gemas,desejos,mora=0,vida=12000;
   private final Inventario inventario=new Inventario();

    public Jogador(String nome,String viajante){this.nome=nome;this.viajante=viajante;}
      public String getNome(){return nome;} public String getViajante(){return viajante;} public int getGemas(){return gemas;} public int getDesejos(){return desejos;} public int getMora(){return mora;} public int getVida(){return vida;} public Inventario getInventario(){return inventario;}
       public void adicionarGemas(int n){if(n>0)gemas+=n;} public void adicionarDesejos(int n){if(n>0)desejos+=n;} public void adicionarMora(int n){if(n>0)mora+=n;}
        public boolean gastarMora(int n){if(n<0||mora<n)return false;mora-=n;return true;}
         public void perderVida(int n){vida=Math.max(0,vida-n);} public void recuperarVida(){vida=12000;}
           public boolean consumirDesejo(){if(desejos>0){desejos--;return true;}if(gemas>=160){gemas-=160;return true;}return false;}
}
