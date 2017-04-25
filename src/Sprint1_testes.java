import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Sprint1_testes {
	
	Biblioteca biblioteca;
	Usuario user;
	
	@Before
	public void initialize(){
		biblioteca = new Biblioteca("Biblioteca municipal");
		user = new Usuario("Adauto");
	}

	@Test
	public void adicionarUsuario() {
		biblioteca.addUsuario(user);
		assertTrue(biblioteca.usuarioCadastrado(user));
		assertTrue(biblioteca.usuarioRegularizado(user));
	}
	
	@Test
	public void removerUsuario() {
		biblioteca.addUsuario(user);
		assertTrue(biblioteca.usuarioCadastrado(user));
		assertTrue(biblioteca.usuarioRegularizado(user));
		biblioteca.removeUsuario(user);
		assertFalse(biblioteca.usuarioCadastrado(user));
	}
	
	@Test
	public void bloquearUsuario() {
		biblioteca.addUsuario(user);
		assertTrue(biblioteca.usuarioCadastrado(user));
		assertTrue(biblioteca.usuarioRegularizado(user));
		biblioteca.blockUsuario(user, 10);
		assertFalse(biblioteca.usuarioRegularizado(user));
	}
	
	@Test
	public void registrarEmprestimo() {
		biblioteca.addUsuario(user);
		biblioteca.addLivro("Livro 1", "Fulano Mello");
		biblioteca.registrarEmprestimo(user, "Livro 1", "23/04/2017");
		assertFalse(biblioteca.livroDisponivel("Livro 1"));
	}
	
	@Test
	public void registrarDevolucao() {
		biblioteca.addUsuario(user);
		biblioteca.addLivro("Livro 1", "Fulano Mello");
		biblioteca.registrarEmprestimo(user, "Livro 1", "23/04/2017");
		biblioteca.registrarDevoluacao("Livro 1");
		assertTrue(biblioteca.livroDisponivel("Livro 1"));
	}
	
	@Test
	public void permiteAcessoDoUsuario() {
		assertFalse(biblioteca.acessarSistema(user));
		biblioteca.addUsuario(user);
		assertTrue(biblioteca.acessarSistema(user));
	}
	
	@Test
	public void consultaDeSituacao() {
		biblioteca.addUsuario(user);
		biblioteca.addLivro("Livro 1", "Fulano Mello");
		assertEquals(biblioteca.consultarLivro("Livro 1"),"disponivel");
		biblioteca.registrarEmprestimo(user, "Livro 1", "23/04/2017");
		assertEquals(biblioteca.consultarLivro("Livro 1"),"retirado");
		biblioteca.blockUsuario(user, 10);
		assertEquals(biblioteca.consultarLivro("Livro 1"),"extraviado");
		biblioteca.registrarDevoluacao("Livro 1");
		assertEquals(biblioteca.consultarLivro("Livro 1"),"disponivel");
	}
		
}
