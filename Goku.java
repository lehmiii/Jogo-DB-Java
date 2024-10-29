import java.util.Random;

public abstract class Goku extends Forca implements Kamehameha {
    public Goku(String nome, int vida) {
        super(nome, "Goku", vida);
    }

    @Override
    public void atacar(Forca adversario) {
        Random random = new Random();
        int dano = random.nextInt(25) + 15;
        adversario.vida -= dano;
        System.out.println(this.nome + " atacou " + adversario.nome + " causando " + dano + " de dano!");
    }

    @Override
    public void usarKamehameha(Forca adversario) {
        adversario.vida -= forcaExtra;
        System.out.println(this.nome + " usou um Kamehameha causando " + forcaExtra + " de dano!");
    }
}
