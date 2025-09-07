package jokenpo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da classe Main (Jokenpo)")
public class JokenpoTestGPT {

    private final Main jogo = new Main();

    @Test
    void testEmpate() {
        assertEquals(0, jogo.jogar(1, 1));
        assertEquals(0, jogo.jogar(2, 2));
        assertEquals(0, jogo.jogar(3, 3));
    }

    @Test
    void testJogador1Vence() {
        assertEquals(1, jogo.jogar(1, 2)); // papel vence pedra
        assertEquals(1, jogo.jogar(2, 3)); // pedra vence tesoura
        assertEquals(1, jogo.jogar(3, 1)); // tesoura vence papel
    }

    @Test
    void testJogador2Vence() {
        assertEquals(2, jogo.jogar(2, 1)); // pedra perde para papel
        assertEquals(2, jogo.jogar(3, 2)); // tesoura perde para pedra
        assertEquals(2, jogo.jogar(1, 3)); // papel perde para tesoura
    }

    @Test
    void testOpcaoInvalida() {
        assertEquals(-1, jogo.jogar(0, 1));
        assertEquals(-1, jogo.jogar(4, 2));
        assertEquals(-1, jogo.jogar(2, 99));
    }
}