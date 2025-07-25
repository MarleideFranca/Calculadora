package com.marleidealves;

public class Empresa {
    private String nomeFantasia;
    private String cnpj;
    private String email;
    private CalculadoraFrete calculadoraFrete;

    public Empresa(String nomeFantasia, String cnpj,String email, CalculadoraFrete calculadoraFrete) {
        if (nomeFantasia == null || nomeFantasia.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da empresa é obrigatório.");
        }
        if (cnpj == null || cnpj.length() != 14) {
            throw new IllegalArgumentException("CNPJ deve conter 14 dígitos.");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email é obrigatório.");
        }

        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.email = email;
        this.calculadoraFrete = calculadoraFrete;
    }

    public double calcularFrete() {
        return calculadoraFrete.calcularFrete();
    }

    // Getters
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }
    public String getEmail() {
        return email;
    }

    public CalculadoraFrete getCalculadoraFrete() {
        return calculadoraFrete;
    }

    // Setters (opcional)
    public void setCalculadoraFrete(CalculadoraFrete calculadoraFrete) {
        this.calculadoraFrete = calculadoraFrete;
    }
}

