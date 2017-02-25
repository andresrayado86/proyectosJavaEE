package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import mx.com.andres.sga.domain.Usuario;
import mx.com.andres.sga.servicio.UsuarioService;

import org.junit.Before;
import org.junit.Test;

public class UsuarioServiceTest {
	private UsuarioService usuarioService;

	@Before
	public void setUp() throws Exception {
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		usuarioService = (UsuarioService) contenedor
				.getContext()
				.lookup("java:global/classes/UsuarioServiceImpl!mx.com.andres.sga.servicio.UsuarioService");
	}

	@Test
	public void testEJBUsuarioService() {
		System.out.println("Iniciando test EJB UsuarioService");
		assertTrue(usuarioService != null);
		assertEquals(1, usuarioService.listarUsuarios().size());
		System.out.println("El no. de personas es igual a:"
				+ usuarioService.listarUsuarios().size());
		this.desplegarUsuarios(usuarioService.listarUsuarios());
		System.out.println("Fin test EJB UsuarioService");
	}

	private void desplegarUsuarios(List<Usuario> usuarios) {
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
	}
}
