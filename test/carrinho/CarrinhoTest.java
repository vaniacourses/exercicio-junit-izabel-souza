package carrinho;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarrinhoTest {

    private Carrinho car;
    private Produto jogo;
    private Produto console;

    @BeforeEach
    public void inicializaObjetos() {
        car = new Carrinho(); // zera carrinho antes de cada teste
        jogo = new Produto("Super Mario World", 85);
        console = new Produto("PS4", 1000);
    }

    @Test
    @DisplayName("Teste de adição de produtos no carrinho")
    public void adicionarProdutoCarrinho() {
        car.addItem(jogo);
        car.addItem(console);

        assertEquals(2, car.getQtdeItems());
    }

    @Test
    @DisplayName("Verifica o valor total do carrinho")
    public void pegaValorTotal() {
        car.addItem(jogo);
        car.addItem(console);

        assertEquals(1085.0, car.getValorTotal());
    }

    @Test
    @DisplayName("Remove produto existente")
    public void removerProdutoExistente() throws ProdutoNaoEncontradoException {
        car.addItem(jogo);
        car.removeItem(jogo);

        assertEquals(0, car.getQtdeItems());
    }

    @Test
    @DisplayName("Tenta remover produto inexistente (lança exceção)")
    public void removerProdutoInexistente() {
        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            car.removeItem(jogo);
        });
    }

    @Test
    @DisplayName("Esvazia carrinho")
    public void esvaziaCarrinho() {
        car.addItem(jogo);
        car.addItem(console);

        car.esvazia();

        assertEquals(0, car.getQtdeItems());
        assertEquals(0.0, car.getValorTotal());
    }

    @Test
    @DisplayName("Quantidade de itens está correta após múltiplas adições")
    public void quantidadeItens() {
        car.addItem(jogo);
        car.addItem(console);
        car.addItem(jogo);

        assertEquals(3, car.getQtdeItems());
    }

    @Test
    @DisplayName("Valor total é atualizado corretamente após adicionar e remover")
    public void valorAtualizado() throws ProdutoNaoEncontradoException {
        car.addItem(jogo);
        car.addItem(console);

        assertEquals(1085.0, car.getValorTotal());

        car.removeItem(jogo);

        assertEquals(1000.0, car.getValorTotal());
    }
}
