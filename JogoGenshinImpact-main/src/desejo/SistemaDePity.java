package desejo;

import util.ConsoleIO;

import personagem.ColecaoPersonagens;
import personagem.Personagem;
import java.util.Random;

public class SistemaDePity {
    private int pity = 0;
    private int pity4 = 0;
    private boolean garantido = false;
    private final Random random = new Random();

    private final String[] recompensas4 = {
        "Personagem 4 estrelas: Fischl", "Personagem 4 estrelas: Xingqiu",
        "Personagem 4 estrelas: Bennett", "Personagem 4 estrelas: Xiangling",
        "Arma 4 estrelas: Espada de Favonius", "Arma 4 estrelas: Arco de Favonius",
        "Arma 4 estrelas: Espada Sacrificial", "Arma 4 estrelas: Lança de Favonius"
    };
    private final String[] recompensas3 = {
        "Arma 3 estrelas: Espada do Viajante", "Arma 3 estrelas: Arco do Corvo",
        "Arma 3 estrelas: Histórias Extraordinárias", "Arma 3 estrelas: Grande Espada de Ferro Branco"
    };

    public void invocar(Personagem limitado, Personagem[] padrao, ColecaoPersonagens colecao) {
        pity++;
        pity4++;
        double chance5 = pity < 75 ? 0.6 : Math.min(100, 0.6 + (pity - 74) * 6);
        ConsoleIO.println("\n===== RESULTADO DO GIRO =====");

        if (pity >= 90 || random.nextDouble() * 100 < chance5) {
            int pityObtido = pity;
            Personagem sorteado;
            if (garantido || random.nextInt(100) < 50) {
                sorteado = limitado;
                garantido = false;
                ConsoleIO.println("PARABÉNS! Você ganhou o personagem limitado!");
            } else {
                sorteado = padrao[random.nextInt(padrao.length)];
                garantido = true;
                ConsoleIO.println("Você perdeu o 50/50! O próximo 5 estrelas será o limitado.");
            }
            ConsoleIO.println("Você ganhou: " + sorteado.getNomeDoPersonagem());
            ConsoleIO.println("Veio no pity " + pityObtido + ".");
            colecao.adicionarPersonagem(sorteado);
            pity = 0;
            pity4 = 0;
        } else if (pity4 >= 10 || random.nextDouble() * 100 < 5.1) {
            String recompensa = recompensas4[random.nextInt(recompensas4.length)];
            ConsoleIO.println("Você ganhou: " + recompensa);
            pity4 = 0;
        } else {
            ConsoleIO.println("Você ganhou: " + recompensas3[random.nextInt(recompensas3.length)]);
        }
        ConsoleIO.println("------------------------------");
        ConsoleIO.println("Pity 5 estrelas: " + pity + "/90");
        ConsoleIO.println("Pity 4 estrelas: " + pity4 + "/10");
        ConsoleIO.println("Garantido: " + (garantido ? "SIM" : "NÃO"));
    }
}
