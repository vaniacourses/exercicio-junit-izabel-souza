package produto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da classe Produto")
public class ProdutoTestGPT {

    private Produto p1;
    private Produto p2;

    @BeforeEach
    void setUp() {
        p1 = new Produto("Camiseta", 50.0);
        p2 = new Produto("Camiseta", 60.0);
    }

    @Test
    void testGettersSetters() {
        assertEquals("Camiseta", p1.getNome());
        assertEquals(50.0, p1.getPreco());

        p1.setNome("Calça");
        p1.setPreco(80.0);

        assertEquals("Calça", p1.getNome());
        assertEquals(80.0, p1.getPreco());
    }

    @Test
    void testEquals() {
        assertTrue(p1.equals(p2)); // nomes iguais
        Produto p3 = new Produto("Tênis", 200.0);
        assertFalse(p1.equals(p3));
    }
}