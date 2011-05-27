package ahoradorango;

//Cada estabelecimento têm, além do nome,
//um endereço e o tipo de almoço servido: self service, prato feito, a la carte.

public enum TipoDeAlmoco
{
	SELF_SERVICE("Self-service"),
	PRATO_FEITO("Prato feito"),
	A_LA_CARTE("A la carte");
	
	private String nomeTipoDeAlmoco;
	
	private TipoDeAlmoco(String nomeTipoDeAlmoco)
	{
		this.nomeTipoDeAlmoco = nomeTipoDeAlmoco;
	}
	
	public String getNomeTipoDeAlmoco()
	{
		return nomeTipoDeAlmoco;
	}
}
