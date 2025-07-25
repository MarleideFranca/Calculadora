package com.marleidealves;

public class CalculadoraFrete {

    private double valorCompra;
    private double distanciaKm;
    private CategoriaProduto categoria; // Composição

    public CalculadoraFrete(double valorCompra, double distanciaKm, CategoriaProduto categoria) {
        if (valorCompra <= 0) {
            throw new IllegalArgumentException("O valor da compra deve ser maior que zero.");
        }
        if (distanciaKm < 0) {
            throw new IllegalArgumentException("A distância não pode ser negativa.");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria não pode ser nula.");
        }

        this.valorCompra = valorCompra;
        this.distanciaKm = distanciaKm;
        this.categoria = categoria;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

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

    public void setCategoria(CategoriaProduto categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria não pode ser nula.");
        }
        this.categoria = categoria;
    }

    public double calcularFrete() {
        // Valor base do frete
        double valorFrete = 10.0 + (0.50 * distanciaKm);

        // Aplicar fator de ajuste da categoria
        valorFrete *= categoria.getFatorAjusteFrete();

        // Aplicar regras de desconto baseadas no valor da compra
        if (valorCompra > 100.0) {
            return 0.0;
        } else if (valorCompra >= 70.0) {
            return valorFrete * 0.5;
        } else {
            return valorFrete;
        }
    }
}
