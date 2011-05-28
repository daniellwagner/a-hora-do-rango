package excecoes;

import java.util.HashMap;

import ahoradorango.Usuario;

public class MapeamentoUsuarioSemelhancaInvalidoException extends Exception 
{
	private static final long serialVersionUID = -4865921565749366654L;

	private HashMap<Usuario, Integer> mapeamentoErro;
	
	public MapeamentoUsuarioSemelhancaInvalidoException(String mensagemDeErro, HashMap<Usuario, Integer> mapeamentoErro)
	{
		super(mensagemDeErro);
		
		this.mapeamentoErro = mapeamentoErro;
	}

	public HashMap<Usuario, Integer> getMapeamentoErro() 
	{
		return mapeamentoErro;
	}
}
