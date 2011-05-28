package excecoes;

import ahoradorango.Usuario;

public class UsuarioInvalidoException extends Exception 
{
	private static final long serialVersionUID = 1L;
	private Usuario usuarioErro;
	
	public UsuarioInvalidoException(String mensagemDeErro, Usuario usuarioErro)
	{
		this.usuarioErro = usuarioErro;
	}
	
	public Usuario getUsuarioErro()
	{
		return usuarioErro;
	}
}
