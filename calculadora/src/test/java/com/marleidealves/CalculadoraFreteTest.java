package com.marleidealves;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraFreteTest {

    @Test
    public void testFreteGratisParaCompraAcimaDe100() {// cenariio 1 - Projeto
        // Entrada
        double valorCompra = 120.00;
        double distancia = 50.0;

        // Execução
        CalculadoraFrete frete = new CalculadoraFrete(valorCompra, distancia);
        double valorFrete = frete.calcularFrete();

        // Verificação
        assertEquals(0.0, valorFrete, 0.01, "O frete deve ser gratuito para compras acima de R$ 100,00.");
    }

    @Test
    public void testFreteComDesconto50() {
        CalculadoraFrete cf = new CalculadoraFrete(80.0, 20.0);
        assertEquals(10.0, cf.calcularFrete());
    }

    @Test
    public void testFreteSemDesconto() {
        CalculadoraFrete cf = new CalculadoraFrete(50.0, 10.0);
        assertEquals(15.0, cf.calcularFrete());
    }

    @Test
    public void testValorCompraInvalido() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new CalculadoraFrete(0.0, 15.0);
        });
        assertEquals("O valor da compra deve ser maior que zero.", e.getMessage());
    }

    @Test
    public void testFreteDesconto50ParaCompraIgualA100() {
        // Valor da compra: R$ 100,00
        // Distância: 30 km
        CalculadoraFrete cf = new CalculadoraFrete(100.00, 30.0);

        // Cálculo do frete: 10 + (0.5 * 30) = 25.00 → com 50% de desconto = 12.50
        double valorEsperado = 12.50;

        assertEquals(valorEsperado, cf.calcularFrete(), 0.01);
    }

    @Test
    public void testFreteDesconto50ParaCompraIgualA70() {
        // Valor da compra: R$ 70,00
        // Distância: 30 km
        CalculadoraFrete cf = new CalculadoraFrete(70.00, 30.0);

        // Cálculo do frete: 10 + (0.5 * 30) = 25.00 → com 50% de desconto = 12.50
        double valorEsperado = 12.50;

        assertEquals(valorEsperado, cf.calcularFrete(), 0.01);
    }

    @Test
    public void testValorMinimoValido() {
        CalculadoraFrete cf = new CalculadoraFrete(0.01, 0.0);
        assertEquals(10.0, cf.calcularFrete(), 0.01);
    }

    @Test
    public void testCT13_FreteComDistanciaMuitoLongaECompraBaixa() {
        // Pré-condições:
        // valorCompra < 70 e distancia >= 0

        // Entrada
        double valorCompra = 50.00;
        double distanciaKm = 1000.0;

        // Execução
        CalculadoraFrete cf = new CalculadoraFrete(valorCompra, distanciaKm);
        double resultado = cf.calcularFrete();

        // Saída esperada: 10 + (0.5 * 1000) = 510.0
        double freteEsperado = 510.0;

        // Verificação
        assertEquals(freteEsperado, resultado, 0.01);

        // Pós-condições:
        // Frete sem desconto
    }

    @Test
    public void testCT18_ValorCompraZero() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new CalculadoraFrete(0.00, 15.0);
        });
        assertEquals("O valor da compra deve ser maior que zero.", e.getMessage());
    }

    @Test
    public void testCT21_ValorCompraNaoPreenchido() {
        Exception e = assertThrows(NumberFormatException.class, () -> {
            // Simula conversão de entrada de formulário
            String valorCompraStr = ""; // valor em branco
            String distanciaStr = "10.0";

            double valorCompra = Double.parseDouble(valorCompraStr); // lança exceção aqui
            double distancia = Double.parseDouble(distanciaStr);

            new CalculadoraFrete(valorCompra, distancia);
        });

        assertTrue(e.getMessage().contains("empty String"));
    }

}
