package jokenpo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classe para teste da Jokenpo")
public class JokenpoTest {

    private Main jogo;

    @BeforeEach
    public void inicializa() {
        jogo = new Main();
        System.out.println("Início de teste");
    }

    @Test
    @DisplayName("papel vs pedra")
    public void rodada1() {
        int vencedor = jogo.jogar(1, 2);
        assertEquals(1, vencedor);
    }

    @Test
    @DisplayName("pedra vs papel")
    public void rodada2() {
        int vencedor = jogo.jogar(2, 1);
        assertEquals(2, vencedor);
    }

    @Test
    @DisplayName("pedra vs pedra")
    public void rodada3() {
        int vencedor = jogo.jogar(2, 2);
        assertEquals(0, vencedor); // empate retorna 0, não -1
    }

    @Test
    @DisplayName("jogador 1 = 0")
    public void rodada4() {
        int vencedor = jogo.jogar(0, 2);
        assertEquals(-1, vencedor);
    }

    @Test
    @DisplayName("os dois fora do intervalo")
    public void rodada5() {
        int vencedor = jogo.jogar(0, 4);
        assertEquals(-1, vencedor);
    }

    @Test
    @DisplayName("tesoura vs papel")
    public void rodada6() {
        int vencedor = jogo.jogar(3, 1);
        assertNotEquals(1, vencedor);
    }

    @Test
    @DisplayName("tesoura vs papel invertido")
    public void rodada7() {
        int vencedor = jogo.jogar(1, 3);
        assertEquals(1, vencedor);
    }
}
