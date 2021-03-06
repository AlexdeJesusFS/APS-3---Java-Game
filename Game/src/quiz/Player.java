package quiz;

public class Player {

    //Atributos:
    private String nome;
    private int pontuacao;

    //Construtor:
    public Player() {
        setNome("Jogador(a)");
        setPontuacao(0);
    }

    public Player(String nome) {
        setNome(nome);
        setPontuacao(0);
    }

    //Principal:
    public void adicionaPontos(int pontos) {
        setPontuacao(getPontuacao() + pontos);
    }

    public void retiraPontos(int pontos) {
        setPontuacao(getPontuacao() - pontos);
    }

    public void defineResultado() {
        System.out.println("Sua pontuacao foi de " + getPontuacao() + " pontos.");
        if (getPontuacao() < 0) {
            System.out.println(nome + ", seu resultado é pior do que jamais esperávamos, não ouse nem sair de casa você é um risco.");
        } else if (getPontuacao() >= 0 && getPontuacao() <= 30) {
            System.out.println("Seu resultado foi mediano " + nome + ", ainda há muitas coisas para aprender sobre a natureza.");
        } else if (getPontuacao() > 30 && getPontuacao() != 100) {
            System.out.println("Ótimo resultado " + nome + ", cometeu alguns erros, mas está muito bem em seus conhecimentos sobre a natureza.");
        } else {
            System.out.println("Muito bem, meus parábens, " + nome + ", você é incrível não há nada para ser ensinado a você aqui.");
        }
    }

    //Geters & Seters 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
