package excecoes;

public class ListaDeOpinioesInvalidaException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public ListaDeOpinioesInvalidaException(String mensagemDoErro) 
	{
		super(mensagemDoErro);
	}
}
