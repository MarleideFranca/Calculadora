package com.marleidealves;

public class Main {
    public static void main(String[] args) {
        try {
            CalculadoraFrete frete = new CalculadoraFrete(85.0, 20.0);
            double valorFrete = frete.calcularFrete();
            System.out.printf("O valor do frete é: R$ %.2f\n", valorFrete);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
