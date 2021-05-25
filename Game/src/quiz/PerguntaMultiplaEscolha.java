package quiz;

public class PerguntaMultiplaEscolha extends Pergunta {

    private static final int N_PERGUNTAS = 5;
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
        perguntas[0] = "O meio ambiente é o conjunto de que fatores que influenciam a vida dos seres vivos na Terra?\n"
                + "a)fauna e flora.\n"
                + "b)fatores físicos, biológicos e químicos.\n"
                + "c)biomassa e biomas.\n"
                + "d)regiões afetadas.\n"
                + "e)animais.\n";
        respostas[0] = "b";

        perguntas[1] = "Qual o principal gás responsavel pelo efeito estufa? \n"
                + "a)Dióxido de Enxofre.\n"
                + "b)Gás lacrimogêneo.\n"
                + "c)Gás carboro.\n"
                + "d)Dióxido de carbono.\n"
                + "e)Óxido de nitrogênio.\n";
        respostas[1] = "d";

        perguntas[2] = "Através da fotossintese as plantas produzem e armazenam seu próprio alimento, a ...\n"
                + "Complete a frase:\n"
                + "a)Sacarose\n"
                + "b)Glicose\n"
                + "c)Sucralose\n"
                + "d)Sacarine\n"
                + "e)Mudilose\n";
        respostas[2] = "b";
        
        perguntas[3] = "Qual das empresa a seguir é a mais poluente?\n"
                + "a)Coca-Cola\n"
                + "b)PepsiCo\n"
                + "c)Nestlé\n"
                + "d)Unilever\n"
                + "e)P&G\n";
        respostas[3] = "a";
        
        perguntas[4] = "Apesar dos comercias de ursos polares felizes a Coca-Cola causa um mal aos nossos amigos brancos.\n"
                + "O texto acima se refere a(ao): \n"
                + "a)Quebra da camada de ozônio\n"
                + "b)Aquecimento global\n"
                + "c)Dano nos lençois freáticos\n"
                + "d)Destruição do clima\n"
                + "e)Uso abosivo de suas imagens sendo que os ursos não são pagos\n";
        respostas[4] = "b";
    }

    @Override
    public void checarResposta(int numeroPergunta, String resposta, Player jogador) {
        if (respostas[numeroPergunta].equals(resposta.toLowerCase().trim())) {
            jogador.adicionaPontos(10);
        } else {
            jogador.retiraPontos(10);
        }
    }

    @Override
    public void executarPergunta(int numero, Player jogador) {
        String resposta = null;
        try {
            System.out.print(getPerguntas()[numero]);
            System.out.print("Resposta: ");
            resposta = super.getTecla().nextLine().toLowerCase().trim();            
            verificarErro(resposta, 'm');
            System.out.println("");
        } catch (RespostaInvalidaException ex) {
            System.out.println("");
            System.out.println(ex.getMessage());
            executarPergunta(numero, jogador);
        }
        checarResposta(numero, resposta, jogador);
    }

}
