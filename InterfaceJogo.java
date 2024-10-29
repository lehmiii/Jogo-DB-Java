import java.util.Random;
import java.util.Scanner;

public class InterfaceJogo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            
            System.out.println("Digite o seu nome:");
            String nomeJogador = scanner.nextLine();
            
            System.out.println("Escolha seu lado:");
            System.out.println("1 para Vegeta");
            System.out.println("2 para Goku");
            int escolhaLado = scanner.nextInt();
            Forca jogador = null;
            
            if (escolhaLado == 1) {
                System.out.println("Escolha sua classe Vegeta:");
                System.out.println("1 para ser Oozaru");
                System.out.println("2 para ser Super Vegeta");
                System.out.println("3 para ser Majin Vegeta");
                int escolhaClasse = scanner.nextInt();
                switch (escolhaClasse) {
                    case 1 -> jogador = new Oozaru(nomeJogador);
                    case 2 -> jogador = new SuperVegeta(nomeJogador);
                    case 3 -> jogador = new MajinVegeta(nomeJogador);
                }
            } else {
                System.out.println("Escolha sua classe Goku:");
                System.out.println("1 para ser Saiyajin");
                System.out.println("2 para ser Super Saiyajin");
                System.out.println("3 para ser Super Saiyajin 2");
                int escolhaClasse = scanner.nextInt();
                switch (escolhaClasse) {
                    case 1 -> jogador = new Saiyajin(nomeJogador);
                    case 2 -> jogador = new SuperSaiyajin(nomeJogador);
                    case 3 -> jogador = new SuperSaiyajin2(nomeJogador);
                }
            } 
            
            Goku oponente = new SuperSaiyajin("Majinn Boo");
            
            System.out.println("Batalha entre " + jogador.nome + " e " + oponente.nome + " começou!");
            
            while (jogador.estaVivo() && oponente.estaVivo()) {
                System.out.println("\nEscolha:");
                System.out.println("1 para Atacar");
                System.out.println("2 para Curar");
                System.out.println("3 para Usar Kamehameha");
                
                int escolhaAcao = scanner.nextInt();
                
                switch (escolhaAcao) {
                    case 1 -> jogador.atacar(oponente);
                    case 2 -> jogador.curar();
                    case 3 -> {
                        if (jogador instanceof Goku) {
                            ((Goku) jogador).usarKamehameha(oponente);
                        } else {
                            System.out.println("So Goku pode usar Kamehameha!");
                        }
                    }
                    default -> System.out.println("Escolha invalida!");
                }
                
                if (oponente.estaVivo()) {
                    if (random.nextInt(3) == 0 && oponente instanceof Goku) {
                        ((Goku) oponente).usarKamehameha(jogador);
                    } else {
                        oponente.atacar(jogador);
                    }
                }

                System.out.println("\nVida de " + jogador.nome + ": " + jogador.getVida());
                System.out.println("Vida de " + oponente.nome + ": " + oponente.getVida());
            }
            
            if (jogador.estaVivo()) {
                System.out.println("\n" + jogador.nome + " venceu a batalha!");
            } else {
                System.out.println("\n" + oponente.nome + " venceu a batalha!");
            }
        }
    }
}
