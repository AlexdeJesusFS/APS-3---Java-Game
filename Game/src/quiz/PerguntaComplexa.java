package quiz;

public class PerguntaComplexa extends Pergunta {

    //atributos
    private static final int N_PERGUNTAS = 4;
    private final String[][] perguntaIni = new String[super.getQtdPerguntas()][6];
    private final String[][] perguntaMeio = new String[super.getQtdPerguntas()][6];
    private final String[][] perguntaFim = new String[super.getQtdPerguntas()][6];
    private final String[] respostas = new String[super.getQtdPerguntas()];

    //construtor
    public PerguntaComplexa() {
        super(N_PERGUNTAS);
        definirPerguntas();
    }

    //getters & setters
    public String[][] getPerguntaIni() {
        return perguntaIni;
    }

    public String[][] getPerguntaMeio() {
        return perguntaMeio;
    }

    public String[][] getPerguntaFim() {
        return perguntaFim;
    }

    //metodos pricipais
    @Override
    public void checarResposta(int numeroPergunta, String resposta, Player jogador) {
        if (respostas[numeroPergunta].equals(resposta.toLowerCase().trim())) {
            jogador.adicionaPontos();
            System.out.println("Parábens você conseguiu! Acertou todas em sequência.");
        } else {
            jogador.retiraPontos();
            System.out.println("Nem todas as suas decisões foram corretas.");
            System.out.println("");
        }
    }

    @Override
    public void executarPergunta(int numero, Player jogador) {
        //"respostaF" vai guardar os valores de resposta de cada pergunta juntos, "respostaA" vai guardar os valores individuais por um momento
        //"texto" vai ser utilizado para mostrar o texto das perguntas preenchido com as opcoes que o usuario escolher
        String respostaF = "", respostaA = "", texto = "";

        //Primeira Pergunta     
        try {
            System.out.println("Acerte as três perguntas que virão em sequência para ganhar pontos!");
            System.out.println(getPerguntaIni()[numero][0]);
            System.out.println("Escolha a alternativa que completa o texto acima: ");
            System.out.println(escreveOpcoes(numero, getPerguntaIni()));
            System.out.print("Resposta: ");
            respostaA = super.getTecla().nextLine().toLowerCase().trim();
            verificarErro(respostaA, 'm');
            System.out.println("");
        } catch (RespostaInvalidaException ex) {
            System.out.println("");
            System.out.println(ex.getMessage());
            executarPergunta(numero, jogador);
        }
        respostaF += respostaA;

        //Segunda Pergunta
        try {
            System.out.println("");
            texto = completarTexto(getPerguntaIni(), respostaA, numero);
            texto += getPerguntaMeio()[numero][0];
            System.out.println(texto); //exibe pergunta inicial completada pela resposta e pegunta meio
            System.out.println("Escolha a alternativa que completa o texto acima: ");
            System.out.println(escreveOpcoes(numero, getPerguntaMeio()));
            System.out.print("Resposta: ");
            respostaA = super.getTecla().nextLine().toLowerCase().trim();
            verificarErro(respostaA, 'm');
        } catch (RespostaInvalidaException ex) {
            System.out.println("");
            System.out.println(ex.getMessage());
            executarPergunta(numero, jogador);
        }
        respostaF += respostaA;

        //Terceira Pergunta
        try {
            System.out.println("");
            texto = completarTexto(texto, getPerguntaMeio(), respostaA, numero);
            texto += getPerguntaFim()[numero][0];
            System.out.println(texto); //exibe pergunta inicial e meio completa e a pergunta fim
            System.out.println("Escolha a alternativa que completa o texto acima: ");
            System.out.println(escreveOpcoes(numero, getPerguntaFim()));
            System.out.print("Resposta: ");
            respostaA = super.getTecla().nextLine().toLowerCase().trim();
            verificarErro(respostaA, 'm');
        } catch (RespostaInvalidaException ex) {
            System.out.println("");
            System.out.println(ex.getMessage());
            executarPergunta(numero, jogador);
        }
        respostaF += respostaA;

        texto = completarTexto(texto, getPerguntaFim(), respostaA, numero);
        System.out.println("--Resultado das respostas--");
        System.out.println(texto);
        System.out.println("");
        checarResposta(numero, respostaF, jogador);
    }

    public String completarTexto(String[][] pergunta, String resposta, int numero) {
        //
        String resultado = "";
        switch (resposta.toLowerCase()) {
            case "a"://pega a string da alternativa escolhida e a coloca no lugar dos '_' na proxima pergunta
                resultado = pergunta[numero][0].replaceAll("_____", pergunta[numero][1].substring(pergunta[numero][1].indexOf(")") + 1, pergunta[numero][1].indexOf(".")).toLowerCase());
                break;
            case "b":
                resultado = pergunta[numero][0].replaceAll("_____", pergunta[numero][2].substring(pergunta[numero][2].indexOf(")") + 1, pergunta[numero][2].indexOf(".")).toLowerCase());
                break;
            case "c":
                resultado = pergunta[numero][0].replaceAll("_____", pergunta[numero][3].substring(pergunta[numero][3].indexOf(")") + 1, pergunta[numero][3].indexOf(".")).toLowerCase());
                break;
            case "d":
                resultado = pergunta[numero][0].replaceAll("_____", pergunta[numero][4].substring(pergunta[numero][4].indexOf(")") + 1, pergunta[numero][4].indexOf(".")).toLowerCase());
                break;
            case "e":
                resultado = pergunta[numero][0].replaceAll("_____", pergunta[numero][5].substring(pergunta[numero][5].indexOf(")") + 1, pergunta[numero][5].indexOf(".")).toLowerCase());
                break;
        }
        return resultado;
    }

    public String completarTexto(String texto, String[][] pergunta, String resposta, int numero) {
        //retorna o valor do texto implementando o espaco em branco depois que o primeiro texto foi aplicado em uma variavel;
        String resultado = "";
        switch (resposta.toLowerCase()) {
            case "a":
                resultado = texto.replaceAll("_____", pergunta[numero][1].substring(pergunta[numero][1].indexOf(")") + 1, pergunta[numero][1].indexOf(".")).toLowerCase());
                break;
            case "b":
                resultado = texto.replaceAll("_____", pergunta[numero][2].substring(pergunta[numero][2].indexOf(")") + 1, pergunta[numero][2].indexOf(".")).toLowerCase());
                break;
            case "c":
                resultado = texto.replaceAll("_____", pergunta[numero][3].substring(pergunta[numero][3].indexOf(")") + 1, pergunta[numero][3].indexOf(".")).toLowerCase());
                break;
            case "d":
                resultado = texto.replaceAll("_____", pergunta[numero][4].substring(pergunta[numero][4].indexOf(")") + 1, pergunta[numero][4].indexOf(".")).toLowerCase());
                break;
            case "e":
                resultado = texto.replaceAll("_____", pergunta[numero][5].substring(pergunta[numero][5].indexOf(")") + 1, pergunta[numero][5].indexOf(".")).toLowerCase());
                break;
        }
        return resultado;
    }

    public String escreveOpcoes(int numeroPergunta, String[][] pergunta) {
        //retorna os valores de respostas para serem escritos na tela dada a matriz da pergunta e o numero correspondente da mesma
        String resultado = pergunta[numeroPergunta][1] + "\n" + pergunta[numeroPergunta][2] + "\n" + pergunta[numeroPergunta][3] + "\n" + pergunta[numeroPergunta][4] + "\n" + pergunta[numeroPergunta][5];
        return resultado;
    }

    @Override
    public void definirPerguntas() {
        /*
        //Molde de como criar uma pergunta composta
        //Cada pergunta deve conter um campo de 5 underlines "_" para que seja substituida pela opcao de resposta do usuario.
        //o valor da primeria cordenada dos vetores deve ser o mesmo em todas as partes da mesma pergunta.
        //-Primeiro enunciado-
        perguntaIni[][0] = "";
        //-opçoes-
        perguntaIni[][1] = "a) .";
        perguntaIni[][2] = "b) .";
        perguntaIni[][3] = "c) .";
        perguntaIni[][4] = "d) .";
        perguntaIni[][5] = "e) .";
        //-Segundo Enunciado-
        perguntaMeio[][0] = "";
        //-opções do segundo-
        perguntaMeio[][1] = "a) .";
        perguntaMeio[][2] = "b) .";
        perguntaMeio[][3] = "c) .";
        perguntaMeio[][4] = "d) .";
        perguntaMeio[][5] = "e) .";
        //-terceiro Enunciado-
        perguntaFim[][0] = "";
        //-opcoes do terceiro-
        perguntaFim[][1] = "a) .";
        perguntaFim[][2] = "b) .";
        perguntaFim[][3] = "c) .";
        perguntaFim[][4] = "d) .";
        perguntaFim[][5] = "e) .";
        //-resposta composta da juncao das 3 letras corretas-
        respostas[] = "";
         */

        //-Primeiro enunciado- Pergunta 0
        perguntaIni[0][0] = "Voce entra em uma floresta e se encontra com um urso, ao perceber que ele te viu voce _____.";
        //-opcoes-
        perguntaIni[0][1] = "a)Gritar com ele.";
        perguntaIni[0][2] = "b)Chama a policia.";
        perguntaIni[0][3] = "c)Brinca com ele.";
        perguntaIni[0][4] = "d)Se afasta devagar.";
        perguntaIni[0][5] = "e)O pede para respeitar seu espaco pessoal.";
        //-Segundo Enunciado-
        perguntaMeio[0][0] = " \nEle começa a se aproxiamr, o que você faz é _____.";
        //-opcoes do segundo-
        perguntaMeio[0][1] = "a)Fugir.";
        perguntaMeio[0][2] = "b)Dancar com o Urso.";
        perguntaMeio[0][3] = "c)Gritar com ele.";
        perguntaMeio[0][4] = "d)Usar seu splay anti-urso.";
        perguntaMeio[0][5] = "e)Sobir em uma arvore.";
        //-terceiro Enunciado-
        perguntaFim[0][0] = " O urso começa a se irritar, apesar de querer evitar o confronto não há outro jeito e você _____.";
        //-opcoes do terceiro-
        perguntaFim[0][1] = "a)Corre.";
        perguntaFim[0][2] = "b)Fica nas pontas do pé, grita e sacudi um galho.";
        perguntaFim[0][3] = "c)Fingi estar morto.";
        perguntaFim[0][4] = "d)Confundi ele com fotos de animais.";
        perguntaFim[0][5] = "e)Abraça-o e pedi desculpas pelo incomodo.";
        //-resposta composta da juncao das 3 letras corretas-
        respostas[0] = "ddb";

        //-Primeiro enunciado- Pergunta 1
        perguntaIni[1][0] = "O fenomeno anormal do aumento de temperatura da terra refere-se ao _____.";
        //-opçoes-
        perguntaIni[1][1] = "a)a.";
        perguntaIni[1][2] = "b)b.";
        perguntaIni[1][3] = "c)Aquecimento global.";
        perguntaIni[1][4] = "d)d.";
        perguntaIni[1][5] = "e)e.";
        //-Segundo Enunciado-
        perguntaMeio[1][0] = " \nEste fenomeno ocorre devido a _____.";
        //-opções do segundo-
        perguntaMeio[1][1] = "a)Produção exagerada e acumulo de gases poluentes na atmosfera terrestre.";
        perguntaMeio[1][2] = "b)b.";
        perguntaMeio[1][3] = "c)c.";
        perguntaMeio[1][4] = "d)d.";
        perguntaMeio[1][5] = "e)e.";
        //-terceiro Enunciado-
        perguntaFim[1][0] = " \nO principal gás resposável por esse fenômeno é o _____.";
        //-opcoes do terceiro-
        perguntaFim[1][1] = "a)a.";
        perguntaFim[1][2] = "b)b.";
        perguntaFim[1][3] = "c)Dioxido de carbono.";
        perguntaFim[1][4] = "d)d.";
        perguntaFim[1][5] = "e)e.";
        //-resposta composta da juncao das 3 letras corretas-
        respostas[1] = "cac";

        //-Primeiro enunciado-Pergunta 2
        perguntaIni[2][0] = "Atualmente percebemos que a degradação dos recursos naturais do planeta, como a agua, se deve principalmente as que provocam aquecimento global _____.";
        //-opçoes-
        perguntaIni[2][1] = "a)a.";
        perguntaIni[2][2] = "b)Ações humanas.";
        perguntaIni[2][3] = "c)c.";
        perguntaIni[2][4] = "d)d.";
        perguntaIni[2][5] = "e)e.";
        //-Segundo Enunciado-
        perguntaMeio[2][0] = " As princiapais acoes causadas pelo homem, que intencificam os problemas atmosfericos no planeta são _____.";
        //-opções do segundo-
        perguntaMeio[2][1] = "a)a.";
        perguntaMeio[2][2] = "b)b.";
        perguntaMeio[2][3] = "c)Desmantamento e queima de combustivel fosseis.";
        perguntaMeio[2][4] = "d)d.";
        perguntaMeio[2][5] = "e)e.";
        //-terceiro Enunciado-
        perguntaFim[2][0] = " \nComo consequencias das acoes humanas podemos constatar que o aquecimento global provoca _____.";
        //-opcoes do terceiro-
        perguntaFim[2][1] = "a)Extenção agricula e dos recurso naturais, devastação climatica e altas dos oceanos.";
        perguntaFim[2][2] = "b)b.";
        perguntaFim[2][3] = "c)c.";
        perguntaFim[2][4] = "d)d.";
        perguntaFim[2][5] = "e)e.";
        //-resposta composta da juncao das 3 letras corretas-
        respostas[2] = "bca";
        
        //Pergunta 3
        perguntaIni[3][0] = "Você está em uma caminhada na floresta quando derrepente uma cobra o pica na perna, você_____.";
        //-opçoes-
        perguntaIni[3][1] = "a)Corre atrás de ajuda.";
        perguntaIni[3][2] = "b)Prender a circulação do sangue do perna.";
        perguntaIni[3][3] = "c)Chupa sua perna onde está a ferida.";
        perguntaIni[3][4] = "d)Mantem a calma.";
        perguntaIni[3][5] = "e)Amputa sua próprio perna.";
        
        perguntaMeio[3][0] = " Após isso você _____.";
        
        perguntaMeio[3][1] = "a)Corre atrás de ajuda.";
        perguntaMeio[3][2] = "b)Chupa seu braço onde está a ferida.";
        perguntaMeio[3][3] = "c)Lava o local da picada com água e sabão.";
        perguntaMeio[3][4] = "d)Vai dormir.";
        perguntaMeio[3][5] = "e)Amputa sua próprio perna.";
        
        perguntaFim[3][0] = " \nE por fim você irá _____.";
        
        perguntaFim[3][1] = "a)Atrás de um soro.";
        perguntaFim[3][2] = "b)Aperta o local da ferida.";
        perguntaFim[3][3] = "c)Cortar o local da ferida.";
        perguntaFim[3][4] = "d)Chupar o local da ferida.";
        perguntaFim[3][5] = "e)Ligar para seus amados e se despedir.";
        //resposta correta da 3
        respostas[3] = "dca";
        
        //Pergunta 4
        perguntaIni[4][0] = "No Brasil ocorreu um grande evento, no qual se reunirão lideres de 156 países e 56 representantes\n"
                + "de todo o mundo para debater sobre a necessidade de conciliar o desenvolvimento socio econômico com a \n"
                + "utilização dos recursos naturais. Essa reunião ficou conhecida como _____.";
        //-opçoes-
        perguntaIni[4][1] = "a)Rio82.";
        perguntaIni[4][2] = "b)Rio92.";
        perguntaIni[4][3] = "c)Eco.";
        perguntaIni[4][4] = "d)Reunião sobre o desenvolvimento e os recursos naturais.";
        perguntaIni[4][5] = "e)Rio++..";
        
        perguntaMeio[4][0] = "\nOutro envento sobre as questões do meio ambiente foi o Protocolo de Kyoto, em Kyoto no Japão, em \n"
                + "1997, que foi assinado pelos países integrantes da ONU. O que o protocola visava era a(o) _____.";
        
        perguntaMeio[4][1] = "a)Redução da emissão de gases do efeito estufa.";
        perguntaMeio[4][2] = "b)Reflorestamento.";
        perguntaMeio[4][3] = "c)Procura do Godzilla.";
        perguntaMeio[4][4] = "d)Extinção da fome.";
        perguntaMeio[4][5] = "e)Cura do câncer.";
        
        perguntaFim[4][0] = "\nAlém dessa reunião houveram outras como a conferência de Paris que abordou assuntos sobre o meio \n"
                + "ambiente também. Nem todos os países do mundo adentaram ao acordo de Paris, como foi o caso da Síria que estava \n"
                + "em guerra e de outros países que não participaram por escolha, entre eles está a(o) _____.";

        perguntaFim[4][1] = "a)Chile.";
        perguntaFim[4][2] = "b)Groelândia.";
        perguntaFim[4][3] = "c)Rússia.";
        perguntaFim[4][4] = "d)Australia.";
        perguntaFim[4][5] = "e)Afica do sul.";
        //-resposta composta da juncao das 3 letras corretas-
        respostas[4] = "bac";
        
        
        
        
    }

}