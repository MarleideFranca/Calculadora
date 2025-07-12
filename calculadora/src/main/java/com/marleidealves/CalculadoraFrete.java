package com.marleidealves;


public class CalculadoraFrete {

    // Atributos (ou variáveis de instância)
    private double valorCompra;
    private double distanciaKm;

    // Construtor: inicializa os atributos com valores informados
    public CalculadoraFrete(double valorCompra, double distanciaKm) {
        // Validação dos dados
        if (valorCompra <= 0) {
            throw new IllegalArgumentException("O valor da compra deve ser maior que zero.");
        }
        if (distanciaKm < 0) {
            throw new IllegalArgumentException("A distância não pode ser negativa.");
        }

        this.valorCompra = valorCompra;
        this.distanciaKm = distanciaKm;
    }

    // Getters (opcional, usados para acessar os valores)
    public double getValorCompra() {
        return valorCompra;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    // Setters (opcional, usados para modificar os valores)
    public void setValorCompra(double valorCompra) {
        if (valorCompra <= 0) {
            throw new IllegalArgumentException("O valor da compra deve ser maior que zero.");
        }
        this.valorCompra = valorCompra;
    }

    public void setDistanciaKm(double distanciaKm) {
        if (distanciaKm < 0) {
            throw new IllegalArgumentException("A distância não pode ser negativa.");
        }
        this.distanciaKm = distanciaKm;
    }

    // Método que calcula o frete com base nas regras do enunciado
    public double calcularFrete() {
        // Valor base do frete
        double valorFrete = 10.0 + (0.50 * distanciaKm);

        // Regras de desconto
        if (valorCompra > 100.0) {
            return 0.0; // Frete gratuito
        } else if (valorCompra >= 70.0) {
            return valorFrete * 0.5; // 50% de desconto
        } else {
            return valorFrete; // Sem desconto
        }
    }
}
