package testes;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ahoradorango.Alteravel;
import ahoradorango.Estabelecimento;
import ahoradorango.Perfil;
import ahoradorango.TipoDeAlmoco;
import excecoes.EnderecoInvalidoException;
import excecoes.EstabelecimentoInvalidoException;
import excecoes.ListaDeEstabelecimentosInvalidaException;
import excecoes.ListaDeOpinioesEDeEstabelecimentosIncompativeisException;
import excecoes.ListaDeOpinioesInvalidaException;
import excecoes.MomentoInvalidoDaCriacaoDoPerfilException;
import excecoes.NomeInvalidoException;
import excecoes.OpiniaoInvalidaException;
import excecoes.PerfilNaoAlteravelException;
import excecoes.PermissaoDeAlteracaoInvalidaException;
import excecoes.TipoDeAlmocoInvalidoException;

public class TestePerfil 
{
	private Perfil perfilTeste1;
	private HashMap<Estabelecimento, Integer> estabelecimentosOpinioesTeste1;
	private ArrayList<Estabelecimento> estabelecimentosTeste1;
	private ArrayList<Integer> opinioesTeste1;
	private ArrayList<Integer> opinioesTeste2Invalida;
	private GregorianCalendar momentoCriacaoPerfilTeste1;
	
	@Before
	public void setUp() throws Exception
	{
		estabelecimentosTeste1 = new ArrayList<Estabelecimento>();
		
		estabelecimentosTeste1.add(new Estabelecimento("Padaria", "rua 000", TipoDeAlmoco.A_LA_CARTE));
		estabelecimentosTeste1.add(new Estabelecimento("Panificadora", "rua 111", TipoDeAlmoco.PRATO_FEITO));
		estabelecimentosTeste1.add(new Estabelecimento("Mercado", "rua 222", TipoDeAlmoco.SELF_SERVICE));
		
		opinioesTeste1 = new ArrayList<Integer>();
		
		opinioesTeste1.add(0);
		opinioesTeste1.add(1);
		opinioesTeste1.add(-1);
		
		opinioesTeste2Invalida = new ArrayList<Integer>();
		
		opinioesTeste2Invalida.add(Perfil.MAIOR_OPINIAO_POSSIVEL + 1);
		opinioesTeste2Invalida.add(Perfil.MENOR_OPINIAO_POSSIVEL - 1);
		opinioesTeste2Invalida.add(-1);
		
		estabelecimentosOpinioesTeste1 = new HashMap<Estabelecimento, Integer>();
		
		for (int iter = 0; iter < opinioesTeste1.size(); iter++)
		{
			estabelecimentosOpinioesTeste1.put(estabelecimentosTeste1.get(iter), opinioesTeste1.get(iter));
		}
		
		momentoCriacaoPerfilTeste1 = new GregorianCalendar(1999, 12, 12);
		
		perfilTeste1 = new Perfil(opinioesTeste1, estabelecimentosTeste1, momentoCriacaoPerfilTeste1);
	}

	@Test
	public void testePerfil() throws NomeInvalidoException, EnderecoInvalidoException, TipoDeAlmocoInvalidoException
	{
		try 
		{
			perfilTeste1 = new Perfil(null, estabelecimentosTeste1, momentoCriacaoPerfilTeste1);
			Assert.fail("Uma excecao de tipo ListaDeOpinioesInvalidaException era esperada em testePerfil ao passar ao"
						+ " construtor lista de opinioes nula.");
		}
		catch (ListaDeOpinioesInvalidaException e) 
		{
			
		} 
		catch (OpiniaoInvalidaException e)
		{
			System.err.println("Uma excecao inesperada de tipo OpiniaoInvalidaException foi lancada pelo construtor" +
								" ao passar para ele lista de opinioes nula, lista de estabelecimentos valida "
								+ "e momento da criacao do perfil valido.");
			Assert.fail();
		}
		catch (ListaDeEstabelecimentosInvalidaException e)
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeEstabelecimentosInvalidaException foi lancada " +
								"pelo construtor ao passar para ele lista de opinioes nula, lista de estabelecimentos valida "
								+ "e momento da criacao do perfil valido.");
			Assert.fail();
		} 
		catch (ListaDeOpinioesEDeEstabelecimentosIncompativeisException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeOpinioesEDeEstabelecimentosIncompativeisException foi lancada " +
								"pelo construtor ao passar para ele lista de opinioes nula, lista de estabelecimentos valida "
								+ "e momento da criacao do perfil valido.");
			Assert.fail();
		}
		catch (MomentoInvalidoDaCriacaoDoPerfilException e)
		{
			System.err.println("Uma excecao inesperada de tipo MomentoInvalidoDaCriacaoDoPerfilException foi lancada " +
								"pelo construtor ao passar para ele lista de opinioes nula, lista de estabelecimentos valida "
								+ "e momento da criacao do perfil valido.");
			Assert.fail();
		}
		
		
		
		try 
		{
			perfilTeste1 = new Perfil(opinioesTeste1, null, momentoCriacaoPerfilTeste1);
			Assert.fail("Uma excecao de tipo ListaDeEstabelecimentosInvalidaException era esperada em testePerfil ao passar ao"
							+ " construtor lista de estabelecimentos nula.");
		}
		catch (ListaDeOpinioesInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeOpinioesInvalidaException foi lancada pelo construtor" +
								" ao passar para ele lista de opinioes valida, lista de estabelecimentos nula "
								+ "e momento da criacao do perfil valido.");
			Assert.fail();
		} 
		catch (OpiniaoInvalidaException e)
		{
			System.err.println("Uma excecao inesperada de tipo OpiniaoInvalidaException foi lancada pelo construtor" +
								" ao passar para ele lista de opinioes valida, lista de estabelecimentos nula "
								+ "e momento da criacao do perfil valido.");
			Assert.fail();
		}
		catch (ListaDeEstabelecimentosInvalidaException e)
		{
			
		} 
		catch (ListaDeOpinioesEDeEstabelecimentosIncompativeisException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeOpinioesEDeEstabelecimentosIncompativeisException foi lancada " +
								"pelo construtor ao passar para ele lista de opinioes valida, lista de estabelecimentos nula "
								+ "e momento da criacao do perfil valido.");
			Assert.fail();
		} 
		catch (MomentoInvalidoDaCriacaoDoPerfilException e) 
		{
			System.err.println("Uma excecao inesperada de tipo MomentoInvalidoDaCriacaoDoPerfilException foi lancada pelo construtor" +
								" ao passar para ele lista de opinioes valida, lista de estabelecimentos nula "
								+ "e momento da criacao do perfil valido.");
			Assert.fail();
		}
		
		
		
		try 
		{
			perfilTeste1 = new Perfil(opinioesTeste1, estabelecimentosTeste1, null);
			Assert.fail("Uma excecao de tipo MomentoInvalidoDaCriacaoDoPerfilException era esperada em testePerfil ao passar ao"
							+ " construtor momento da criacao do perfil nulo.");
		}
		catch (ListaDeOpinioesInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeOpinioesInvalidaException foi lancada pelo construtor" +
								" ao passar para ele lista de opinioes valida, lista de estabelecimentos valida "
								+ "e momento da criacao do perfil nulo.");
			Assert.fail();
		} 
		catch (OpiniaoInvalidaException e)
		{
			System.err.println("Uma excecao inesperada de tipo OpiniaoInvalidaException foi lancada pelo construtor" +
								" ao passar para ele lista de opinioes valida, lista de estabelecimentos valida "
								+ "e momento da criacao do perfil nulo.");
			Assert.fail();
		}
		catch (ListaDeEstabelecimentosInvalidaException e)
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeEstabelecimentosInvalidaException foi lancada pelo construtor" +
								" ao passar para ele lista de opinioes valida, lista de estabelecimentos valida "
								+ "e momento da criacao do perfil nulo.");
			Assert.fail();
		} 
		catch (ListaDeOpinioesEDeEstabelecimentosIncompativeisException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeOpinioesEDeEstabelecimentosIncompativeisException foi lancada " +
								"pelo construtor ao passar para ele lista de opinioes valida, lista de estabelecimentos valida "
								+ "e momento da criacao do perfil nulo.");
			Assert.fail();
		} 
		catch (MomentoInvalidoDaCriacaoDoPerfilException e) 
		{
			
		}
		
		
		
		try 
		{
			perfilTeste1 = new Perfil(opinioesTeste2Invalida, estabelecimentosTeste1, momentoCriacaoPerfilTeste1);
			Assert.fail("Uma excecao de tipo OpiniaoInvalidaException era esperada em testePerfil ao passar ao"
						+ " construtor lista de opinioes com opinioes invalidas.");
		}
		catch (ListaDeOpinioesInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeOpinioesInvalidaException foi lancada pelo construtor" +
						" ao passar para ele lista de opinioes com opinioes invalidas, lista de estabelecimentos valida "
						+ "e momento da criacao do perfil valido.");
			Assert.fail();
		} 
		catch (OpiniaoInvalidaException e)
		{
			
		}
		catch (ListaDeEstabelecimentosInvalidaException e)
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeEstabelecimentosInvalidaException foi lancada " +
								"pelo construtor ao passar para ele lista de opinioes com opinioes invalidas, "
								+ "lista de estabelecimentos valida e momento da criacao do perfil valido.");
			Assert.fail();
		} 
		catch (ListaDeOpinioesEDeEstabelecimentosIncompativeisException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeOpinioesEDeEstabelecimentosIncompativeisException foi lancada " +
								"pelo construtor ao passar para ele lista de opinioes com opinioes invalidas, lista de estabelecimentos valida "
								+ "e momento da criacao do perfil valido.");
			Assert.fail();
		}
		catch (MomentoInvalidoDaCriacaoDoPerfilException e)
		{
			System.err.println("Uma excecao inesperada de tipo MomentoInvalidoDaCriacaoDoPerfilException foi lancada " +
								"pelo construtor ao passar para ele lista de opinioes com opinioes invalidas, lista de estabelecimentos valida "
								+ "e momento da criacao do perfil valido.");
			Assert.fail();
		}
		
		
		
		
		estabelecimentosTeste1.remove(0);
		
		try 
		{
			perfilTeste1 = new Perfil(opinioesTeste1, estabelecimentosTeste1, momentoCriacaoPerfilTeste1);
			Assert.fail("Uma excecao de tipo MomentoInvalidoDaCriacaoDoPerfilException era esperada em testePerfil ao passar ao"
						+ " construtor lista de opinioes de tamanho diferente da lista de estabelecimentos.");
		}
		catch (ListaDeOpinioesInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeOpinioesInvalidaException foi lancada pelo construtor" +
						" ao passar para ele lista de opinioes e lista de estabelecimentos validas e de tamanhos diferentes "
						+ " e momento da criacao do perfil valido.");
			Assert.fail();
		} 
		catch (OpiniaoInvalidaException e)
		{
			System.err.println("Uma excecao inesperada de tipo OpiniaoInvalidaException foi lancada pelo construtor" +
					" ao passar para ele lista de opinioes e lista de estabelecimentos validas e de tamanhos diferentes "
					+ " e momento da criacao do perfil valido.");
			Assert.fail();
		}
		catch (ListaDeEstabelecimentosInvalidaException e)
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeEstabelecimentosInvalidaException foi lancada pelo construtor" +
					" ao passar para ele lista de opinioes e lista de estabelecimentos validas e de tamanhos diferentes "
					+ " e momento da criacao do perfil valido.");
			Assert.fail();
		} 
		catch (ListaDeOpinioesEDeEstabelecimentosIncompativeisException e) 
		{
			
		}
		catch (MomentoInvalidoDaCriacaoDoPerfilException e)
		{
			System.err.println("Uma excecao inesperada de tipo MomentoInvalidoDaCriacaoDoPerfilException foi lancada pelo construtor" +
					" ao passar para ele lista de opinioes e lista de estabelecimentos validas e de tamanhos diferentes "
					+ " e momento da criacao do perfil valido.");
			Assert.fail();
		}
		
		
		
		opinioesTeste1.clear();
		
		try 
		{
			perfilTeste1 = new Perfil(opinioesTeste1, estabelecimentosTeste1, momentoCriacaoPerfilTeste1);
			Assert.fail("Uma excecao de tipo ListaDeOpinioesInvalidaException era esperada em testePerfil ao passar ao"
						+ " construtor lista de opinioes vazia.");
		}
		catch (ListaDeOpinioesInvalidaException e) 
		{
		
		} 
		catch (OpiniaoInvalidaException e)
		{
			System.err.println("Uma excecao inesperada de tipo OpiniaoInvalidaException foi lancada pelo construtor" +
					" ao passar para ele lista de opinioes vazia, lista de estabelecimentos valida"
					+ " e momento da criacao do perfil valido.");
			Assert.fail();
		}
		catch (ListaDeEstabelecimentosInvalidaException e)
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeEstabelecimentosInvalidaException foi lancada pelo construtor" +
					" ao passar para ele lista de opinioes vazia, lista de estabelecimentos valida"
					+ " e momento da criacao do perfil valido.");
			Assert.fail();
		} 
		catch (ListaDeOpinioesEDeEstabelecimentosIncompativeisException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeOpinioesEDeEstabelecimentosIncompativeisException" +
					" foi lancada pelo construtor ao passar para ele lista de opinioes vazia, lista de estabelecimentos valida"
					+ " e momento da criacao do perfil valido.");
			Assert.fail();
		}
		catch (MomentoInvalidoDaCriacaoDoPerfilException e)
		{
			System.err.println("Uma excecao inesperada de tipo MomentoInvalidoDaCriacaoDoPerfilException foi lancada pelo construtor" +
					" ao passar para ele lista de opinioes vazia, lista de estabelecimentos valida"
					+ " e momento da criacao do perfil valido.");
			Assert.fail();
		}
		
		opinioesTeste1.add(0);
		
		estabelecimentosTeste1.clear();
		
		try 
		{
			perfilTeste1 = new Perfil(opinioesTeste1, estabelecimentosTeste1, momentoCriacaoPerfilTeste1);
			Assert.fail("Uma excecao de tipo ListaDeEstabelecimentosInvalidaException era esperada em testePerfil ao passar ao"
						+ " construtor lista de estabelecimentos vazia.");
		}
		catch (ListaDeOpinioesInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeOpinioesInvalidaException foi lancada pelo construtor" +
					" ao passar para ele lista de opinioes valida, lista de estabelecimentos vazia"
					+ " e momento da criacao do perfil valido.");
			Assert.fail();
		} 
		catch (OpiniaoInvalidaException e)
		{
			System.err.println("Uma excecao inesperada de tipo OpiniaoInvalidaException foi lancada pelo construtor" +
					" ao passar para ele lista de opinioes valida, lista de estabelecimentos vazia"
					+ " e momento da criacao do perfil valido.");
			Assert.fail();
		}
		catch (ListaDeEstabelecimentosInvalidaException e)
		{
		
		} 
		catch (ListaDeOpinioesEDeEstabelecimentosIncompativeisException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeOpinioesEDeEstabelecimentosIncompativeisException" +
					" foi lancada pelo construtor ao passar para ele lista de opinioes valida, lista de estabelecimentos vazia"
					+ " e momento da criacao do perfil valido.");
			Assert.fail();
		}
		catch (MomentoInvalidoDaCriacaoDoPerfilException e)
		{
			System.err.println("Uma excecao inesperada de tipo MomentoInvalidoDaCriacaoDoPerfilException foi lancada pelo construtor" +
					" ao passar para ele lista de opinioes valida, lista de estabelecimentos vazia"
					+ " e momento da criacao do perfil valido.");
			Assert.fail();
		}
		
		opinioesTeste1.clear();
		estabelecimentosTeste1.clear();
		
		
		opinioesTeste1.add(0);
		opinioesTeste1.add(1);
		opinioesTeste1.add(-1);
		
		estabelecimentosTeste1.add(new Estabelecimento("Padaria", "rua 000", TipoDeAlmoco.A_LA_CARTE));
		estabelecimentosTeste1.add(new Estabelecimento("Panificadora", "rua 111", TipoDeAlmoco.PRATO_FEITO));
		estabelecimentosTeste1.add(new Estabelecimento("Mercado", "rua 222", TipoDeAlmoco.SELF_SERVICE));
		
		try 
		{
			
			perfilTeste1 = new Perfil(opinioesTeste1, estabelecimentosTeste1, momentoCriacaoPerfilTeste1);
			
			Assert.assertEquals("O campo momentoCriacaoDoPerfil nao foi inicializado corretamente.", 
						momentoCriacaoPerfilTeste1, perfilTeste1.getMomentoCriacaoDoPerfil());
			Assert.assertEquals("O campo perfilAlteravel nao foi inicializado corretamente.",
						Alteravel.NAO, perfilTeste1.getPerfilAlteravel());
		
		}
		catch (ListaDeOpinioesInvalidaException e) 
		{
			System.out.println("Uma excecao inesperada de tipo ListaDeOpinioesInvalidaException foi lancada "
					+ "quando argumentos validos foram passados ao construtor.");
		} 
		catch (OpiniaoInvalidaException e) 
		{
			System.out.println("Uma excecao inesperada de tipo OpiniaoInvalidaException foi lancada "
					+ "quando argumentos validos foram passados ao construtor.");
		} 
		catch (ListaDeEstabelecimentosInvalidaException e)
		{
			System.out.println("Uma excecao inesperada de tipo ListaDeEstabelecimentosInvalidaException foi lancada "
					+ "quando argumentos validos foram passados ao construtor.");
		} 
		catch (ListaDeOpinioesEDeEstabelecimentosIncompativeisException e)
		{
			System.out.println("Uma excecao inesperada de tipo ListaDeOpinioesEDeEstabelecimentosIncompativeisException foi lancada "
					+ "quando argumentos validos foram passados ao construtor.");
		} 
		catch (MomentoInvalidoDaCriacaoDoPerfilException e) 
		{
			System.out.println("Uma excecao inesperada de tipo MomentoInvalidoDaCriacaoDoPerfilException foi lancada "
					+ "quando argumentos validos foram passados ao construtor.");
		}
	}

	@Test
	public void testeSetPerfilAlteravel() 
	{
		try
		{
			perfilTeste1.setPerfilAlteravel(null);
			Assert.fail("Uma excecao de tipo PermissaoDeAlteracaoInvalidaException era esperada em "
					+ "testeSetPerfilAlteravel ao passar nulo como argumento ao metodo setPerfilAlteravel.");
		} 
		catch (PermissaoDeAlteracaoInvalidaException e) 
		{
			
		}
		
		try 
		{
			perfilTeste1.setPerfilAlteravel(Alteravel.SIM);
			Assert.assertEquals("O metodo setPerfilAlteravel nao alterou corretamente o campo perfilAlteravel."
					, Alteravel.SIM, perfilTeste1.getPerfilAlteravel());
		} 
		catch (PermissaoDeAlteracaoInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo PermissaoDeAlteracaoInvalidaException foi lancada"
					+ " pelo metodo setPerfilAlteravel ao passar para ele argumento valido.");
			Assert.fail();
		}
		
		try 
		{
			perfilTeste1.setPerfilAlteravel(Alteravel.NAO);
			Assert.assertEquals("O metodo setPerfilAlteravel nao alterou corretamente o campo perfilAlteravel."
					, Alteravel.NAO, perfilTeste1.getPerfilAlteravel());
			System.out.println("O metodo setPerfilAlteravel passou em todos os testes.");
		} 
		catch (PermissaoDeAlteracaoInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo PermissaoDeAlteracaoInvalidaException foi lancada"
					+ " pelo metodo setPerfilAlteravel ao passar para ele argumento valido.");
			Assert.fail();
		}
	}

	@Test
	public void testeSetOpiniao() throws PermissaoDeAlteracaoInvalidaException, NomeInvalidoException, EnderecoInvalidoException, TipoDeAlmocoInvalidoException
	{
		try 
		{
			perfilTeste1.setOpiniao(null, 0);
			Assert.fail("Uma excecao de tipo PerfilNaoAlteravelException era esperada ao tentar "
					+ "alterar perfil nao alteravel.");
		} 
		catch (EstabelecimentoInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo EstabelecimentoInvalidoException foi lancada ao "
					+ "tentar alterar perfil nao alteravel.");
			Assert.fail();
		} 
		catch (OpiniaoInvalidaException e)
		{
			System.err.println("Uma excecao inesperada de tipo OpiniaoInvalidaException foi lancada ao "
					+ "tentar alterar perfil nao alteravel.");
			Assert.fail();
		} 
		catch (PerfilNaoAlteravelException e) 
		{
			
		}
		
		
		perfilTeste1.setPerfilAlteravel(Alteravel.SIM);
		
		try 
		{
			perfilTeste1.setOpiniao(null, 0);
			Assert.fail("Uma excecao de tipo EstabelecimentoInvalidoException era esperada ao passar "
					+ "estabelecimento nulo como argumento.");
		} 
		catch (EstabelecimentoInvalidoException e) 
		{
			
		} 
		catch (OpiniaoInvalidaException e)
		{
			System.err.println("Uma excecao inesperada de tipo OpiniaoInvalidaException foi lancada ao "
					+ "passar estabelecimento nulo como argumento e opiniao valida.");
			Assert.fail();
		} 
		catch (PerfilNaoAlteravelException e) 
		{
			System.err.println("Uma excecao inesperada de tipo PerfilNaoAlteravelException foi lancada ao "
					+ "tentar alterar um perfil alteravel.");
			Assert.fail();
		}
		
		
		
		try 
		{
			perfilTeste1.setOpiniao(new Estabelecimento("farmacia", "rua 555", TipoDeAlmoco.A_LA_CARTE), Perfil.MAIOR_OPINIAO_POSSIVEL + 1);
			Assert.fail("Uma excecao de tipo EstabelecimentoInvalidoException era esperada ao passar como argumento "
					+ "estabelecimento que nao pertence a lista de estabelecimentos do perfil.");
		} 
		catch (EstabelecimentoInvalidoException e) 
		{
			
		} 
		catch (OpiniaoInvalidaException e)
		{
			System.err.println("Uma excecao inesperada de tipo OpiniaoInvalidaException foi lancada ao "
					+ "passar como argumento estabelecimento que nao pertence a lista de estabelecimentos do perfil.");
			Assert.fail();
		} 
		catch (PerfilNaoAlteravelException e) 
		{
			System.err.println("Uma excecao inesperada de tipo PerfilNaoAlteravelException foi lancada ao "
					+ "tentar alterar um perfil alteravel.");
			Assert.fail();
		}
		
	
		
		try 
		{
			perfilTeste1.setOpiniao(estabelecimentosTeste1.get(0), Perfil.MENOR_OPINIAO_POSSIVEL - 1);
			Assert.fail("Uma excecao de tipo OpiniaoInvalidaException era esperada ao passar como argumento "
					+ "valor de opiniao menor do que o permitido.");
		} 
		catch (EstabelecimentoInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo EstabelecimentoInvalidoException foi lancada ao "
					+ "passar estabelecimento valido como argumento e valor de opiniao menor do que o permitido.");
			Assert.fail();
		} 
		catch (OpiniaoInvalidaException e)
		{
			
		} 
		catch (PerfilNaoAlteravelException e) 
		{
			System.err.println("Uma excecao inesperada de tipo PerfilNaoAlteravelException foi lancada ao "
					+ "tentar alterar um perfil alteravel.");
			Assert.fail();
		}
		
		
		
		try 
		{
			perfilTeste1.setOpiniao(estabelecimentosTeste1.get(0), Perfil.MAIOR_OPINIAO_POSSIVEL + 1);
			Assert.fail("Uma excecao de tipo OpiniaoInvalidaException era esperada ao passar como argumento "
					+ "valor de opiniao maior do que o permitido.");
		} 
		catch (EstabelecimentoInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo EstabelecimentoInvalidoException foi lancada ao "
					+ "passar estabelecimento valido como argumento e valor de opiniao maior do que o permitido.");
			Assert.fail();
		} 
		catch (OpiniaoInvalidaException e)
		{
			
		} 
		catch (PerfilNaoAlteravelException e) 
		{
			System.err.println("Uma excecao inesperada de tipo PerfilNaoAlteravelException foi lancada ao "
					+ "tentar alterar um perfil alteravel.");
			Assert.fail();
		}
		
		
		
		try 
		{
			perfilTeste1.setOpiniao(estabelecimentosTeste1.get(0), -2);
			
			Assert.assertEquals("O metodo setOpiniao nao alterou corretamente a opiniao sobre o estabelecimento " + 
					estabelecimentosTeste1.get(0).getNome() + ".", -2, perfilTeste1.getOpiniao(estabelecimentosTeste1.get(0)));
			
			System.out.println("O metodo setOpiniao passou em todos os testes.");
		} 
		catch (EstabelecimentoInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo EstabelecimentoInvalidoException foi lancada ao "
					+ "passar ao metodo setOpiniao argumentos validos.");
			Assert.fail();
		} 
		catch (OpiniaoInvalidaException e)
		{
			System.err.println("Uma excecao inesperada de tipo OpiniaoInvalidaException foi lancada ao "
					+ "passar ao metodo setOpiniao argumentos validos.");
			Assert.fail();
		} 
		catch (PerfilNaoAlteravelException e) 
		{
			System.err.println("Uma excecao inesperada de tipo PerfilNaoAlteravelException foi lancada ao "
					+ "tentar alterar um perfil alteravel.");
			Assert.fail();
		}
		
	}

}
