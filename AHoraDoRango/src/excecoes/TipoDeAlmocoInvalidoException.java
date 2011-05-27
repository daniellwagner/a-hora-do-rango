package excecoes;

public class TipoDeAlmocoInvalidoException extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	public TipoDeAlmocoInvalidoException(String mensagemDoErro)
	{
		super(mensagemDoErro);
	}
}
