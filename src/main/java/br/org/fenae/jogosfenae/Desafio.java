package br.org.fenae.jogosfenae;

public class Desafio {

    public static void main(String[] args) {
        System.out.println("Desafio");

        int dois = 2;
        int tres = 3;
        int cinco = 5;
        int seis=  6;
        int sete = 7;
        int dez = 10;

        double somarTresMaisDoisMultiplicarPorSeis = (seis * (tres + dois));
        System.out.println(somarTresMaisDoisMultiplicarPorSeis);
        double resultadoSomaPortencia = Math.pow(somarTresMaisDoisMultiplicarPorSeis, dois);
        System.out.println(resultadoSomaPortencia);



        double resultado = ( Math.pow((( Math.pow(6 * (3 + 2),2) ) / (3 * 2) - Math.pow((((1 -5) * (2 - 7)) / 2), 2)), 3)) / ( Math.pow(10, 3) );
        System.out.println("Resultado: " + resultado);
    }
}
