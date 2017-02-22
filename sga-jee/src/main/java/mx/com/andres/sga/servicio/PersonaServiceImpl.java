package mx.com.andres.sga.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import mx.com.andres.sga.domain.Persona;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService{

	public List<Persona> listarPersonas() {
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona(2, "yessica", "flores", "cisneros", "yessica@hotmail.com", "8180902029"));
		personas.add(new Persona(2, "ana", "aguilar", "rodriguez", "ana@hotmail.com", "8181818181"));
		return personas;
	}

	public Persona encontrarPersonaPorId(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	public Persona encontrarPersonaPorEmail(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	public void registrarPersona(Persona persona) {
		// TODO Auto-generated method stub
		
	}

	public void modificarPersona(Persona persona) {
		// TODO Auto-generated method stub
		
	}

	public void eliminarPersona(Persona persona) {
		// TODO Auto-generated method stub
		
	}	
	
}
