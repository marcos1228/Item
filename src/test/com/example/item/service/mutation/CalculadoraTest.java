package com.example.item.service.mutation;

import com.example.item.application.service.Calculadora;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {
    @Test // TESTE COMPLETO
    public void testAdd() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.add(3, 2)); // Valida o retorno no método, garantindo a lógica da execução.
    }

    @Test // TESTE COMPLETO
    public void testSubtract() {
        Calculadora calc = new Calculadora();
        assertEquals(1, calc.subtract(3, 2)); // Valida o retorno no método, garantindo a lógica da execução.
    }
}
