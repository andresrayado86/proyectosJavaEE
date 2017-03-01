package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import mx.com.andres.sga.domain.Persona;
import mx.com.andres.sga.servicio.PersonaService;

import org.junit.Before;

public class PersonaServiceTest {
	private PersonaService personaService;

	@Before
	public void setUp() throws Exception {
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		personaService = (PersonaService) contenedor
				.getContext()
				.lookup("java:global/classes/PersonaServiceImpl!mx.com.andres.sga.servicio.PersonaService");
	}

//	@Test
	public void testEJBPersonaService() {
		System.out.println("Iniciando test EJB PersonaService");
		assertTrue(personaService != null);
		assertEquals(7, personaService.listarPersonas().size());
		System.out.println("El no. de personas es igual a:"
				+ personaService.listarPersonas().size());
		this.desplegarPersonas(personaService.listarPersonas());
		System.out.println("Fin test EJB PersonaService");
	}

	private void desplegarPersonas(List<Persona> personas) {
		for (Persona persona : personas) {
			System.out.println(persona);
		}
	}
}
