package excecoes;

public class OpiniaoInvalidaException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public OpiniaoInvalidaException(String mensagemDoErro)
	{
		super(mensagemDoErro);
	}
}
