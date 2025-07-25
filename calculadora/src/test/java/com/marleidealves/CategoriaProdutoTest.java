package com.marleidealves;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoriaProdutoTest {

    @Test
    public void testCriacaoCategoriaValida() {
        CategoriaProduto categoria = new CategoriaProduto("Leve", 0.8);
        assertEquals("Leve", categoria.getNome());
        assertEquals(0.8, categoria.getFatorAjusteFrete(), 0.001);
    }

    @Test
    public void testCriacaoCategoriaComNomeNuloOuVazio() {
        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> {
            new CategoriaProduto(null, 1.0);
        });
        assertEquals("Nome da categoria é obrigatório.", ex1.getMessage());

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> {
            new CategoriaProduto("", 1.0);
        });
        assertEquals("Nome da categoria é obrigatório.", ex2.getMessage());
    }

    @Test
    public void testCriacaoCategoriaComFatorAjusteInvalido() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new CategoriaProduto("Pesado", 0.0);
        });
        assertEquals("Fator de ajuste deve ser maior que zero.", ex.getMessage());
    }

    @Test
    public void testCalculoFreteComDiferentesFatoresDeAjuste() {
        // Valor base do frete = 10 + (0.5 * 20) = 20.0
        
        // Categoria com fator 1.0 (normal)
        CategoriaProduto catNormal = new CategoriaProduto("Normal", 1.0);
        CalculadoraFrete cfNormal = new CalculadoraFrete(50.0, 20.0, catNormal);
        double freteNormal = cfNormal.calcularFrete();
        assertEquals(20.0, freteNormal, 0.01);

        // Categoria com fator 0.8 (leve)
        CategoriaProduto catLeve = new CategoriaProduto("Leve", 0.8);
        CalculadoraFrete cfLeve = new CalculadoraFrete(50.0, 20.0, catLeve);
        double freteLeve = cfLeve.calcularFrete();
        assertEquals(20.0 * 0.8, freteLeve, 0.01);

        // Categoria com fator 1.5 (pesado)
        CategoriaProduto catPesado = new CategoriaProduto("Pesado", 1.5);
        CalculadoraFrete cfPesado = new CalculadoraFrete(50.0, 20.0, catPesado);
        double fretePesado = cfPesado.calcularFrete();
        assertEquals(20.0 * 1.5, fretePesado, 0.01);
    }

    @Test
    public void testCalculoFreteComDescontoEfeitoCategoria() {
        // Valor da compra 80.0 (desconto 50%), distancia 10, fator 1.2
        CategoriaProduto categoria = new CategoriaProduto("Eletrônicos", 1.2);
        CalculadoraFrete cf = new CalculadoraFrete(80.0, 10.0, categoria);
        // valor base = 10 + 0.5*10 = 15.0
        // com fator 1.2 => 15.0 * 1.2 = 18.0
        // desconto 50% => 9.0
        double frete = cf.calcularFrete();
        assertEquals(9.0, frete, 0.01);
    }
}
