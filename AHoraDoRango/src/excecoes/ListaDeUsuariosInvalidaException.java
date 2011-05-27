package excecoes;

import java.util.List;

import ahoradorango.Usuario;

public class ListaDeUsuariosInvalidaException extends Exception
{
	private static final long serialVersionUID = 1L;
	private List<Usuario> listaDeUsuarios;
	
	public ListaDeUsuariosInvalidaException(String mensagemDeErro, List<Usuario> listaDeUsuarios)
	{
		super(mensagemDeErro);
		
		this.listaDeUsuarios = listaDeUsuarios; 
	}

	public List<Usuario> getListaDeUsuarios() 
	{
		return listaDeUsuarios;
	}
}
