package quiz;

public class PerguntaSN extends Pergunta {

    //atributos
    private static final int N_PERGUNTAS = 3;
    private final String[] perguntas = new String[N_PERGUNTAS];
    private String[] respostas = new String[N_PERGUNTAS];

    public PerguntaSN() {
        super(N_PERGUNTAS);
        definirPerguntas();
    }

    //metodos principais
    public void definirPerguntas() {
        perguntas[0] = "O efeito estufa é um evento decorrente da quebra da camada de ozônio?";
        respostas[0] = "n";

        perguntas[1] = "A partir do lixo orgânico é possivel produzir energia elétrica?";
        respostas[1] = "s";

        perguntas[2] = "A floresta amazônica, a maior floresta tropical do mundo, nunca sofreu queimadas e quase não sofre com desmatamento ilegal.\n"
                + "essa frase está correta?";
        respostas[2] = "n";
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
    public boolean verificar(String resposta) {
        return (resposta != null && resposta.matches("s|n") && resposta != "");
    }

    public void executarPergunta(int numero, Player jogador) {
        String resposta = null;
        try {
            System.out.println(getPerguntas()[numero]);
            System.out.println("Responda com [s] para sim e [n] para não.");
            System.out.print("Resposta: ");
            resposta = super.getTecla().nextLine().toLowerCase().trim();
            verificarErro(resposta, 's');
            System.out.println("");
        } catch (RespostaInvalidaException ex) {
            System.out.println("");
            System.out.println(ex.getMessage());
            executarPergunta(numero, jogador);
        }
        checarResposta(numero, resposta, jogador);
    }

    //getters
    public static int getNumeroPerguntas() {
        return N_PERGUNTAS;
    }

    public String[] getPerguntas() {
        return perguntas;
    }

    public String[] getRespostas() {
        return respostas;
    }

}
