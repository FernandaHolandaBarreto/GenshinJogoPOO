package jogabilidade;

import util.ConsoleIO;

import jogador.Jogador;

public class Missoes {
    private boolean concluidas = false;

    public void menu(Jogador jogador) {
        String opcao;
        do {
            ConsoleIO.println("\n===== MISSÕES DIÁRIAS =====");
            ConsoleIO.println("1 - Fazer missões diárias");
            ConsoleIO.println("2 - Missões concluídas");
            ConsoleIO.println("0 - Voltar");
            opcao = ConsoleIO.readln("Escolha: ");
            switch (opcao) {
                case "1" -> {
                    if (concluidas) ConsoleIO.println("Você já concluiu as missões diárias de hoje.");
                    else {
                        ConsoleIO.println("Você concluiu suas 4 comissões diárias!");
                        jogador.adicionarGemas(60);
                        concluidas = true;
                        ConsoleIO.println("Você recebeu 60 gemas.");
                    }
                }
                case "2" -> ConsoleIO.println(concluidas ? "Missões diárias concluídas!" : "Você ainda não concluiu as missões.");
                case "0" -> { }
                default -> ConsoleIO.println("Opção inválida!");
            }
        } while (!opcao.equals("0"));
    }
}
