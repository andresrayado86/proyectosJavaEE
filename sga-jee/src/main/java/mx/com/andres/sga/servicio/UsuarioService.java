package mx.com.andres.sga.servicio;

import java.util.List;

import javax.ejb.Local;

import mx.com.andres.sga.domain.Usuario;

@Local
public interface UsuarioService {
	
	public List<Usuario> listarUsuarios();
	
	public Usuario buscarUsuarioPorId(Usuario usuario);
	
	public Usuario buscarUsuarioPorUsername(Usuario usuario);
	
	public void insertarUsuario(Usuario usuario);
	
	public void modificarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Usuario usuario);

}
