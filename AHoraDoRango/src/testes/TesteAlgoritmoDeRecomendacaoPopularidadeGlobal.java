package testes;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ahoradorango.AlgoritmoDeRecomendacaoPopularidadeGlobal;
import ahoradorango.Estabelecimento;
import ahoradorango.Perfil;
import ahoradorango.TipoDeAlmoco;
import ahoradorango.Usuario;
import excecoes.ListaDeEstabelecimentosInvalidaException;
import excecoes.ListaDeUsuariosInvalidaException;
import excecoes.NumeroDeRecomendacoesInvalidoException;
//import excecoes.NomeInvalidoException;
//import excecoes.EnderecoInvalidoException;
//import excecoes.EstabelecimentoInvalidoException;
//import excecoes.IndiceInvalidoDoEstabelecimentoNoPerfilException;


public class TesteAlgoritmoDeRecomendacaoPopularidadeGlobal 
{
	ArrayList<Integer> opinioes1;
	ArrayList<Integer> opinioes2;
	ArrayList<Integer> opinioes3;
	ArrayList<Estabelecimento> estabelecimentosTeste1;
	Perfil perfil1;
	Perfil perfil2;
	Perfil perfil3;
	Usuario usuario1;
	Usuario usuario2;
	Usuario usuario3;
	ArrayList<Usuario> usuarios;
	ArrayList<Estabelecimento> recomendacaoTeste;
	
	@Before
	public void setUp() throws Exception 
	{
		opinioes1 = new ArrayList<Integer>();
		opinioes2 = new ArrayList<Integer>();
		opinioes3 = new ArrayList<Integer>();
		
		opinioes1.add(2);
		opinioes1.add(1);
		opinioes1.add(0);
		
		opinioes2.add(2);
		opinioes2.add(1);
		opinioes2.add(0);
		
		opinioes3.add(2);
		opinioes3.add(1);
		opinioes3.add(0);
		
		estabelecimentosTeste1 = new ArrayList<Estabelecimento>();
		
		estabelecimentosTeste1.add(new Estabelecimento("Padaria", "rua 000", TipoDeAlmoco.A_LA_CARTE));
		estabelecimentosTeste1.add(new Estabelecimento("Panificadora", "rua 111", TipoDeAlmoco.PRATO_FEITO));
		estabelecimentosTeste1.add(new Estabelecimento("Mercado", "rua 222", TipoDeAlmoco.SELF_SERVICE));
		
		perfil1 = new Perfil(opinioes1, estabelecimentosTeste1, new GregorianCalendar(12, 12, 12));
		perfil2 = new Perfil(opinioes2, estabelecimentosTeste1, new GregorianCalendar(12, 12, 12));
		perfil3 = new Perfil(opinioes3, estabelecimentosTeste1, new GregorianCalendar(12, 12, 12));
	
		usuario1 = new Usuario("Usuario 1", perfil1);
		usuario2 = new Usuario("Usuario 2", perfil2);
		usuario3 = new Usuario("Usuario 3", perfil3);
		
		usuarios = new ArrayList<Usuario>();
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		
		recomendacaoTeste = new ArrayList<Estabelecimento>();
	}

	@Test
	public void testGeraRecomendacao() 
	{
		try
		{
			AlgoritmoDeRecomendacaoPopularidadeGlobal.geraRecomendacao(-1, estabelecimentosTeste1, usuarios);
			Assert.fail("Uma excecao de tipo NumeroDeRecomendacoesInvalidoException era esperada ao passar ao"
					+ " metodo geraRecomendacao numero de recomendacoes negativo.");
		}
		catch (NumeroDeRecomendacoesInvalidoException e)
		{
			
		} 
		catch (ListaDeEstabelecimentosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeEstabelecimentosInvalidaException foi"
					+ " lancada ao passar ao metodo geraRecomendacao numero de recomendacoes negativo, "
					+ " lista de estabelecimentos valida e lista de usuarios valida.");
			Assert.fail();
		}
		catch (ListaDeUsuariosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeUsuariosInvalidaException foi"
					+ " lancada ao passar ao metodo geraRecomendacao numero de recomendacoes negativo, "
					+ " lista de estabelecimentos valida e lista de usuarios valida.");
			Assert.fail();
		}
		
		
		
		
		try
		{
			AlgoritmoDeRecomendacaoPopularidadeGlobal.geraRecomendacao(estabelecimentosTeste1.size(), null, usuarios);
			Assert.fail("Uma excecao de tipo ListaDeEstabelecimentosInvalidaException era esperada ao passar ao"
					+ " metodo geraRecomendacao lista de estabelecimentos nula.");
		}
		catch (NumeroDeRecomendacoesInvalidoException e)
		{
			System.err.println("Uma excecao inesperada de tipo NumeroDeRecomendacoesInvalidoException foi"
					+ " lancada ao passar ao metodo geraRecomendacao numero de recomendacoes valido, "
					+ " lista de estabelecimentos nula e lista de usuarios valida.");
			Assert.fail();
		} 
		catch (ListaDeEstabelecimentosInvalidaException e) 
		{
			
		}
		catch (ListaDeUsuariosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeUsuariosInvalidaException foi"
					+ " lancada ao passar ao metodo geraRecomendacao numero de recomendacoes valido, "
					+ " lista de estabelecimentos nula e lista de usuarios valida.");
			Assert.fail();
		}
		
		
		
		
		try
		{
			AlgoritmoDeRecomendacaoPopularidadeGlobal.geraRecomendacao(estabelecimentosTeste1.size(), estabelecimentosTeste1, null);
			Assert.fail("Uma excecao de tipo ListaDeUsuariosInvalidaException era esperada ao passar ao"
					+ " metodo geraRecomendacao lista de usuarios nula.");
		}
		catch (NumeroDeRecomendacoesInvalidoException e)
		{
			System.err.println("Uma excecao inesperada de tipo NumeroDeRecomendacoesInvalidoException foi"
					+ " lancada ao passar ao metodo geraRecomendacao numero de recomendacoes valido, "
					+ " lista de estabelecimentos valida e lista de usuarios nula.");
			Assert.fail();
		} 
		catch (ListaDeEstabelecimentosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeEstabelecimentosInvalidaException foi"
					+ " lancada ao passar ao metodo geraRecomendacao numero de recomendacoes valido, "
					+ " lista de estabelecimentos valida e lista de usuarios nula.");
			Assert.fail();
		}
		catch (ListaDeUsuariosInvalidaException e) 
		{
			
		}
		
		
		
		try
		{
			AlgoritmoDeRecomendacaoPopularidadeGlobal.geraRecomendacao(estabelecimentosTeste1.size() + 1, estabelecimentosTeste1, usuarios);
			Assert.fail("Uma excecao de tipo NumeroDeRecomendacoesInvalidoException era esperada ao passar ao"
					+ " metodo geraRecomendacao numero de recomendacoes maior do que o numero de estabelecimentos.");
		}
		catch (NumeroDeRecomendacoesInvalidoException e)
		{
			
		} 
		catch (ListaDeEstabelecimentosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeEstabelecimentosInvalidaException foi"
					+ " lancada ao passar ao metodo geraRecomendacao numero de recomendacoes maior do que o "
					+ " numero de estabelecimentos, lista de estabelecimentos valida e lista de usuarios valida.");
			Assert.fail();
		}
		catch (ListaDeUsuariosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeUsuariosInvalidaException foi"
					+ " lancada ao passar ao metodo geraRecomendacao numero de recomendacoes maior do que o "
					+ " numero de estabelecimentos, lista de estabelecimentos valida e lista de usuarios valida.");
			Assert.fail();
		}
		
		
		
		try
		{
			AlgoritmoDeRecomendacaoPopularidadeGlobal.geraRecomendacao(estabelecimentosTeste1.size(), new ArrayList<Estabelecimento>(),
					usuarios);
			Assert.fail("Uma excecao de tipo ListaDeEstabelecimentosInvalidaException era esperada ao passar ao"
					+ " metodo geraRecomendacao lista de estabelecimentos vazia.");
		}
		catch (NumeroDeRecomendacoesInvalidoException e)
		{
			System.err.println("Uma excecao inesperada de tipo NumeroDeRecomendacoesInvalidoException foi"
					+ " lancada ao passar ao metodo geraRecomendacao numero de recomendacoes valido,"
					+ " lista de estabelecimentos vazia e lista de usuarios valida.");
			Assert.fail();
		} 
		catch (ListaDeEstabelecimentosInvalidaException e) 
		{
			
		}
		catch (ListaDeUsuariosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeUsuariosInvalidaException foi"
					+ " lancada ao passar ao metodo geraRecomendacao numero de recomendacoes valido,"
					+ " lista de estabelecimentos vazia e lista de usuarios valida.");
			Assert.fail();
		}
		
		
		
		try
		{
			AlgoritmoDeRecomendacaoPopularidadeGlobal.geraRecomendacao(estabelecimentosTeste1.size(), estabelecimentosTeste1,
					new ArrayList<Usuario>());
			Assert.fail("Uma excecao de tipo ListaDeUsuariosInvalidaException era esperada ao passar ao"
					+ " metodo geraRecomendacao lista de usuarios vazia.");
		}
		catch (NumeroDeRecomendacoesInvalidoException e)
		{
			System.err.println("Uma excecao inesperada de tipo NumeroDeRecomendacoesInvalidoException foi"
					+ " lancada ao passar ao metodo geraRecomendacao numero de recomendacoes valido,"
					+ " lista de estabelecimentos valida e lista de usuarios vazia.");
			Assert.fail();
		} 
		catch (ListaDeEstabelecimentosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeEstabelecimentosInvalidaException foi"
					+ " lancada ao passar ao metodo geraRecomendacao numero de recomendacoes valido,"
					+ " lista de estabelecimentos valida e lista de usuarios vazia.");
			Assert.fail();
		}
		catch (ListaDeUsuariosInvalidaException e) 
		{
			
		}
		
		
		
		try
		{
			for (int numeroDeRecomendacoes = 1; numeroDeRecomendacoes <= 3; numeroDeRecomendacoes++)
			{
				recomendacaoTeste.add(estabelecimentosTeste1.get(numeroDeRecomendacoes - 1));
				Assert.assertEquals("O metodo getRecomendacao nao retornou a lista de estabelecimentos correta.",
						recomendacaoTeste,
						AlgoritmoDeRecomendacaoPopularidadeGlobal.geraRecomendacao(numeroDeRecomendacoes, estabelecimentosTeste1, usuarios));
			}
			
			System.out.println("O metodo geraRecomendacao passou em todos os testes.");
		}
		catch (NumeroDeRecomendacoesInvalidoException e)
		{
			System.err.println("Uma excecao inesperada de tipo NumeroDeRecomendacoesInvalidoException foi lancada"
					+ " ao passar ao metodo geraRecomendacao argumentos validos.");
		} 
		catch (ListaDeEstabelecimentosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeEstabelecimentosInvalidaException foi lancada"
					+ " ao passar ao metodo geraRecomendacao argumentos validos.");
		}
		catch (ListaDeUsuariosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeUsuariosInvalidaException foi lancada"
					+ " ao passar ao metodo geraRecomendacao argumentos validos.");
		}
		
	}

}
