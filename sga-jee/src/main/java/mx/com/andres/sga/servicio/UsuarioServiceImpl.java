package mx.com.andres.sga.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import mx.com.andres.sga.domain.Usuario;
import mx.com.andres.sga.eis.UsuarioDao;

@Stateless
public class UsuarioServiceImpl implements UsuarioService, UsuarioServiceRemote{
	
	@EJB
	private UsuarioDao usuarioDao;

	@Override
	public List<Usuario> listarUsuarios() {
		
		return usuarioDao.findAllUsuarios();
	}

	@Override
	public Usuario buscarUsuarioPorId(Usuario usuario) {
		
		return usuarioDao.findUsuarioById(usuario);
	}

	@Override
	public Usuario buscarUsuarioPorUsername(Usuario usuario) {
		
		return usuarioDao.findUsuarioByUsername(usuario);
	}

	@Override
	public void insertarUsuario(Usuario usuario) {
		usuarioDao.insertUsuario(usuario);
		
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		usuarioDao.updateUsuario(usuario);
		
	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		usuarioDao.deleteUsuario(usuario);
		
	}

	

}
