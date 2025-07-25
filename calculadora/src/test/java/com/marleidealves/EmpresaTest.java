package com.marleidealves;

import com.marleidealves.service.CadastroFornecedorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmpresaTest {

    private CadastroFornecedorService service;

    @BeforeEach
    public void inicializar() {
        service = new CadastroFornecedorService();
    }

    @Test
    public void testCadastroEmpresaValido() {
        CategoriaProduto categoria = new CategoriaProduto("Padrão", 1.0);
        CalculadoraFrete frete = new CalculadoraFrete(70.0, 15.0, categoria);

        Empresa empresa = new Empresa("Empresa Teste", "12345678901234", "contato@empresateste.com", frete);

        // 10 + (0.5 * 15 * 1.0) = 17.5 → com 50% de desconto = 8.75
        assertEquals(8.75, empresa.calcularFrete(), 0.01);
    }

    @Test
    public void testCadastroEmpresaComCnpjInvalido() {
        CategoriaProduto categoria = new CategoriaProduto("Padrão", 1.0);
        CalculadoraFrete frete = new CalculadoraFrete(80.0, 30.0, categoria);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Empresa("Master", "12345", "eontato@empresamaster.com", frete);
        });

        assertEquals("CNPJ deve conter 14 dígitos.", ex.getMessage());
    }

    @Test
    public void testNomeEmpresaNaoInformado() {
        CategoriaProduto categoria = new CategoriaProduto("Padrão", 1.0);
        CalculadoraFrete frete = new CalculadoraFrete(70.0, 15.0, categoria);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Empresa("", "123456789011234", "contato@empresa.com", frete);
        });

        assertEquals("Nome da empresa é obrigatório.", ex.getMessage());
    }

    @Test
    public void testCadastroFornecedorValido() {
        CategoriaProduto categoria = new CategoriaProduto("Comum", 1.0);
        CalculadoraFrete frete = new CalculadoraFrete(80.0, 30.0, categoria);

        Empresa fornecedor = new Empresa(
            "Fornecedor ABC",
            "12345678000199",
            "contato@fornecedorabc.com",
            frete
        );

        double freteCalculado = fornecedor.calcularFrete(); // (10 + 0.5*30*1.0) = 25.0, com 50% = 12.5

        assertEquals("Fornecedor ABC", fornecedor.getNomeFantasia());
        assertEquals("12345678000199", fornecedor.getCnpj());
        assertEquals("contato@fornecedorabc.com", fornecedor.getEmail());
        assertEquals(12.5, freteCalculado, 0.01);
    }

    @Test
    public void testCadastroFornecedorDuplicado() {
        CategoriaProduto categoria = new CategoriaProduto("Padrão", 1.0);

        CalculadoraFrete frete1 = new CalculadoraFrete(80.0, 20.0, categoria);
        Empresa fornecedor1 = new Empresa("Fornecedor A", "12345678000100", "contato@fornecedor.a.com", frete1);
        service.cadastrarFornecedor(fornecedor1);

        CalculadoraFrete frete2 = new CalculadoraFrete(60.0, 30.0, categoria);
        Empresa fornecedorDuplicado = new Empresa("Fornecedor A", "12345678000100", "contato@fornecedor.a.com", frete2);

        Exception excecao = assertThrows(IllegalArgumentException.class, () -> {
            service.cadastrarFornecedor(fornecedorDuplicado);
        });

        assertEquals("Fornecedor já está cadastrado.", excecao.getMessage());
    }
}
