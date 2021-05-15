package quiz_v3;

public class PerguntaMultiplaEscolha extends Pergunta {

    private static final int N_PERGUNTAS = 10;
    private final String[] perguntas = new String[getQtdPerguntas()];
    private final String[] respostas = new String[N_PERGUNTAS];
    
    
    //Construtor:
    public PerguntaMultiplaEscolha() {
        super(N_PERGUNTAS);
        definirPerguntas();
    }

    //getter
    public String[] getPerguntas() {
        return perguntas;
    }

    public String[] getRespostas() {
        return respostas;
    }
       
    //Principal:
    @Override
    public void definirPerguntas() {
        perguntas[0] = "Que cor as bananas tem quando madura?\n"
                + "a) Verde\n"
                + "b) Amarelo\n"
                + "c) Rosa\n"
                + "d) RGB\n";
        respostas[0] = "b";

        perguntas[1] = "Qual a cor da laranja?\n"
                + "a) verde\n"
                + "b) azul\n"
                + "c) amarelo\n"
                + "d) laranja\n";
        respostas[1] = "d";
        
    }

    @Override
    public void checarResposta(int numeroPergunta, String resposta, Player jogador) {
        if (respostas[numeroPergunta].equals(resposta.toLowerCase().trim())) {
            jogador.adicionaPontos();
        } else {
            jogador.retiraPontos();
        }
    }

    @Override
    public void executarPergunta(int numero, Player jogador) {
        
        System.out.print(getPerguntas()[numero]);
        String resposta = super.getTecla().nextLine().toLowerCase().trim();
        while (verificar(resposta)) {
            System.out.println("");
            System.out.println("Resposta Invalida! Digite somente uma das alternativas listada.");
            System.out.println(getPerguntas()[numero]);
            resposta = super.getTecla().nextLine().toLowerCase().trim();
        }
        System.out.println("");

        checarResposta(numero, resposta, jogador);   
    }
   

}