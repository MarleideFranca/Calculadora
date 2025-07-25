package com.marleidealves;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraFreteTest {

    @Test
    public void testFreteGratisParaCompraAcimaDe100() {
        double valorCompra = 120.00;
        double distancia = 50.0;
        CategoriaProduto categoria = new CategoriaProduto("Eletrônicos", 1.0);

        CalculadoraFrete frete = new CalculadoraFrete(valorCompra, distancia, categoria);
        double valorFrete = frete.calcularFrete();

        assertEquals(0.0, valorFrete, 0.01, "O frete deve ser gratuito para compras acima de R$ 100,00.");
    }

    @Test
    public void testFreteComDesconto50() {
        CategoriaProduto categoria = new CategoriaProduto("Roupas", 1.0);
        CalculadoraFrete cf = new CalculadoraFrete(80.0, 20.0, categoria);
        assertEquals(10.0, cf.calcularFrete(), 0.01);
    }

    @Test
    public void testFreteSemDesconto() {
        CategoriaProduto categoria = new CategoriaProduto("Livros", 1.0);
        CalculadoraFrete cf = new CalculadoraFrete(50.0, 10.0, categoria);
        assertEquals(15.0, cf.calcularFrete(), 0.01);
    }

    @Test
    public void testValorCompraInvalido() {
        CategoriaProduto categoria = new CategoriaProduto("Livros", 1.0);
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new CalculadoraFrete(0.0, 15.0, categoria);
        });
        assertEquals("O valor da compra deve ser maior que zero.", e.getMessage());
    }

    @Test
    public void testFreteDesconto50ParaCompraIgualA100() {
        CategoriaProduto categoria = new CategoriaProduto("Livros", 1.0);
        CalculadoraFrete cf = new CalculadoraFrete(100.00, 30.0, categoria);
        double valorEsperado = 12.50;
        assertEquals(valorEsperado, cf.calcularFrete(), 0.01);
    }

    @Test
    public void testFreteDesconto50ParaCompraIgualA70() {
        CategoriaProduto categoria = new CategoriaProduto("Livros", 1.0);
        CalculadoraFrete cf = new CalculadoraFrete(70.00, 30.0, categoria);
        double valorEsperado = 12.50;
        assertEquals(valorEsperado, cf.calcularFrete(), 0.01);
    }

    @Test
    public void testValorMinimoValido() {
        CategoriaProduto categoria = new CategoriaProduto("Diversos", 1.0);
        CalculadoraFrete cf = new CalculadoraFrete(0.01, 0.0, categoria);
        assertEquals(10.0, cf.calcularFrete(), 0.01);
    }

    @Test
    public void testCT13_FreteComDistanciaMuitoLongaECompraBaixa() {
        double valorCompra = 50.00;
        double distanciaKm = 1000.0;
        CategoriaProduto categoria = new CategoriaProduto("Autopeças", 1.0);

        CalculadoraFrete cf = new CalculadoraFrete(valorCompra, distanciaKm, categoria);
        double resultado = cf.calcularFrete();
        double freteEsperado = 510.0;

        assertEquals(freteEsperado, resultado, 0.01);
    }

    @Test
    public void testCT18_ValorCompraZero() {
        CategoriaProduto categoria = new CategoriaProduto("Geral", 1.0);
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new CalculadoraFrete(0.00, 15.0, categoria);
        });
        assertEquals("O valor da compra deve ser maior que zero.", e.getMessage());
    }

    @Test
    public void testCT21_ValorCompraNaoPreenchido() {
        Exception e = assertThrows(NumberFormatException.class, () -> {
            String valorCompraStr = ""; // Simulando valor não preenchido
            String distanciaStr = "10.0";

            double valorCompra = Double.parseDouble(valorCompraStr); // lançará exceção aqui
            double distancia = Double.parseDouble(distanciaStr);

            CategoriaProduto categoria = new CategoriaProduto("Genérico", 1.0);
            new CalculadoraFrete(valorCompra, distancia, categoria);
        });

        assertTrue(e.getMessage().contains("empty String"));
    }
}
