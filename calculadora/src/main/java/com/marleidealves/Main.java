package com.marleidealves;

public class Main {
    public static void main(String[] args) {
        CalculadoraFrete frete = new CalculadoraFrete(80.0, 100.0);
        Usuario usuario = new Usuario("Marleide", "marleide@email.com", "12345678901", frete);

        double valorFrete = usuario.calcularFrete();
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Frete calculado: R$ " + valorFrete);
    }
}
