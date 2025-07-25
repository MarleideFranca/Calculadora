package com.marleidealves;


public class Main {
    public static void main(String[] args) {
        // Criando uma categoria de produto com fator de ajuste
        CategoriaProduto categoria = new CategoriaProduto("Eletrônicos", 1.2);

        // Criando a calculadora de frete com a categoria
        CalculadoraFrete calculadora = new CalculadoraFrete(80.0, 100.0, categoria);

        // Exibindo o valor do frete
        double frete = calculadora.calcularFrete();
        System.out.println("Valor do frete: R$ " + frete);
    }
}

