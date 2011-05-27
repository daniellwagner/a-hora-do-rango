package excecoes;

public class MomentoInvalidoDaCriacaoDoPerfilException extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	public MomentoInvalidoDaCriacaoDoPerfilException(String mensagemDoErro)
	{
		super(mensagemDoErro);
	}
}
