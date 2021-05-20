package quiz;

import java.util.Scanner;

public abstract class Pergunta {

    //Atributos:
    private int qtdPerguntas;
    private Scanner tecla = new Scanner(System.in);

    //Construtor:
    public Pergunta(int quantidade) {
        setQtdPerguntas(quantidade);
    }

    //Getters & Setters:
    public Scanner getTecla() {
        return tecla;
    }

    public int getQtdPerguntas() {
        return qtdPerguntas;
    }

    public void setQtdPerguntas(int qtdPerguntas) {
        this.qtdPerguntas = qtdPerguntas;
    }

    //Principal:
    public abstract void definirPerguntas();

    public abstract void checarResposta(int numeroPergunta, String resposta, Player jogador);

    public abstract void executarPergunta(int numero, Player jogador);

    public boolean verificar(String resposta) {    
        return (resposta != null && resposta.matches("a|b|c|d|e") && !"".equals(resposta));
    }

    public void verificarErro(String resposta, char tipo) throws RespostaInvalidaException {
        switch (tipo) {
            case 's':
                if (!verificar(resposta)) {
                    throw new RespostaInvalidaException("Resposta Invalida! Digite somente [s] ou [n].");
                }
                break;
            case 'm':
                if (!verificar(resposta)) {
                    throw new RespostaInvalidaException("Resposta Invalida! Digite somente umas das alternativas listadas.");
                }
                break;
            case 'n':
                if (!verificar(resposta)) {
                    throw new RespostaInvalidaException("Resposta Invalida! Digite somente números positivos.");
                }
        }
    }

}
