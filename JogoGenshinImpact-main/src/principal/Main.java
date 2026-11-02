package principal;

import util.ConsoleIO;

import desejo.SistemaDePity;
import jogador.Jogador;
import personagem.Personagem;
import personagem.ColecaoPersonagens;
import jogabilidade.GuiaDeAventureiro;
import jogabilidade.Mapa;
import sistemas.ConteudoExtra;

public class Main {
    public static void main(String[] args) {
        ConsoleIO.println("================================");
        ConsoleIO.println("       AVENTURA DA VIAJANTE");
        ConsoleIO.println("================================");
        ConsoleIO.println("Iniciando sua jornada...\n");

        String escolhaPersonagem;
        do {
            ConsoleIO.println("Escolha seu personagem:");
            ConsoleIO.println("1 - Lumine");
            ConsoleIO.println("2 - Aether");
            escolhaPersonagem = ConsoleIO.readln("Digite sua escolha: ");
            if (!escolhaPersonagem.equals("1") && !escolhaPersonagem.equals("2")) ConsoleIO.println("Opção inválida!");
        } while (!escolhaPersonagem.equals("1") && !escolhaPersonagem.equals("2"));

        String viajante = escolhaPersonagem.equals("1") ? "Lumine" : "Aether";
        String nomeJogador = ConsoleIO.readln("Digite seu nome: ");
        Jogador jogador = new Jogador(nomeJogador, viajante);
        ColecaoPersonagens colecao = new ColecaoPersonagens();
        SistemaDePity sistema = new SistemaDePity();
        ConteudoExtra extra = new ConteudoExtra();
        GuiaDeAventureiro guia = new GuiaDeAventureiro(extra);
        Mapa mapa = new Mapa();

        Personagem[] personagensPadrao = {
            new Personagem("Mona", "5 estrelas", "C0", "Hydro padrão"),
            new Personagem("Jean", "5 estrelas", "C0", "Anemo padrão"),
            new Personagem("Diluc", "5 estrelas", "C0", "Pyro padrão"),
            new Personagem("Qiqi", "5 estrelas", "C0", "Cryo padrão"),
            new Personagem("Dehya", "5 estrelas", "C0", "Pyro padrão"),
            new Personagem("Mizuki", "5 estrelas", "C0", "Anemo padrão"),
            new Personagem("Keqing", "5 estrelas", "C0", "Electro padrão")
        };
        Personagem skirk = new Personagem("Skirk", "5 estrelas", "C0", "Cryo limitada");
        Personagem escoffier = new Personagem("Escoffier", "5 estrelas", "C0", "Cryo limitada");

        ConsoleIO.println("\nBem-vindo(a), " + jogador.getNome() + "!");
        ConsoleIO.println("Você escolheu viajar com " + viajante + ".");
        String opcao;
        do {
            ConsoleIO.println("\n========== MENU PRINCIPAL ==========");
            ConsoleIO.println("Gemas: " + jogador.getGemas() + " | Desejos: " + jogador.getDesejos() + " | Mora: " + jogador.getMora() + " | Vida: " + jogador.getVida() + "/12.000");
            ConsoleIO.println("1 - Inventário");
            ConsoleIO.println("2 - Guia de Aventureiro");
            ConsoleIO.println("3 - Desejos");
            ConsoleIO.println("4 - Personagens");
            ConsoleIO.println("5 - Mapa");
            ConsoleIO.println("6 - Eventos");
            ConsoleIO.println("7 - Banner de armas");
            ConsoleIO.println("0 - Sair");
            opcao = ConsoleIO.readln("Escolha: ");
            switch (opcao) {
                case "1" -> {
                    ConsoleIO.println("\n===== INVENTÁRIO =====");
                    ConsoleIO.println("Gemas: " + jogador.getGemas());
                    ConsoleIO.println("Desejos disponíveis: " + jogador.getDesejos());
                    ConsoleIO.println("Mora: " + jogador.getMora());
                    jogador.getInventario().mostrar();
                }
                case "2" -> guia.abrir(jogador, colecao);
                case "3" -> menuDesejos(jogador, sistema, personagensPadrao, skirk, escoffier, colecao);
                case "4" -> extra.personagens(jogador, colecao);
                case "5" -> mapa.abrir(jogador);
                case "6" -> extra.eventos(jogador);
                case "7" -> extra.bannerArmas(jogador);
                case "0" -> ConsoleIO.println("Encerrando sua jornada...");
                default -> ConsoleIO.println("Opção inválida!");
            }
        } while (!opcao.equals("0") && jogador.getVida() > 0 && !mapa.jornadaConcluida());
        if (jogador.getVida() <= 0) {
            ConsoleIO.println("\n===== FIM DE JOGO =====");
            ConsoleIO.println("Você ficou sem vida durante a aventura. Sua jornada terminou em derrota.");
        } else if (mapa.jornadaConcluida()) {
            ConsoleIO.println("\n===== VITÓRIA! =====");
            ConsoleIO.println("Parabéns, " + jogador.getNome() + "! Você explorou todas as regiões e concluiu sua jornada por Teyvat.");
        }
        ConsoleIO.println("Até a próxima, " + jogador.getNome() + "!");
    }

    private static void menuDesejos(Jogador jogador, SistemaDePity sistema, Personagem[] padrao,
                                    Personagem skirk, Personagem escoffier, ColecaoPersonagens colecao) {
        String banner;
        do {
            ConsoleIO.println("\n===== BANNERS LIMITADOS =====");
            ConsoleIO.println("1 - Skirk");
            ConsoleIO.println("2 - Escoffier");
            ConsoleIO.println("0 - Voltar");
            banner = ConsoleIO.readln("Escolha o banner: ");
            Personagem limitado = banner.equals("1") ? skirk : banner.equals("2") ? escoffier : null;
            if (limitado != null) {
                String giros;
                do {
                    ConsoleIO.println("\nBanner: " + limitado.getNomeDoPersonagem());
                    ConsoleIO.println("Gemas: " + jogador.getGemas() + " | Desejos: " + jogador.getDesejos() + " | Mora: " + jogador.getMora() + " | Vida: " + jogador.getVida() + "/12.000");
                    ConsoleIO.println("1 - Fazer 1 giro");
                    ConsoleIO.println("2 - Fazer 10 giros");
                    ConsoleIO.println("0 - Voltar aos banners");
                    giros = ConsoleIO.readln("Escolha: ");
                    int quantidade = giros.equals("1") ? 1 : giros.equals("2") ? 10 : 0;
                    if (quantidade > 0) {
                        for (int i = 1; i <= quantidade; i++) {
                            if (!jogador.consumirDesejo()) {
                                ConsoleIO.println("Você não tem gemas ou desejos suficientes. São necessários 160 gemas por giro.");
                                break;
                            }
                            ConsoleIO.println("\n--- Giro " + i + " ---");
                            sistema.invocar(limitado, padrao, colecao);
                        }
                    } else if (!giros.equals("0")) ConsoleIO.println("Opção inválida!");
                } while (!giros.equals("0"));
            } else if (!banner.equals("0")) ConsoleIO.println("Opção inválida!");
        } while (!banner.equals("0"));
    }
}
