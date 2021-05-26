package quiz;

public class PerguntaMultiplaEscolha extends Pergunta {

    private static final int N_PERGUNTAS = 15;
    private final String[] perguntas = new String[N_PERGUNTAS];
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
                + "b)fatores fisicos, biológicos e químicos.\n"
                + "c)biomassa e biomas.\n"
                + "d)regiões afetadas.\n"
                + "e)animais.\n";
        respostas[0] = "b";

        perguntas[1] = "Qual o principal gás responsavel pelo efeito estufa? \n"
                + "a)Dióxido de Enxofre.\n"
                + "b)Gás lacrimogêneo.\n"
                + "c)Dióxido de cargono.\n"
                + "d)Gás Carbônico.\n"
                + "e)Óxido de nitrogênio.\n";
        respostas[1] = "c";

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
                + "O texto acima se refere ao: \n"
                + "a)Quebra da camada de ozônio\n"
                + "b)Aquecimento global\n"
                + "c)Dano nos lençois freáticos\n"
                + "d)Destruição do clima\n"
                + "e)Uso abosivo de sua imagem sendo que os ursos não são pagos\n";
        respostas[4] = "b";
        
        perguntas[5] = "O estado brasileiro recordista em desmatamento na Amazônia é:\n"
                + "a)Roraima\n"
                + "b)Rondônia\n"
                + "c)Acre\n"
                + "d)Pará\n"
                + "e)Mato Grosso\n";
        respostas[5] = "d";
        
        perguntas[6] = "O lixo que o Brasil produz se dividem em:\n"
                + "a)lixo hospitalar\n"
                + "b)lixo orgânico\n"
                + "c)lixo recíclavel\n"
                + "d)lixo orgânico, recíclavel e não recíclavel\n"
                + "e)lixo biológico\n";
        respostas[6] = "d";
        
        perguntas[7] = "O lixo orgânico é de origem biológica, e são exemplos: \n"
                + "a)papel\n"
                + "b)vidro\n"
                + "c)metal\n"
                + "d)isopor e sacolas plásticas\n"
                + "e)resíduos de alimentos, dejetos humanos, cascas e sementes\n";
        respostas[7] = "e";
        
        perguntas[8] = " Atráves da fotossínteseas as plantas produzem e armazenam seu própio alimento a:\n"
                + "a)sacarose\n"
                + "b)glicose\n"
                + "c)sucralose\n"
                + "d)sacarina\n"
                + "e)estévia\n";
        respostas[8] = "b";
        
        perguntas[9] = "A mistura de gases produzida apartir da decomposição de lixo orgânico é conhecida como\n"
                + "a)biogás\n"
                + "b)biomassa\n"
                + "c)gás de cozinha\n"
                + "d)gás biológico\n"
                + "e)gás carbônico\n";
        respostas[9] = "a";
        
        perguntas[10] = "Na produção do biogás,além do lixo orgânico quais materiais fazem parte da produção? \n"
                + "a)carvão e vidro\n"
                + "b)petróleo\n"
                + "c)álcool\n"
                + "d)esterco,bagaços e cascas,óleo vegetal e fezes humanas\n"
                + "e)metais e água salina\n";
        respostas[10] = "d";
        
        perguntas[11] = "No processo da queima do lixo orgânico e do não recíclavel este  sofre um processo de inceneração e essa queima chega a temperatura de:  \n"
                + "a)170 C\n"
                + "b)490 C\n"
                + "c)1800 C\n"
                + "d)2100 C\n"
                + "e)700 C\n";
        respostas[11] = "c";
         
        perguntas[12] = "Qual órgão é responsável por decidir medidas primodiais a preservação do meio ambiente? \n"
                + "a)funai\n"
                + "b)mec\n"
                + "c)ctnbio\n"
                + "d)conama\n"
                + "e)ibama\n";
        respostas[12] = "d";
        
        perguntas[13] = "Efeito estufa é o fenômeno _____ do planeta, responsável por absorver calor na atmosfera terrestre, ocasionando o desenvolvimento da biodiversidade. \n"
                + "Complete a frase."
                + "a)ambiental e negativo\n"
                + "b)global e negativo\n"
                + "c)natural e positivo\n"
                + "d)natural e negativo\n"
                + "e)regional e posiivo\n";
        respostas[13] = "c";
        
        perguntas[14] = "Como são descartados os objetos lixos tecnológicos.E qual o estrago que ele produz no meio ambiente? \n"
                + "a)no lixo comum \n"
                + "b)nos rios e mares\n"
                + "c)postos coletores\n"
                + "d)no esgoto\n"
                + "e)na natureza\n";
        respostas[14] = "c";
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
