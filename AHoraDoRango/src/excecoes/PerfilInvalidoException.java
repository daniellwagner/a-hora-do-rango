package excecoes;

public class PerfilInvalidoException extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	public PerfilInvalidoException(String mensagemDoErro)
	{
		super(mensagemDoErro);
	}
}
