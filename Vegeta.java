import java.util.Random;

public abstract class Vegeta extends Forca {
    public Vegeta(String nome, int vida) {
        super(nome, "Vegeta", vida);
    }

    @Override
    public void atacar(Forca adversario) {
        Random random = new Random();
        int dano = random.nextInt(20) + 10;
        adversario.vida -= dano;
        System.out.println(this.nome + " atacou " + adversario.nome + " causando " + dano + " de dano!");
    }
}
