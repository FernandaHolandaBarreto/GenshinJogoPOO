package util;

import java.util.Scanner;

/** Entrada e saída compartilhadas pelas classes do projeto. */
public final class ConsoleIO {
    private static final Scanner scanner = new Scanner(System.in);
    private ConsoleIO() { }
    public static void println(Object mensagem) { System.out.println(mensagem); }
    public static String readln(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
}
