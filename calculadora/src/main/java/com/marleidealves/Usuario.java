package com.marleidealves;

/**
 * Classe que representa um usuário do sistema.
 * Um usuário possui nome, e-mail, CPF e uma calculadora de frete associada.
 */
public class Usuario {

    // Atributos (ou propriedades) do usuário
    private String nome;
    private String email;
    private String cpf;
    private CalculadoraFrete calculadoraFrete;

    /**
     * Construtor da classe Usuario.
     * Utilizado para criar um novo usuário com os dados informados.
     */
    public Usuario(String nome, String email, String cpf, CalculadoraFrete calculadoraFrete) {
        setNome(nome); // valida e define o nome
        setEmail(email); // valida e define o e-mail
        setCpf(cpf); // valida e define o CPF
        setCalculadoraFrete(calculadoraFrete); // valida e associa a calculadora de frete
    }

    /**
     * Método que retorna o valor do frete para este usuário,
     * utilizando a calculadora de frete associada.
     */
    public double calcularFrete() {
        return calculadoraFrete.calcularFrete();
    }

    // Métodos getters: usados para obter o valor de cada atributo

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public CalculadoraFrete getCalculadoraFrete() {
        return calculadoraFrete;
    }

    // Métodos setters: usados para alterar os valores dos atributos
    // Também fazem validações para garantir que os dados estejam corretos

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do usuário é obrigatório.");
        }
        this.nome = nome;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
        this.email = email;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve conter 11 dígitos.");
        }
        this.cpf = cpf;
    }

    public void setCalculadoraFrete(CalculadoraFrete calculadoraFrete) {
        if (calculadoraFrete == null) {
            throw new IllegalArgumentException("Calculadora de frete não pode ser nula.");
        }
        this.calculadoraFrete = calculadoraFrete;
    }
}
