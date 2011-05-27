package excecoes;

public class PermissaoDeAlteracaoInvalidaException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public PermissaoDeAlteracaoInvalidaException(String mensagemDoErro)
	{
		super(mensagemDoErro);
	}
}
