package excecoes;

public class PerfilNaoAlteravelException extends Exception
{
	private static final long serialVersionUID = 1L;

	public PerfilNaoAlteravelException(String mensagemDoErro)
	{
		super(mensagemDoErro);
	}
}
