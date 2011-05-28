package testes;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ahoradorango.AlgoritmoDeRecomendacaoProdutoEscalar;
import ahoradorango.Alteravel;
import ahoradorango.Estabelecimento;
import ahoradorango.Perfil;
import ahoradorango.TipoDeAlmoco;
import ahoradorango.Usuario;
import excecoes.EstabelecimentoInvalidoException;
import excecoes.ListaDeEstabelecimentosInvalidaException;
import excecoes.ListaDeUsuariosInvalidaException;
import excecoes.MapeamentoUsuarioSemelhancaInvalidoException;
import excecoes.NumeroDeRecomendacoesInvalidoException;
import excecoes.OpiniaoInvalidaException;
import excecoes.PerfilNaoAlteravelException;
import excecoes.PermissaoDeAlteracaoInvalidaException;
import excecoes.UsuarioInvalidoException;

public class TesteAlgoritmoDeRecomendacaoProdutoEscalar
{
	private ArrayList<Integer> opinioes1;
	private ArrayList<Integer> opinioes2;
	private ArrayList<Integer> opinioes3;
	private ArrayList<Integer> opinioes4;
	private ArrayList<Integer> opinioes5;
	private ArrayList<Integer> opinioes6;
	private ArrayList<Estabelecimento> estabelecimentosTeste1;
	private Perfil perfil1;
	private Perfil perfil2;
	private Perfil perfil3;
	private Perfil perfil4;
	private Perfil perfil5;
	private Perfil perfil6;
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	private Usuario usuario4;
	private Usuario usuario5;
	private Usuario usuario6;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Estabelecimento> recomendacaoTeste;
	
	@Before
	public void setUp() throws Exception 
	{
		opinioes1 = new ArrayList<Integer>();
		opinioes2 = new ArrayList<Integer>();
		opinioes3 = new ArrayList<Integer>();
		opinioes4 = new ArrayList<Integer>();
		opinioes5 = new ArrayList<Integer>();
		opinioes6 = new ArrayList<Integer>();
		
		opinioes1.add(0);
		opinioes1.add(-1);
		opinioes1.add(2);
		opinioes1.add(0);
		opinioes1.add(3);
		
		opinioes2.add(1);
		opinioes2.add(4);
		opinioes2.add(3);
		opinioes2.add(-3);
		opinioes2.add(0);
		
		opinioes3.add(-3);
		opinioes3.add(0);
		opinioes3.add(2);
		opinioes3.add(2);
		opinioes3.add(1);
		
		opinioes4.add(0);
		opinioes4.add(1);
		opinioes4.add(2);
		opinioes4.add(-2);
		opinioes4.add(3);
		
		
		opinioes5.add(1);
		opinioes5.add(1);
		opinioes5.add(4);
		opinioes5.add(2);
		opinioes5.add(-3);
		
		
		opinioes6.add(-1);
		opinioes6.add(0);
		opinioes6.add(0);
		opinioes6.add(0);
		opinioes6.add(0);
		
		estabelecimentosTeste1 = new ArrayList<Estabelecimento>();
		
		estabelecimentosTeste1.add(new Estabelecimento("Padaria", "rua 000", TipoDeAlmoco.A_LA_CARTE));
		estabelecimentosTeste1.add(new Estabelecimento("Panificadora", "rua 111", TipoDeAlmoco.PRATO_FEITO));
		estabelecimentosTeste1.add(new Estabelecimento("Mercado", "rua 222", TipoDeAlmoco.SELF_SERVICE));
		estabelecimentosTeste1.add(new Estabelecimento("farmacia", "rua 192", TipoDeAlmoco.A_LA_CARTE));
		estabelecimentosTeste1.add(new Estabelecimento("escritorio", "rua 234", TipoDeAlmoco.SELF_SERVICE));
		
		perfil1 = new Perfil(opinioes1, estabelecimentosTeste1, new GregorianCalendar(12, 12, 12));
		perfil2 = new Perfil(opinioes2, estabelecimentosTeste1, new GregorianCalendar(12, 12, 12));
		perfil3 = new Perfil(opinioes3, estabelecimentosTeste1, new GregorianCalendar(12, 12, 12));
		perfil4 = new Perfil(opinioes4, estabelecimentosTeste1, new GregorianCalendar(11, 11, 111));
		perfil5 = new Perfil(opinioes5, estabelecimentosTeste1, new GregorianCalendar(23, 3, 3423));
		perfil6 = new Perfil(opinioes6, estabelecimentosTeste1, new GregorianCalendar(12, 9, 12));
		
		usuario1 = new Usuario("Usuario 1", perfil1);
		usuario2 = new Usuario("Usuario 2", perfil2);
		usuario3 = new Usuario("Usuario 3", perfil3);
		usuario4 = new Usuario("Usuario 4", perfil4);
		usuario5 = new Usuario("Usuario 5", perfil5);
		usuario6 = new Usuario("Usuario 6", perfil6);
		
		usuarios = new ArrayList<Usuario>();
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		usuarios.add(usuario4);
		usuarios.add(usuario5);
		usuarios.add(usuario6);
		
		recomendacaoTeste = new ArrayList<Estabelecimento>();
	}

	@Test
	public void testeGeraRecomendacao() throws EstabelecimentoInvalidoException, OpiniaoInvalidaException, PerfilNaoAlteravelException, PermissaoDeAlteracaoInvalidaException
	{
		try 
		{
			AlgoritmoDeRecomendacaoProdutoEscalar.geraRecomendacao(0, null, estabelecimentosTeste1, usuarios);
			Assert.fail("Uma excecao de tipo UsuarioInvalidoException era esperada ao passar usuario nulo ao "
					+ "metodo geraRecomendacao.");
		} 
		catch (UsuarioInvalidoException e) 
		{
			
		} 
		catch (NumeroDeRecomendacoesInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo NumeroDeRecomendacoesInvalidoException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes valido, usuario"
					+ " nulo, lista de estabelecimentos valida e lista de usuarios valida.");
			Assert.fail();
		} 
		catch (ListaDeEstabelecimentosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeEstabelecimentosInvalidaException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes valido, usuario"
					+ " nulo, lista de estabelecimentos valida e lista de usuarios valida.");
			Assert.fail();
		} 
		catch (ListaDeUsuariosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeUsuariosInvalidaException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes valido, usuario"
					+ " nulo, lista de estabelecimentos valida e lista de usuarios valida.");
			Assert.fail();
		}
		catch (MapeamentoUsuarioSemelhancaInvalidoException e)
		{
			System.err.println("Uma excecao inesperada de tipo MapeamentoUsuarioSemelhancaInvalido foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes valido, usuario"
					+ " nulo, lista de estabelecimentos valida e lista de usuarios valida.");
			Assert.fail();
		}
		
		
		
		
		try 
		{
			AlgoritmoDeRecomendacaoProdutoEscalar.geraRecomendacao(-1, usuario1, estabelecimentosTeste1, usuarios);
			Assert.fail("Uma excecao de tipo NumeroDeRecomendacoesInvalidoException era esperada ao passar numero de "
					+ "recomendacoes negativo ao metodo geraRecomendacao.");
		} 
		catch (UsuarioInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo UsuarioInvalidoException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes negativo, usuario"
					+ " valido, lista de estabelecimentos valida e lista de usuarios valida.");
			Assert.fail();
		} 
		catch (NumeroDeRecomendacoesInvalidoException e) 
		{
			
		} 
		catch (ListaDeEstabelecimentosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeEstabelecimentosInvalidaException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes negativo, usuario"
					+ " valido, lista de estabelecimentos valida e lista de usuarios valida.");
			Assert.fail();
		} 
		catch (ListaDeUsuariosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeUsuariosInvalidaException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes negativo, usuario"
					+ " valido, lista de estabelecimentos valida e lista de usuarios valida.");
			Assert.fail();
		} 
		catch (MapeamentoUsuarioSemelhancaInvalidoException e)
		{
			System.err.println("Uma excecao inesperada de tipo MapeamentoUsuarioSemelhancaInvalido foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes negativo, usuario"
					+ " valido, lista de estabelecimentos valida e lista de usuarios valida.");
			Assert.fail();
		}
		
		
		
		try 
		{
			AlgoritmoDeRecomendacaoProdutoEscalar.geraRecomendacao(0, usuario1, null, usuarios);
			Assert.fail("Uma excecao de tipo ListaDeEstabelecimentosInvalidaException era esperada ao passar lista de "
					+ "estabelecimentos nula ao metodo geraRecomendacao.");
		} 
		catch (UsuarioInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo UsuarioInvalidoException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes valido, usuario"
					+ " valido, lista de estabelecimentos nula e lista de usuarios valida.");
			Assert.fail();
		} 
		catch (NumeroDeRecomendacoesInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo NumeroDeRecomendacoesInvalidoException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes valido, usuario"
					+ " valido, lista de estabelecimentos nula e lista de usuarios valida.");
			Assert.fail();
		} 
		catch (ListaDeEstabelecimentosInvalidaException e) 
		{
			
		} 
		catch (ListaDeUsuariosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeUsuariosInvalidaException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes valido, usuario"
					+ " valido, lista de estabelecimentos nula e lista de usuarios valida.");
			Assert.fail();
		} 
		catch (MapeamentoUsuarioSemelhancaInvalidoException e)
		{
			System.err.println("Uma excecao inesperada de tipo MapeamentoUsuarioSemelhancaInvalido foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes valido, usuario"
					+ " valido, lista de estabelecimentos nula e lista de usuarios valida.");
			Assert.fail();
		}

		
		
		
		try 
		{
			AlgoritmoDeRecomendacaoProdutoEscalar.geraRecomendacao(0, usuario1, estabelecimentosTeste1, null);
			Assert.fail("Uma excecao de tipo ListaDeUsuariosInvalidaException era esperada ao passar lista de "
					+ "usuarios nula ao metodo geraRecomendacao.");
		} 
		catch (UsuarioInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo UsuarioInvalidoException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes valido, usuario"
					+ " valido, lista de estabelecimentos valida e lista de usuarios nula.");
			Assert.fail();
		} 
		catch (NumeroDeRecomendacoesInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo NumeroDeRecomendacoesInvalidoException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes valido, usuario"
					+ " valido, lista de estabelecimentos valida e lista de usuarios nula.");
			Assert.fail();
		} 
		catch (ListaDeEstabelecimentosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeEstabelecimentosInvalidaException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes valido, usuario"
					+ " valido, lista de estabelecimentos valida e lista de usuarios nula.");
			Assert.fail();
		} 
		catch (ListaDeUsuariosInvalidaException e) 
		{
			
		} 
		catch (MapeamentoUsuarioSemelhancaInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo MapeamentoUsuarioSemelhancaInvalido foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes valido, usuario"
					+ " valido, lista de estabelecimentos valida e lista de usuarios nula.");
			Assert.fail();
		}
		
		
		
		try 
		{
			AlgoritmoDeRecomendacaoProdutoEscalar.geraRecomendacao(estabelecimentosTeste1.size() + 1, usuario1, estabelecimentosTeste1, usuarios);
			Assert.fail("Uma excecao de tipo NumeroDeRecomendacoesInvalidoException era esperada ao passar numero de recomendacoes "
					+ "maior do que o numero de estabelecimentos ao metodo geraRecomendacao.");
		} 
		catch (UsuarioInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo UsuarioInvalidoException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes maior do que o numero de estabelecimentos"
					+ ",  usuario valido, lista de estabelecimentos valida e lista de usuarios valida.");
			Assert.fail();
		} 
		catch (NumeroDeRecomendacoesInvalidoException e) 
		{
			
		} 
		catch (ListaDeEstabelecimentosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeEstabelecimentosInvalidaException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes maior do que o numero de estabelecimentos"
					+ ",  usuario valido, lista de estabelecimentos valida e lista de usuarios valida.");
			Assert.fail();
		} 
		catch (ListaDeUsuariosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeUsuariosInvalidaException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes maior do que o numero de estabelecimentos"
					+ ",  usuario valido, lista de estabelecimentos valida e lista de usuarios valida.");
			Assert.fail();
		}
		catch (MapeamentoUsuarioSemelhancaInvalidoException e)
		{
			System.err.println("Uma excecao inesperada de tipo MapeamentoUsuarioSemelhancaInvalido foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados numero de recomendacoes maior do que o numero de estabelecimentos"
					+ ",  usuario valido, lista de estabelecimentos valida e lista de usuarios valida.");
			Assert.fail();
		}
		
	
		
		
		try 
		{
			// para o usuario 1 estes sao os estabelecimentos da recomendacao esperada
			recomendacaoTeste.add(estabelecimentosTeste1.get(3));
			recomendacaoTeste.add(estabelecimentosTeste1.get(0));
			
			Assert.assertEquals("O metodo geraRecomendacao nao retornou a lista de estabelecimentos correta para " + usuario1.getNome(), 
						recomendacaoTeste,
						AlgoritmoDeRecomendacaoProdutoEscalar.geraRecomendacao(estabelecimentosTeste1.size(), usuario1, estabelecimentosTeste1, usuarios));
			
			recomendacaoTeste.clear();
			
			
			// para o usuario 2 estes sao os estabelecimentos da recomendacao esperada
			recomendacaoTeste.add(estabelecimentosTeste1.get(4));
			
			Assert.assertEquals("O metodo geraRecomendacao nao retornou a lista de estabelecimentos correta para " + usuario2.getNome(), 
					recomendacaoTeste,
					AlgoritmoDeRecomendacaoProdutoEscalar.geraRecomendacao(estabelecimentosTeste1.size(), usuario2, estabelecimentosTeste1, usuarios));
	
			recomendacaoTeste.clear();
			
			
			// para o usuario 3 estes sao os estabelecimentos da recomendacao esperada
			recomendacaoTeste.add(estabelecimentosTeste1.get(1));
			
			Assert.assertEquals("O metodo geraRecomendacao nao retornou a lista de estabelecimentos correta para " + usuario3.getNome(), 
					recomendacaoTeste,
					AlgoritmoDeRecomendacaoProdutoEscalar.geraRecomendacao(estabelecimentosTeste1.size(), usuario3, estabelecimentosTeste1, usuarios));
	
			recomendacaoTeste.clear();
			
			
			
			// para o usuario 4 estes sao os estabelecimentos da recomendacao esperada 
			recomendacaoTeste.add(estabelecimentosTeste1.get(0));
			
			Assert.assertEquals("O metodo geraRecomendacao nao retornou a lista de estabelecimentos correta para " + usuario4.getNome(), 
					recomendacaoTeste,
					AlgoritmoDeRecomendacaoProdutoEscalar.geraRecomendacao(estabelecimentosTeste1.size(), usuario4, estabelecimentosTeste1, usuarios));
			
			recomendacaoTeste.clear();
			
			
			
			// para o usuario 5 a recomendacao esperada eh vazia
			Assert.assertEquals("O metodo geraRecomendacao nao retornou a lista de estabelecimentos correta para " + usuario5.getNome(), 
					recomendacaoTeste,
					AlgoritmoDeRecomendacaoProdutoEscalar.geraRecomendacao(estabelecimentosTeste1.size(), usuario5, estabelecimentosTeste1, usuarios));
			
			
			
			ArrayList<Estabelecimento> recomendacaoTeste2 = null;
			
			recomendacaoTeste2 = AlgoritmoDeRecomendacaoProdutoEscalar.geraRecomendacao(estabelecimentosTeste1.size(), 
					usuario6, estabelecimentosTeste1, usuarios);
			
			
			// a recomendacao para o usuario 6 nao pode conter o primeiro estabelecimento
			Assert.assertTrue("O metodo geraRecomendacao nao retornou a lista de estabelecimentos correta para " + usuario6.getNome(),
					!recomendacaoTeste2.contains(estabelecimentosTeste1.get(0)));
			
			// este teste funciona da seguinte maneira:
			// se um usuario conhece apenas um estabelecimento
			// e para cada estabelecimento restante existe
			// pelo menos um usuario que o conhece e aprova
			// entao a recomendacao contera todos os estabelecimentos
			// menos o estabelecimento que o usuario que quer a
			// recomendacao conhece 
			usuario6.mudaPermissaoAlteracao(Alteravel.SIM);
			// altera o estabelecimento conhecido
			usuario6.alterarOpiniao(estabelecimentosTeste1.get(0), 0);
			usuario6.alterarOpiniao(estabelecimentosTeste1.get(1), -1);
			
			for (int iter = 1; iter < 4; iter++)
			{
				recomendacaoTeste2 = AlgoritmoDeRecomendacaoProdutoEscalar.geraRecomendacao(estabelecimentosTeste1.size(), 
						usuario6, estabelecimentosTeste1, usuarios);
				
				Assert.assertTrue("O metodo geraRecomendacao nao retornou a lista de estabelecimentos correta para " + usuario6.getNome(),
						!recomendacaoTeste2.contains(estabelecimentosTeste1.get(iter)));
				
				// altera o estabelecimento conhecido
				usuario6.alterarOpiniao(estabelecimentosTeste1.get(iter), 0);
				usuario6.alterarOpiniao(estabelecimentosTeste1.get(iter + 1), -1);
			}
			
			usuario6.alterarOpiniao(estabelecimentosTeste1.get(4), 0);
			
			for (int iter = 0; iter < estabelecimentosTeste1.size(); iter++)
			{
				Assert.assertEquals("O metodo geraRecomendacao nao retornou a lista de estabelecimentos correta para " + usuario6.getNome(),
						iter, AlgoritmoDeRecomendacaoProdutoEscalar.geraRecomendacao(iter, usuario6, estabelecimentosTeste1, usuarios).size());
			}
			
			// este teste verifica se o algoritmo devolve o numero correto de 
			// estabelecimentos quando nao houver mais estabelecimentos disponiveis
			
			// faz o usuario 6 conhecer todos menos um estabelecimento
			for (int iter = 0; iter < estabelecimentosTeste1.size() - 1; iter++)
			{
				usuario6.alterarOpiniao(estabelecimentosTeste1.get(iter), -1);
			}
			
			// se o usuario quiser uma recomendacao de 0 estabelecimento, devolve este numero de estabelecimentos
			Assert.assertEquals("O metodo geraRecomendacao nao retornou a lista de estabelecimentos correta para " + usuario6.getNome(),
					0, AlgoritmoDeRecomendacaoProdutoEscalar.geraRecomendacao(0, usuario6, estabelecimentosTeste1, usuarios).size());
			
			// se o usuario quiser uma recomendacao de 1 estabelecimento, devolve este numero de estabelecimentos
			Assert.assertEquals("O metodo geraRecomendacao nao retornou a lista de estabelecimentos correta para " + usuario6.getNome(),
					1, AlgoritmoDeRecomendacaoProdutoEscalar.geraRecomendacao(1, usuario6, estabelecimentosTeste1, usuarios).size());
			
			// para um numero maior de estabelecimentos, como o usuario so nao conhece um estabelecimento,
			// vai ser retornada uma recomendacao de um estabelecimento
			for (int iter = 2; iter < estabelecimentosTeste1.size(); iter++)
			{
				Assert.assertEquals("O metodo geraRecomendacao nao retornou a lista de estabelecimentos correta para " + usuario6.getNome(),
						1, AlgoritmoDeRecomendacaoProdutoEscalar.geraRecomendacao(iter, usuario6, estabelecimentosTeste1, usuarios).size());
			}
		
		} 
		catch (UsuarioInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo UsuarioInvalidoException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados argumentos validos.");
			Assert.fail();
		} 
		catch (NumeroDeRecomendacoesInvalidoException e) 
		{
			System.err.println("Uma excecao inesperada de tipo NumeroDeRecomendacoesInvalidoException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados argumentos validos.");
			Assert.fail();
		} 
		catch (ListaDeEstabelecimentosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeEstabelecimentosInvalidaException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados argumentos validos.");
			Assert.fail();
		} 
		catch (ListaDeUsuariosInvalidaException e) 
		{
			System.err.println("Uma excecao inesperada de tipo ListaDeUsuariosInvalidaException foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados argumentos validos.");
			Assert.fail();
		} 
		catch (MapeamentoUsuarioSemelhancaInvalidoException e)
		{
			System.err.println("Uma excecao inesperada de tipo MapeamentoUsuarioSemelhancaInvalido foi lancada"
					+ " pelo metodo geraRecomendacao quando foram passados argumentos validos.");
			Assert.fail();
		}
	}
}
