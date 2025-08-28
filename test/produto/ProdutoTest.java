package produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTest {
	
	Produto livro;
	Produto jogo;
	Produto fone;
	Produto console;
	
	@BeforeEach
	public void inicializa() {
		livro = new Produto("Introdu��o ao Teste de Software", 100.00);
		jogo = new Produto("Super Mario World", 85);
		fone = new Produto("Samsung Galaxy Bud", 550);
		console = new Produto("PS4", 1000);
	}
	
	@Test
	public void testCriaProdutos() {
		Assertions.assertAll("livro",
				() -> assertEquals("Introdu��o ao Teste de Software", livro.getNome()),
				() -> assertTrue(100.00 == livro.getPreco())						
				);
		
		Assertions.assertAll("jogo",
				() -> assertEquals("Super Mario World", jogo.getNome()),
				() -> assertTrue(85 == jogo.getPreco())						
				);
		
		Assertions.assertAll("fone",
				() -> assertEquals("Samsung Galaxy Bud", fone.getNome()),
				() -> assertTrue(550 == fone.getPreco())						
				);
		
		Assertions.assertAll("console",
				() -> assertEquals("PS4", console.getNome()),
				() -> assertTrue(1000 == console.getPreco())						
				);
	}
	
	@Test
	public void testLivrosDiferentes() {
		Produto livro2 = new Produto("Introdu��o ao Teste de Software", 90.00);
		
		assertNotSame(livro, livro2);	
	}
	
	@Test
	public void testJogosIguais() {
		Produto jogo2 = new Produto("Super Mario World", 85);
		
		assertSame(jogo, jogo2);	
	}
	
	@Test
	public void assertionComHamcrestMatcher() {
		assertThat(livro.getPreco(), equalTo(100.00));
		assertThat(livro.getNome(), notNullValue());
		assertThat(livro.getNome(), containsString("Teste"));
		assertThat(livro, instanceOf(Produto.class));
	}

}
