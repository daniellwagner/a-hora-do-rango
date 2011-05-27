package testes;

import org.junit.Assert;
import org.junit.Test;

import ahoradorango.TipoDeAlmoco;

public class TesteTipoDeAlmoco
{
	//SELF_SERVICE("Self-service"),
	//PRATO_FEITO("Prato feito"),
	//A_LA_CARTE("A la carte");

	private String[] nomesTiposAlmoco = {"Self-service", "Prato feito", "A la carte"};
	
	@Test
	public void testGetNomeTipoDeAlmoco() 
	{
		for (int iter = 0; iter < nomesTiposAlmoco.length; iter++)
		{
			Assert.assertEquals("A enumeracao de indice " + iter + " nao foi inicializada corretamente.", 
								nomesTiposAlmoco[iter], TipoDeAlmoco.values()[iter].getNomeTipoDeAlmoco());
		}
		
		System.out.println("O metodo getNomeTipoDeAlmoco passou em todos os testes.");
	}

}
