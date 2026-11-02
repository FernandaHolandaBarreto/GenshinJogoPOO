package personagem;
public class Personagem {
 private String nomeDoPersonagem,raridade,contelacoes,sobre; private int nivel=1,constelacoes=0,talento=1; private String tipoArma="Espada"; private Arma armaEquipada; private String[] artefatos=new String[5];
 private AprimoramentoElemental aprimoramentoElemental; private Ultimate ultimate;
 public Personagem(String n,String r,String c,String s){nomeDoPersonagem=n;raridade=r;contelacoes=c;sobre=s;aprimoramentoElemental=new AprimoramentoElemental();ultimate=new Ultimate(); if(n.equals("Escoffier"))tipoArma="Lança";}
 public String getNomeDoPersonagem(){return nomeDoPersonagem;} public String getNome(){return nomeDoPersonagem;} public String getRaridade(){return raridade;} public String getContelacoes(){return "C"+constelacoes;} public String getSobre(){return sobre;} public int getNivel(){return nivel;} public int getTalento(){return talento;} public int getConstelacoes(){return constelacoes;} public String getTipoArma(){return tipoArma;} public Arma getArmaEquipada(){return armaEquipada;} public String[] getArtefatos(){return artefatos.clone();}
 public void setNomeDoPersonagem(String s){nomeDoPersonagem=s;} public void setRaridade(String s){raridade=s;} public void setContelacoes(String s){contelacoes=s;} public void setSobre(String s){sobre=s;} public AprimoramentoElemental getAprimoramentoElemental(){return aprimoramentoElemental;} public void setAprimoramentoElemental(AprimoramentoElemental a){aprimoramentoElemental=a;} public Ultimate getUltimate(){return ultimate;} public void setUltimate(Ultimate u){ultimate=u;}
 public void usarHabilidade(Habilidades habilidade, String acao){ if(habilidade != null) habilidade.executar(acao); }
 public void equiparArma(Arma a){if(a!=null&&a.getTipoDeArma().equalsIgnoreCase(tipoArma))armaEquipada=a;} public void equiparArtefato(int pos,String nome){if(pos>=0&&pos<5)artefatos[pos]=nome;}
 public void adicionarConstelacao(){if(constelacoes<6)constelacoes++;}
 public void subirNivel(int novo){nivel=novo; talento=switch(novo){case 20->2;case 40->4;case 50->6;case 70->8;case 80->9;case 90->10;default->talento;};}
 @Override public String toString(){return nomeDoPersonagem+" | "+raridade+" | Nv. "+nivel+" | C"+constelacoes+" | Talento "+talento;}
}
