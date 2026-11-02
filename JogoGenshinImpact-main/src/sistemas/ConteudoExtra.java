package sistemas;

import util.ConsoleIO;
import jogador.Jogador;
import jogador.Inventario;
import personagem.*;

import java.util.*;

/** Sistemas de monstros, coleta, ascensão, armas, domínios e eventos. */
public class ConteudoExtra {
 private final Set<String> eventosFeitos=new HashSet<>(); private final Map<String,Integer> monstros=new LinkedHashMap<>(); private final Random random=new Random();
 private int pityArma=0; private boolean armaGarantida=false; private final List<Arma> armas=new ArrayList<>();
 private final String[] nomesArtefatos={"Coroa","Pena","Flor","Cálice","Ampulheta"};
 public void guiaMonstros(Jogador j){monstros(j);} public void guiaEspecialidades(Jogador j){especialidades(j);} public void guiaDominios(Jogador j){dominios(j);} public void guiaMissoes(Jogador j){missoes(j);}
 public void guia(Jogador j,ColecaoPersonagens c){String op;do{ConsoleIO.println("\n===== GUIA DO AVENTUREIRO =====\n1 - Monstros\n2 - Especialidade local\n3 - Domínios\n4 - Missões\n0 - Voltar");op=ConsoleIO.readln("Escolha: ");switch(op){case "1"->monstros(j);case "2"->especialidades(j);case "3"->dominios(j);case "4"->missoes(j);case "0"->{}default->ConsoleIO.println("Opção inválida.");}}while(!op.equals("0"));}
 private void monstros(Jogador j){
  String[] m={"Mecaniquilador","Olhar Emaranhador","Acumulador de Ventilação da Fonte Secreta","Mecacoletor"};
  String op;
  do{
   ConsoleIO.println("\n===== MONSTROS =====");
   for(int i=0;i<4;i++) ConsoleIO.println((i+1)+" - "+m[i]+" (derrotas: "+monstros.getOrDefault(m[i],0)+")");
   ConsoleIO.println("0 - Voltar"); op=ConsoleIO.readln("Escolha o monstro: ");
   try{
    int n=Integer.parseInt(op); if(n==0) continue; if(n<1||n>4) continue;
    String nome=m[n-1]; ConsoleIO.println("1 - Enfrentar\n0 - Sair");
    if(ConsoleIO.readln("Escolha: ").equals("1")){
     if(j.getVida()<1000){ConsoleIO.println("Vida insuficiente. Vá à Estátua dos Sete recuperar.");continue;}
     j.perderVida(1000); monstros.merge(nome,1,Integer::sum); Inventario inv=j.getInventario();
     // Todos os monstros fornecem engrenagens dos três níveis, para permitir as ascensões.
     inv.adicionar("Engrenagem Transmissora",5);
     inv.adicionar("Engrenagem Reta",5);
     inv.adicionar("Engrenagem Dinâmica",5);
     inv.adicionar("Engrenagem Dinâmica Artificiosa",5);
     // Materiais de Jade: a Lasca é necessária na primeira ascensão da Skirk.
     // Os demais graus também são acumulados para as próximas ascensões.
     inv.adicionar("Lasca de Jade Shivada", 3);
     inv.adicionar("Fragmento de Jade Shivada", 3);
     inv.adicionar("Pedaço de Jade Shivada", 3);
     inv.adicionar("Gema de Jade Shivada", 3);

     // Materiais dos chefes acumulados para as ascensões.
     inv.adicionar("Olhar Emaranhador", 3);
     inv.adicionar("Acumulador de Fluxo da Fonte Secreta",3);
     j.adicionarMora(80000);
     ConsoleIO.println("Vitória! Você recebeu 5 unidades de cada tipo de engrenagem, 3 unidades de cada grau de Jade Shivada, 3 Olhares Emaranhadores, 3 Acumuladores de Fluxo da Fonte Secreta e 80.000 Mora.");
     ConsoleIO.println("Você perdeu 1.000 de vida. Vida: "+j.getVida()+"/12.000");
    }
   }catch(NumberFormatException e){if(!op.equals("0"))ConsoleIO.println("Digite uma opção válida.");}
  }while(!op.equals("0"));
 }
 private void especialidades(Jogador j){String op;do{ConsoleIO.println("\n===== ESPECIALIDADE LOCAL =====\n1 - Concha de Cristal Azul\n2 - Florgema Celeste\n0 - Voltar");op=ConsoleIO.readln("Escolha: ");String nome=op.equals("1")?"Concha de Cristal Azul":"Florgema Celeste",regiao=op.equals("1")?"Fontaine":"Natlan";if(op.equals("1")||op.equals("2")){ConsoleIO.println("1 - Ir para "+regiao+" coletar\n0 - Sair");if(ConsoleIO.readln("Escolha: ").equals("1")){j.getInventario().adicionar(nome,46);ConsoleIO.println("Coleta concluída! Você recebeu 46 "+nome+".");}}}while(!op.equals("0"));}
 private void dominios(Jogador j){String op;do{ConsoleIO.println("\n===== DOMÍNIOS =====\n1 - Epílogo do Corredor (Skirk)\n2 - Trupe Dourada (Escoffier)\n0 - Voltar");op=ConsoleIO.readln("Escolha: ");if(op.equals("1")||op.equals("2")){String set=op.equals("1")?"Epílogo do Corredor":"Trupe Dourada";ConsoleIO.println("1 - Farmar artefatos\n0 - Sair");if(ConsoleIO.readln("Escolha: ").equals("1")){for(String p:nomesArtefatos)j.getInventario().adicionar(""+p+" - "+set,1);ConsoleIO.println("Você recebeu 5 artefatos do conjunto "+set+".");}}}while(!op.equals("0"));}
 private void missoes(Jogador j){ConsoleIO.println("\n===== MISSÕES =====\n1 - Completar missão\n0 - Sair");if(ConsoleIO.readln("Escolha: ").equals("1")){j.adicionarDesejos(1);j.adicionarMora(500000);ConsoleIO.println("Missão concluída! Você ganhou 1 desejo e 500.000 Mora.");}}
 public void eventos(Jogador j){
  List<jogabilidade.Eventos> lista = List.of(new jogabilidade.EventoTestePersonagem(), new jogabilidade.EventoExploracao(), new jogabilidade.EventoPrincipal(), new jogabilidade.EventoSecundario());
  String op;
  do {
   ConsoleIO.println("\n===== EVENTOS =====");
   for(int i=0;i<lista.size();i++){String nome=lista.get(i).getNomeDoEvento();ConsoleIO.println((i+1)+" - "+lista.get(i)+(eventosFeitos.contains(nome)?" (concluído)":""));}
   ConsoleIO.println("0 - Voltar"); op=ConsoleIO.readln("Escolha: ");
   try { int n=Integer.parseInt(op); if(n==0) continue; if(n<1||n>lista.size()){ConsoleIO.println("Opção inválida.");continue;}
    jogabilidade.Eventos evento=lista.get(n-1); String nome=evento.getNomeDoEvento();
    if(eventosFeitos.contains(nome)){ConsoleIO.println("Você já recebeu essa recompensa.");continue;}
    if(ConsoleIO.readln("Participar deste evento? (1 - Sim / 0 - Não): ").equals("1")){
     evento.executar(j); eventosFeitos.add(nome); ConsoleIO.println("Você recebeu "+evento.getRecompensaEmGemas()+" gemas!");
    }
   } catch(NumberFormatException e){if(!op.equals("0"))ConsoleIO.println("Opção inválida.");}
  } while(!op.equals("0"));
 }
 public void personagens(Jogador j,ColecaoPersonagens c){if(c.estaVazia()){ConsoleIO.println("Você ainda não possui personagens.");return;}String op;do{c.mostrarColecao();ConsoleIO.println("0 - Voltar");op=ConsoleIO.readln("Selecione um personagem: ");try{int i=Integer.parseInt(op)-1;if(op.equals("0"))continue;Personagem p=c.getPersonagem(i);if(p==null)continue;gerenciarPersonagem(j,p);}catch(NumberFormatException e){ConsoleIO.println("Opção inválida.");}}while(!op.equals("0"));}
 private void gerenciarPersonagem(Jogador j,Personagem p){String op;do{ConsoleIO.println("\n"+p+"\nArma: "+(p.getArmaEquipada()==null?"Nenhuma":p.getArmaEquipada().getSobreArma())+"\n1 - Ascender nível\n2 - Equipar arma\n3 - Equipar artefatos\n4 - Usar habilidade\n0 - Voltar");op=ConsoleIO.readln("Escolha: ");switch(op){case "1"->ascender(j,p);case "2"->equiparArma(j,p);case "3"->equiparArtefatos(j,p);case "4"->usarHabilidade(p);case "0"->{}default->ConsoleIO.println("Opção inválida.");}}while(!op.equals("0"));}
 private void usarHabilidade(Personagem personagem){
  ConsoleIO.println("1 - Habilidade elemental\n2 - Supremo\n0 - Voltar");
  String escolha=ConsoleIO.readln("Escolha: ");
  // A variável usa o tipo da interface; cada implementação executa sua própria versão.
  personagem.usarHabilidade(escolha.equals("1")?personagem.getAprimoramentoElemental():escolha.equals("2")?personagem.getUltimate():null,
      escolha.equals("1")?"Habilidade elemental de "+personagem.getNome():"Supremo de "+personagem.getNome());
  if(!escolha.equals("0")&&!escolha.equals("1")&&!escolha.equals("2"))ConsoleIO.println("Opção inválida.");
 }
 private void ascender(Jogador j,Personagem p){int atual=p.getNivel(),proximo=switch(atual){case 1->20;case 20->40;case 40->50;case 50->60;case 60->70;case 70->80;case 80->90;default->90;};if(atual==90){ConsoleIO.println("Personagem já está no nível máximo.");return;}String jade=proximo<=20?"Lasca de Jade Shivada":proximo<=50?"Fragmento de Jade Shivada":proximo<=80?"Pedaço de Jade Shivada":"Gema de Jade Shivada";int qJ=proximo<=20?1:proximo==40?3:proximo==50?6:proximo==60?3:proximo==70?6:6;String local=p.getNome().equals("Skirk")?"Florgema Celeste":"Concha de Cristal Azul";int qLocal=proximo<=20?3:proximo==40?10:proximo==50?20:proximo==60?30:proximo==70?45:60;String boss=p.getNome().equals("Skirk")?"Olhar Emaranhador":"Acumulador de Fluxo da Fonte Secreta";int qb=proximo<=20?0:proximo==40?2:proximo==50?4:proximo==60?8:proximo==70?12:20;String engr=proximo<=40?"Engrenagem Transmissora":proximo<=60?"Engrenagem Reta":(p.getNome().equals("Skirk") && proximo==80?"Engrenagem Dinâmica":"Engrenagem Dinâmica Artificiosa");int qe=proximo<=20?3:proximo==40?15:proximo==50?12:proximo==60?18:proximo==70?12:24;int mora=proximo<=20?20000:proximo==40?40000:proximo==50?60000:proximo==60?80000:proximo==70?100000:120000;
 // O pedido lista os custos de 80 e 90 iguais; aplica a etapa final apenas ao chegar a 90.
 Inventario inv=j.getInventario();if(!inv.tem(jade,qJ)||!inv.tem(local,qLocal)||(qb>0&&!inv.tem(boss,qb))||!inv.tem(engr,qe)||j.getMora()<mora){ConsoleIO.println("Materiais insuficientes. Necessário: "+qJ+" "+jade+", "+qLocal+" "+local+", "+qb+" "+boss+", "+qe+" "+engr+" e "+mora+" Mora.");return;}
 inv.consumir(jade,qJ);inv.consumir(local,qLocal);if(qb>0)inv.consumir(boss,qb);inv.consumir(engr,qe);j.gastarMora(mora);p.subirNivel(proximo);ConsoleIO.println("Ascensão concluída! "+p.getNome()+" chegou ao nível "+proximo+".");if(proximo==20)ConsoleIO.println("Seu talento foi para o 2!");if(proximo==40)ConsoleIO.println("Seu talento foi para o 4!");if(proximo==50)ConsoleIO.println("Seu talento foi para o 6!");if(proximo==70)ConsoleIO.println("Seu talento foi para o 8!");if(proximo==80)ConsoleIO.println("Seu talento foi para o 9!");if(proximo==90)ConsoleIO.println("Seu talento foi para 10 MAX!");if(proximo==20)inv.adicionar("Destino Adquirido",1);
 }
 private void equiparArma(Jogador j,Personagem p){ArrayList<String> nomes=new ArrayList<>();for(Arma a:armas)if(a.getTipoDeArma().equalsIgnoreCase(p.getTipoArma()))nomes.add(a.getSobreArma());if(nomes.isEmpty()){ConsoleIO.println("Você ainda não possui armas compatíveis. Confira o banner de armas.");return;}for(int i=0;i<nomes.size();i++)ConsoleIO.println((i+1)+" - "+nomes.get(i));try{int n=Integer.parseInt(ConsoleIO.readln("Escolha: "))-1;if(n>=0&&n<nomes.size())for(Arma a:armas)if(a.getSobreArma().equals(nomes.get(n)))p.equiparArma(a);}catch(Exception e){ConsoleIO.println("Opção inválida.");}}
 private void equiparArtefatos(Jogador j,Personagem p){String[] pecas={"Coroa","Pena","Flor","Cálice","Ampulheta"};for(int i=0;i<5;i++){ConsoleIO.println("Artefato "+pecas[i]+": ");String escolhido=null;for(String item:j.getInventario().getItens().keySet())if(item.startsWith(pecas[i]+" - ")){escolhido=item;break;}if(escolhido!=null){p.equiparArtefato(i,escolhido);ConsoleIO.println("Equipado: "+escolhido);}else ConsoleIO.println("Nenhum "+pecas[i]+" disponível.");}}
 public void bannerArmas(Jogador j){String op;do{ConsoleIO.println("\n===== BANNER DE ARMAS =====\n1 - Selecionar Azul Brilhante (Espada - Skirk)\n2 - Selecionar Sinfonista de Aromas (Lança - Escoffier)\n0 - Voltar");op=ConsoleIO.readln("Escolha a arma em destaque: ");if(op.equals("1")||op.equals("2")){String alvo=op.equals("1")?"Azul Brilhante":"Sinfonista de Aromas";String giros;do{ConsoleIO.println("\nArma selecionada: "+alvo+"\nPity compartilhado: "+pityArma+"/80 | Garantido: "+(armaGarantida?"SIM":"NÃO")+"\n1 - Fazer 1 desejo\n2 - Fazer 10 desejos\n0 - Trocar arma/voltar");giros=ConsoleIO.readln("Escolha: ");int qtd=giros.equals("1")?1:giros.equals("2")?10:0;for(int i=0;i<qtd;i++){if(!j.consumirDesejo()){ConsoleIO.println("Sem gemas ou desejos suficientes.");break;}pityArma++;boolean cinco=pityArma>=80||random.nextInt(100)<7;if(cinco){boolean venceu=armaGarantida||random.nextBoolean();if(venceu){Arma a=new Arma(alvo.equals("Azul Brilhante")?"Espada":"Lança","5 estrelas","Dano crítico",alvo);armas.add(a);j.getInventario().adicionar(alvo,1);ConsoleIO.println("Você ganhou "+alvo+"! Ela foi adicionada ao inventário e poderá ser equipada na personagem compatível.");armaGarantida=false;}else{String outra=alvo.equals("Azul Brilhante")?"Sinfonista de Aromas":"Azul Brilhante";Arma a=new Arma(outra.equals("Azul Brilhante")?"Espada":"Lança","5 estrelas","Dano crítico",outra);armas.add(a);j.getInventario().adicionar(outra,1);ConsoleIO.println("Você perdeu o destaque e recebeu "+outra+". O próximo 5 estrelas será "+alvo+".");armaGarantida=true;}pityArma=0;}else ConsoleIO.println("Você recebeu uma arma 3 ou 4 estrelas.");} }while(!giros.equals("0"));}else if(!op.equals("0"))ConsoleIO.println("Opção inválida.");}while(!op.equals("0"));}

}
