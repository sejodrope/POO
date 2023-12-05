package Principal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean rodar = true;
        int opcao;
        Scanner scan = new Scanner(System.in);
        int score = 0;

        while (rodar) {
            System.out.println("======== WORD GAME! ========");
            System.out.println("Opção 1: Adivinhar palavra");
            System.out.println("Opção 2: Ver Score");
            System.out.println("Opção 3: Encerrar");
            System.out.println("Digite sua opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            if (opcao == 1) {
                WordGame partida = new WordGame();
                long tempoInicio = System.currentTimeMillis();
                boolean tempoExcedido = false;

                while (!tempoExcedido) {
                    partida.gerarLetra();
                    partida.gerarListaDePalavras(partida.letra);
                    String palavra = scan.nextLine().toLowerCase();

                    if (System.currentTimeMillis() - tempoInicio >= 20000) {
                        tempoExcedido = true;
                        System.out.println("Tempo esgotado! Você retornará ao Menu Inicial.");
                    } else if (partida.palavrasComLetraAleatoria.contains(palavra) &&
                            !partida.palavrasDigitadas.contains(palavra) &&
                            palavra.length() >= 4) {
                        partida.palavrasDigitadas.add(palavra);
                        score += 1;
                        System.out.println("Palavra válida! +1 Ponto!");
                    } else {
                        System.out.println("Palavra inválida. Tente novamente ou tempo esgotará em breve.");
                    }
                }

                System.out.println("Sua pontuação atual é: " + score);
            }

            if (opcao == 2) {
                System.out.println("Sua pontuação é: " + score);
            }

            if (opcao == 3) {
                rodar = false;
            }
        }
    }
}