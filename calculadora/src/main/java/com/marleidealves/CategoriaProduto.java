package com.marleidealves;

public class CategoriaProduto {
    private String nome;
    private double fatorAjusteFrete; // Ex: 1.0 (normal), 1.5 (pesado), 0.8 (leve)

    public CategoriaProduto(String nome, double fatorAjusteFrete) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome da categoria é obrigatório.");
        }
        if (fatorAjusteFrete <= 0) {
            throw new IllegalArgumentException("Fator de ajuste deve ser maior que zero.");
        }
        this.nome = nome;
        this.fatorAjusteFrete = fatorAjusteFrete;
    }

    public String getNome() {
        return nome;
    }

    public double getFatorAjusteFrete() {
        return fatorAjusteFrete;
    }
}

