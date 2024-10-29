import java.util.Random;

public abstract class Forca {
    protected int forca;
    protected int vida;
    protected String genero;
    protected String nome;

    public Forca(String nome, String genero, int vida) {
        this.nome = nome;
        this.genero = genero;
        this.vida = vida;
    }

    public abstract void atacar(Forca adversario);

    public int getVida() {
        return vida;
    }

    public void curar() {
        Random random = new Random();
        int cura = random.nextInt(20) + 10;
        this.vida += cura;
        System.out.println(this.nome + " foi curado em " + cura + " pontos de vida!");
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }
}
