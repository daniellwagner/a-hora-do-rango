package excecoes;

public class IndiceInvalidoDoEstabelecimentoNoPerfilException extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	public IndiceInvalidoDoEstabelecimentoNoPerfilException(String mensagemDoErro)
	{
		super(mensagemDoErro);
	}
}
