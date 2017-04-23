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
	

}
