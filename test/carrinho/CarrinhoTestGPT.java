package carrinho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da classe Carrinho")
public class CarrinhoTestGPT {

    private Carrinho carrinho;
    private Produto p1;
    private Produto p2;

    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
        p1 = new Produto("Arroz", 10.0);
        p2 = new Produto("Feijao", 15.0);
    }

    @Test
    void testAddItem() {
        carrinho.addItem(p1);
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    void testGetValorTotal() {
        carrinho.addItem(p1);
        carrinho.addItem(p2);
        assertEquals(25.0, carrinho.getValorTotal());
    }

    @Test
    void testRemoveItemExistente() throws ProdutoNaoEncontradoException {
        carrinho.addItem(p1);
        carrinho.removeItem(p1);
        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    void testRemoveItemNaoExistente() {
        assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(p2));
    }

    @Test
    void testEsvazia() {
        carrinho.addItem(p1);
        carrinho.addItem(p2);
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
    }
}
