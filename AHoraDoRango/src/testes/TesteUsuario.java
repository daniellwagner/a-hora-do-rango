package testes;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ahoradorango.Alteravel;
import ahoradorango.Estabelecimento;
import ahoradorango.Perfil;
import ahoradorango.TipoDeAlmoco;
import ahoradorango.Usuario;
import excecoes.EstabelecimentoInvalidoException;
import excecoes.NomeInvalidoException;
import excecoes.OpiniaoInvalidaException;
import excecoes.PerfilInvalidoException;
import excecoes.PerfilNaoAlteravelException;
import excecoes.PermissaoDeAlteracaoInvalidaException;

public class TesteUsuario
{
	private Usuario usuarioTeste1;
	private String nomeTeste1;
	private Perfil perfilTeste1;
	private ArrayList<Integer> opinioesTeste1;
	private ArrayList<Estabelecimento> estabelecimentosTeste1;
	private GregorianCalendar momentoCriacaoDoPerfilTeste1;
	
	@Before
	public void setUp() throws Exception 
	{
		nomeTeste1 = "Deitel";
		
		opinioesTeste1 = new ArrayList<Integer>();
		
		opinioesTeste1.add(0);
		opinioesTeste1.add(-1);
		opinioesTeste1.add(1);
		
		estabelecimentosTeste1 = new ArrayList<Estabelecimento>();
		
		estabelecimentosTeste1.add(new Estabelecimento("Padaria", "rua 000", TipoDeAlmoco.A_LA_CARTE));
		estabelecimentosTeste1.add(new Estabelecimento("Panificadora", "rua 111", TipoDeAlmoco.PRATO_FEITO));
		estabelecimentosTeste1.add(new Estabelecimento("Mercado", "rua 222", TipoDeAlmoco.SELF_SERVICE));
		
		momentoCriacaoDoPerfilTeste1 = new GregorianCalendar(1999, 12, 12);
		
		perfilTeste1 = new Perfil(opinioesTeste1, estabelecimentosTeste1, momentoCriacaoDoPerfilTeste1);
		
		usuarioTeste1 = new Usuario(nomeTeste1, perfilTeste1);
	}

	@Test
	public void testeConstrutor()
	{
		try
		{
			usuarioTeste1 = new Usuario(null, perfilTeste1);
			Assert.fail("Uma excecao de tipo NomeInvalidoException era esperada em testeConstrutor ao passar ao construtor"
						+ " nome nulo e perfil valido.");
		}
		catch (NomeInvalidoException e) 
		{
			
		} 
		catch (PerfilInvalidoException e)
		{
			System.err.println("Uma excecao inesperada de tipo PerfilInvalidoException foi lancada pelo construtor quando foram passados "
					+ "como argumentos para ele nome nulo e perfil valido.");
			Assert.fail();
		}
		
		
		try
		{
			usuarioTeste1 = new Usuario(nomeTeste1, null);
			Assert.fail("Uma excecao de tipo PerfilInvalidoException era esperada em testeConstrutor ao passar ao construtor"
						+ " nome valido e perfil nulo.");
		}
		catch (NomeInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo NomeInvalidoException foi lancada pelo construtor quando foram passados "
					+ "como argumentos para ele nome valido e perfil nulo.");
			Assert.fail();
		} 
		catch (PerfilInvalidoException e)
		{
			
		}
		
		
		try 
		{
			usuarioTeste1 = new Usuario("", perfilTeste1);
			
			Assert.assertEquals("O construtor nao inicializou corretamente o campo nome.", "", usuarioTeste1.getNome());
			Assert.assertEquals("O construtor nao inicializou corretamente o campo perfil.", perfilTeste1, usuarioTeste1.getPerfil());
		} 
		catch (NomeInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo NomeInvalidoException foi lancada pelo construtor " 
					+ "ao passar para ele argumentos validos (nome vazio).");
		} 
		catch (PerfilInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo PerfilInvalidoException foi lancada pelo construtor " 
					+ "ao passar para ele argumentos validos (nome vazio).");
		}
		
		
		try 
		{
			usuarioTeste1 = new Usuario("   ", perfilTeste1);
			
			Assert.assertEquals("O construtor nao inicializou corretamente o campo nome.", "   ", usuarioTeste1.getNome());
			Assert.assertEquals("O construtor nao inicializou corretamente o campo perfil.", perfilTeste1, usuarioTeste1.getPerfil());
		} 
		catch (NomeInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo NomeInvalidoException foi lancada pelo construtor " 
					+ "ao passar para ele argumentos validos (nome com espacos em branco apenas).");
		} 
		catch (PerfilInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo PerfilInvalidoException foi lancada pelo construtor " 
					+ "ao passar para ele argumentos validos (nome com espacos em branco apenas).");
		}
		
		
		
		try 
		{
			usuarioTeste1 = new Usuario(nomeTeste1, perfilTeste1);
			
			Assert.assertEquals("O construtor nao inicializou corretamente o campo nome.", nomeTeste1, usuarioTeste1.getNome());
			Assert.assertEquals("O construtor nao inicializou corretamente o campo perfil.", perfilTeste1, usuarioTeste1.getPerfil());
			
			System.out.println("O construtor passou em todos os testes.");
		} 
		catch (NomeInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo NomeInvalidoException foi lancada pelo construtor " 
					+ "ao passar para ele argumentos validos.");
		} 
		catch (PerfilInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo PerfilInvalidoException foi lancada pelo construtor " 
					+ "ao passar para ele argumentos validos.");
		}
	}

	@Test
	public void testeMudaPermissaoAlteracao() throws PermissaoDeAlteracaoInvalidaException
	{
		usuarioTeste1.mudaPermissaoAlteracao(Alteravel.SIM);
		
		Assert.assertEquals("O metodo mudaPermissaoAlteracao nao alterou corretamente a permissao de alteracao.", 
				Alteravel.SIM, usuarioTeste1.getPerfil().getPerfilAlteravel());
		
		System.out.println("O metodo mudaPermissaoAlteracao passou em todos os testes.");
	}
	
	@Test
	public void testeEhUsuarioAlteravel() throws PermissaoDeAlteracaoInvalidaException
	{
		usuarioTeste1.mudaPermissaoAlteracao(Alteravel.SIM);
		
		Assert.assertEquals("O metodo ehUsuarioAlteravel nao retornou o valor correto.", 
				usuarioTeste1.getPerfil().getPerfilAlteravel() == Alteravel.SIM,
				usuarioTeste1.ehUsuarioAlteravel());
		
		usuarioTeste1.mudaPermissaoAlteracao(Alteravel.NAO);
		
		Assert.assertEquals("O metodo ehUsuarioAlteravel nao retornou o valor correto.", 
				usuarioTeste1.getPerfil().getPerfilAlteravel() == Alteravel.SIM,
				usuarioTeste1.ehUsuarioAlteravel());
	
		System.out.println("O metodo ehUsuarioAlteravel passou em todos os testes.");
	}
	
	@Test
	public void testeAlteraOpiniao() throws EstabelecimentoInvalidoException, OpiniaoInvalidaException, PerfilNaoAlteravelException, PermissaoDeAlteracaoInvalidaException
	{
		usuarioTeste1.mudaPermissaoAlteracao(Alteravel.SIM);
		
		usuarioTeste1.alterarOpiniao(estabelecimentosTeste1.get(0), 5);
		
		Assert.assertEquals("O metodo setOpiniao nao alterou corretamente a opiniao sobre o estabelecimento " + 
				estabelecimentosTeste1.get(0).getNome() + ".", 5, usuarioTeste1.getOpiniao(estabelecimentosTeste1.get(0)));
		
		System.out.println("O metodo alteraOpiniao passou em todos os testes.");
	}
	
	@Test
	public void testeGetOpiniao()
	{
		for (int iter = 0; iter < estabelecimentosTeste1.size(); iter++)
		{
			Assert.assertEquals("O metodo getOpiniao retornou um valor incorreto para o estabelecimento " 
					+ estabelecimentosTeste1.get(iter).getNome() + ".", (int) opinioesTeste1.get(iter), 
					(int) usuarioTeste1.getOpiniao(estabelecimentosTeste1.get(iter)));
		}
		
		System.out.println("O metodo getOpiniao passou em todos os testes.");
	}
}
