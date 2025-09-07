package calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da classe Calculadora")
public class CalculadoraTestGPT {

    private Calculadora calc;

    @BeforeEach
    void setUp() {
        calc = new Calculadora();
    }

    @Test
    void testSoma() {
        assertEquals(5, calc.soma(2, 3));
        assertEquals(0, calc.soma(-2, 2));
    }

    @Test
    void testSubtracao() {
        assertEquals(1, calc.subtracao(3, 2));
        assertEquals(-5, calc.subtracao(-2, 3));
    }

    @Test
    void testMultiplicacao() {
        assertEquals(6, calc.multiplicacao(2, 3));
        assertEquals(0, calc.multiplicacao(5, 0));
    }

    @Test
    void testDivisao() {
        assertEquals(2, calc.divisao(6, 3));
        assertThrows(ArithmeticException.class, () -> calc.divisao(5, 0));
    }

    @Test
    void testSomatoria() {
        assertEquals(15, calc.somatoria(5)); // 0+1+2+3+4+5
        assertEquals(0, calc.somatoria(0));
    }

    @Test
    void testEhPositivo() {
        assertTrue(calc.ehPositivo(5));
        assertTrue(calc.ehPositivo(0));
        assertFalse(calc.ehPositivo(-1));
    }

    @Test
    void testCompara() {
        assertEquals(0, calc.compara(5, 5));
        assertEquals(1, calc.compara(7, 3));
        assertEquals(-1, calc.compara(2, 8));
    }
}

