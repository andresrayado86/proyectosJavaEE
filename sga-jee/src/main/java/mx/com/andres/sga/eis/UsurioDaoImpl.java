package mx.com.andres.sga.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import mx.com.andres.sga.domain.Usuario;

@Stateless
public class UsurioDaoImpl implements UsuarioDao {
	
	@PersistenceContext(unitName="PersonaPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAllUsuarios() {
		
		return em.createNamedQuery("Usuario.findAll").getResultList();
	}

	@Override
	public Usuario findUsuarioById(Usuario usuario) {
		
		return em.find(Usuario.class, usuario.getIdUsuario());
	}

	@Override
	public void insertUsuario(Usuario usuario) {
		
		em.persist(usuario);
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		em.merge(usuario);

	}

	@Override
	public void deleteUsuario(Usuario usuario) {
		em.merge(usuario);
		em.remove(usuario);

	}

	@Override
	public Usuario findUsuarioByUsername(Usuario usuario) {
		Query query = em.createQuery(" from Usuario u where u.username = :username ");
		query.setParameter("username", usuario.getUsername());
		return (Usuario) query.getSingleResult();
	}

}
