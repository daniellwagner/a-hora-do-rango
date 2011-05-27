package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ahoradorango.Estabelecimento;
import ahoradorango.TipoDeAlmoco;
import excecoes.EnderecoInvalidoException;
import excecoes.NomeInvalidoException;
import excecoes.TipoDeAlmocoInvalidoException;

public class TesteEstabelecimento
{
	private Estabelecimento estabelecimentoTeste;
	private String nomeTeste1 = "Restaurante Alianca";
	private String enderecoTeste1 = "Rua das molas";
	private TipoDeAlmoco tipoDeAlmocoTeste1 = TipoDeAlmoco.A_LA_CARTE;
	
	@Before
	public void setUp() throws NomeInvalidoException, EnderecoInvalidoException, TipoDeAlmocoInvalidoException
	{
		estabelecimentoTeste = new Estabelecimento(nomeTeste1, enderecoTeste1, TipoDeAlmoco.A_LA_CARTE);
	}
	
	@Test
	public void testeConstrutor()
	{
		try
		{
			estabelecimentoTeste = new Estabelecimento(null, enderecoTeste1, tipoDeAlmocoTeste1);
			Assert.fail("Uma excecao de tipo NomeInvalidoException era esperada em testeConstrutor ao passar para o construtor"
						+ " nome nulo.");
		}
		catch (NomeInvalidoException erro)
		{
			
		}
		catch (EnderecoInvalidoException erro)
		{
			Assert.fail("Uma excecao inesperada de tipo EnderecoInvalidoException foi lancada em testeConstrutor ao passar para "
					   + "o construtor nome nulo e endereco valido.");
		}
		catch(TipoDeAlmocoInvalidoException erro)
		{
			Assert.fail("Uma excecao inesperada de tipo TipoDeAlmocoInvalidoException foi lancada em testeConstrutor ao passar "
					   + "para o construtor nome nulo e tipo de almoco valido.");
		}
		
		
		try
		{
			estabelecimentoTeste = new Estabelecimento("", enderecoTeste1, tipoDeAlmocoTeste1);
			Assert.fail("Uma excecao de tipo NomeInvalidoException era esperada em testeConstrutor ao passar para o construtor"
						+ " nome vazio.");
		}
		catch (NomeInvalidoException erro)
		{
			
		}
		catch (EnderecoInvalidoException erro)
		{
			Assert.fail("Uma excecao inesperada de tipo EnderecoInvalidoException foi lancada em testeConstrutor ao passar para "
					   + "o construtor nome vazio e endereco valido.");
		}
		catch(TipoDeAlmocoInvalidoException erro)
		{
			Assert.fail("Uma excecao inesperada de tipo TipoDeAlmocoInvalidoException foi lancada em testeConstrutor ao passar "
					   + "para o construtor nome vazio e tipo de almoco valido.");
		}
		
		
		
		try
		{
			estabelecimentoTeste = new Estabelecimento("      ", enderecoTeste1, tipoDeAlmocoTeste1);
			Assert.fail("Uma excecao de tipo NomeInvalidoException era esperada em testeConstrutor ao passar para o construtor"
						+ " nome que contem apenas espacos.");
		}
		catch (NomeInvalidoException erro)
		{
			
		}
		catch (EnderecoInvalidoException erro)
		{
			Assert.fail("Uma excecao inesperada de tipo EnderecoInvalidoException foi lancada em testeConstrutor ao passar para "
					   + "o construtor nome que contem apenas espacos e endereco valido.");
		}
		catch(TipoDeAlmocoInvalidoException erro)
		{
			Assert.fail("Uma excecao inesperada de tipo TipoDeAlmocoInvalidoException foi lancada em testeConstrutor ao passar "
					   + "para o construtor nome que contem apenas espacos e tipo de almoco valido.");
		}
		
		try
		{
			estabelecimentoTeste = new Estabelecimento(nomeTeste1, null, tipoDeAlmocoTeste1);
			Assert.fail("Uma excecao de tipo EnderecoInvalidoException era esperada em testeConstrutor ao passar para o construtor"
						+ " endereco nulo.");
		}
		catch (NomeInvalidoException erro)
		{
			Assert.fail("Uma excecao inesperada de tipo NomeInvalidoException foi lancada em testeConstrutor ao passar para "
					   + "o construtor nome valido e endereco nulo.");
		}
		catch (EnderecoInvalidoException erro)
		{
			
		}
		catch(TipoDeAlmocoInvalidoException erro)
		{
			Assert.fail("Uma excecao inesperada de tipo TipoDeAlmocoInvalidoException foi lancada em testeConstrutor ao passar "
					   + "para o construtor endereco nulo e tipoDeAlmoco valido.");
		}
		
		try
		{
			estabelecimentoTeste = new Estabelecimento(nomeTeste1, "", tipoDeAlmocoTeste1);
			Assert.fail("Uma excecao de tipo EnderecoInvalidoException era esperada em testeConstrutor ao passar para o construtor"
						+ " endereco vazio.");
		}
		catch (NomeInvalidoException erro)
		{
			Assert.fail("Uma excecao inesperada de tipo NomeInvalidoException foi lancada em testeConstrutor ao passar para "
					   + "o construtor nome valido e endereco vazio.");
		}
		catch (EnderecoInvalidoException erro)
		{
			
		}
		catch(TipoDeAlmocoInvalidoException erro)
		{
			Assert.fail("Uma excecao inesperada de tipo TipoDeAlmocoInvalidoException foi lancada em testeConstrutor ao passar "
					   + "para o construtor endereco vazio e tipoDeAlmoco valido.");
		}
		
		
		try
		{
			estabelecimentoTeste = new Estabelecimento(nomeTeste1, "     ", tipoDeAlmocoTeste1);
			Assert.fail("Uma excecao de tipo EnderecoInvalidoException era esperada em testeConstrutor ao passar para o construtor"
						+ " endereco que contem apenas espacos.");
		}
		catch (NomeInvalidoException erro)
		{
			Assert.fail("Uma excecao inesperada de tipo NomeInvalidoException foi lancada em testeConstrutor ao passar para "
					   + "o construtor nome valido e endereco que contem apenas espacos.");
		}
		catch (EnderecoInvalidoException erro)
		{
			
		}
		catch(TipoDeAlmocoInvalidoException erro)
		{
			Assert.fail("Uma excecao inesperada de tipo TipoDeAlmocoInvalidoException foi lancada em testeConstrutor ao passar "
					   + "para o construtor endereco que contem apenas espacos e tipoDeAlmoco valido.");
		}
		
		try
		{
			estabelecimentoTeste = new Estabelecimento(nomeTeste1, enderecoTeste1, null);
			Assert.fail("Uma excecao de tipo TipoDeAlmocoInvalidoException era esperada em testeConstrutor ao passar para o construtor"
						+ " tipo de almoco nulo.");
		}
		catch (NomeInvalidoException erro)
		{
			Assert.fail("Uma excecao inesperada de tipo NomeInvalidoException foi lancada em testeConstrutor ao passar para "
					   + "o construtor nome valido e tipo de almoco nulo.");
		}
		catch (EnderecoInvalidoException erro)
		{
			Assert.fail("Uma excecao inesperada de tipo EnderecoInvalidoException foi lancada em testeConstrutor ao passar para "
					   + "o construtor tipo de almoco nulo e endereco valido.");
		}
		catch(TipoDeAlmocoInvalidoException erro)
		{
			
		}
		
		
		try 
		{
			estabelecimentoTeste = new Estabelecimento(nomeTeste1, enderecoTeste1, tipoDeAlmocoTeste1);
			Assert.assertEquals("O construtor nao inicializou corretamente o campo nome.", nomeTeste1, estabelecimentoTeste.getNome());
			Assert.assertEquals("O construtor nao inicializou corretamente o campo endereco.", enderecoTeste1, estabelecimentoTeste.getEndereco());
			Assert.assertEquals("O construtor nao inicializou corretamente o campo tipoDeAlmoco.", tipoDeAlmocoTeste1, estabelecimentoTeste.getTipoDeAlmocoServido());
		}
		catch (NomeInvalidoException e) 
		{
			Assert.fail("Uma excecao inesperada de tipo NomeInvalidoException foi lancada pelo construtor ao passar para ele argumentos validos.");
		}
		catch (EnderecoInvalidoException e)
		{
			Assert.fail("Uma excecao inesperada de tipo EnderecoInvalidoException foi lancada pelo construtor ao passar para ele argumentos validos.");
		}
		catch (TipoDeAlmocoInvalidoException e) 
		{
			Assert.fail("Uma excecao inesperada de tipo TipoDeAlmocoInvalidoException foi lancada pelo construtor ao passar para ele argumentos validos.");
		}
		
		System.out.println("O construtor passou em todos os testes.");
	}

}