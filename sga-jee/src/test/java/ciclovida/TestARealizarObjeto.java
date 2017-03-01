package ciclovida;

import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import mx.com.andres.sga.domain.Persona;
import mx.com.andres.sga.domain.Usuario;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestARealizarObjeto {
	
	static EntityManager em = null;
	static EntityTransaction tx = null;
	static EntityManagerFactory emf = null;
	Logger log = Logger.getLogger("Test Encontrar un objeto");
	
	@BeforeClass
	public static void init() throws Exception {
		EJBContainer.createEJBContainer();
		emf = Persistence.createEntityManagerFactory("PersonaPU");
	}
	
	@Before
	public void setup() {
		try {
			em = emf.createEntityManager();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/*
	 * Metodo para recuperar un registro de la bade de datos
	 * Se inicia la transaccion se recupera el objeto por medio del metodo find
	 * se cierra la transaccion y se muestra en el log el objeto recuperado
	 * */
//	@Test
//	public void testBuscar(){
//		System.out.println("Iniciando la busqueda de la persona");
//		tx = em.getTransaction();
//		tx.begin();
//		Persona persona1 = em.find(Persona.class, 2);
//		tx.commit();
//		log.debug("Se ha recuperado el objeto persona" + persona1);
//	}
	
	
	
	/*
	 * Metodo para insertar un registro en la base de datos
	 * 
	 * 
	 * */
//	@Test
//	public void insertarPersona() {
//		log.debug("Iniciando el contenedor");
//		tx = em.getTransaction();
//		tx.begin();
//		Persona persona = new Persona("Ana", "Garcia", "Vazquez", "anag@hotmail.com", "8182838485");
//		em.persist(persona);
//		tx.commit();
//		log.debug("Se ha guardado en la base de datos el siguiente registro de persona: " + persona);
//	}
	
	/* Metodo para la modificación de un objeto recuperado de la base de datos
	 * 
	 * 
	 * */
	
//	@Test
//	public void eliminarRegistroPersona() {
//		EntityTransaction tx = em.getTransaction();
//		log.debug("Iniciando la transaccion para eliminar persona");
//		tx.begin();
//		Persona persona = em.find(Persona.class, 3);
//		tx.commit();
//		log.debug("Se ha recuperado la persona: " + persona);
//		persona.setApeMaterno("Colorina");
//		EntityTransaction tx2 = em.getTransaction();
//		tx2.begin();
//		em.merge(persona);
//		tx2.commit();
//		log.debug("Se ha realizado el cambio correctamente" + persona);
//	}
	
	/**
	 * Motodo para la insersion de dos objetos que tienen configuracion de guardado en cascada
	 */
	
//	@Test
	public void testPersistenciaCascada(){
		EntityTransaction tx = em.getTransaction();
		log.debug("Se inicia la insercion de una persona y un usuario a la base de datos...");
		tx.begin();
		
		Persona persona = new Persona("Miguel", "Loera", "Cerda", "Miguel@hotmail.com", "811890909");
		
		Usuario usuario = new Usuario("mloera1234", "1234565", persona);
		
		em.persist(usuario);
		
		tx.commit();
		
		log.debug("Se han registrado correctamente los objetos en cascada: " + usuario + " " + persona);
	}
	
	
	@After
	public void tearDown() throws Exception {
		if(em != null){
			em.close();
		}
	}
	
}
