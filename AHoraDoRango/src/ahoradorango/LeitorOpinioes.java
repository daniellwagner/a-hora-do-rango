package ahoradorango;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeitorOpinioes {

	private ArrayList<String> linhas = new ArrayList<String>();
	private String line;
	private String[] colunas;
	private File arquivoOpinioes;
	private Map<String, Usuario> usuarios;
	private LeitorEstabelecimentos leitorEstabelecimentos;
	
	public LeitorEstabelecimentos getLeitorEstabelecimentos() {
		return leitorEstabelecimentos;
	}

	public void setLeitorEstabelecimentos(
			LeitorEstabelecimentos leitorEstabelecimentos) {
		this.leitorEstabelecimentos = leitorEstabelecimentos;
	}

	public LeitorOpinioes(File opinioes, LeitorEstabelecimentos leitorEstabelecimento) {
		this.arquivoOpinioes = opinioes;
		this.leitorEstabelecimentos = leitorEstabelecimento;
		this.usuarios = new HashMap<String, Usuario>();
	}
	
	public Collection<Usuario> leLinhas() throws IOException, ParseException {
		BufferedReader buffer = new BufferedReader(new FileReader(arquivoOpinioes));
		while ((line = buffer.readLine()) != null) {
			linhas.add(line);
		}
		buffer.close();
		
		String[] colunasCabecalho = linhas.get(0).split(";");
		
		for (int linha = 1; linha < linhas.size(); linha++) {
			colunas = linhas.get(linha).split(";");
			Map<Estabelecimento, Integer> est = new HashMap<Estabelecimento, Integer>();

			Usuario usuario = new Usuario();
			if (colunas[1].trim().equals("")) {
				usuario.setNome("nao conhece");
			} else {
				usuario.setNome(colunas[1]);
			}
			
			Perfil perfil = new Perfil();
			perfil.setMomentoCriacaoDoPerfil(getDataHora(colunas[0]));
			
			for (int coluna = 2; coluna < colunas.length; coluna++) {
				Estabelecimento e = leitorEstabelecimentos.getEstabelecimentos().get(colunasCabecalho[coluna].toLowerCase());
				String[] nota = colunas[coluna].split(":");
				est.put(e, new Integer(nota[0].trim()));
			}
			perfil.setEstabelecimentosOpinioes(est);
			
			if (!usuarios.containsKey(usuario.getNome())) {
				usuario.getPerfis().add(perfil);
				usuarios.put(usuario.getNome(), usuario);
			} else {
				usuarios.get(usuario.getNome()).getPerfis().add(perfil);
			}
		}
		return usuarios.values();
	}
	
	private GregorianCalendar getDataHora(String dataHora) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date d = sdf.parse(dataHora);
		GregorianCalendar cal = (GregorianCalendar)GregorianCalendar.getInstance();
		cal.setTime(d);
		
		return cal;
	}
	
	@SuppressWarnings("unchecked")
	public Object[][] getTableOpinioes() {
		int numOpinioes = 0;
		for (Usuario u : usuarios.values()) {
			for (Perfil p : u.getPerfis()) {
				numOpinioes += p.getEstabelecimentosOpinioes().size();
			}
		}
		String[][] opinioes = new String[numOpinioes][4];
		int linha = 0;
		for (Usuario u : usuarios.values()) {
			for (Perfil p : u.getPerfis()) {
				Object[] entry = p.getEstabelecimentosOpinioes().entrySet().toArray();
				for (int i = 0; i < entry.length; i++) {
					opinioes[linha][0] = this.getDataHoraString(p.getMomentoCriacaoDoPerfil());
					opinioes[linha][1] = u.getNome();
					opinioes[linha][2] = ((Map.Entry<Estabelecimento, Integer>)entry[i]).getKey().getNome();
					opinioes[linha][3] = ((Map.Entry<Estabelecimento, Integer>)entry[i]).getValue().toString();
					linha++;
				}
			}
		}
		
		return opinioes;
	}
	
	public String getDataHoraString(GregorianCalendar cal) {
		return cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + 
			cal.get(Calendar.YEAR) + " " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + 
			":" + cal.get(Calendar.SECOND);
	}

	public Object[] getUsuarios() {
		Set<String> chaves = usuarios.keySet();
		Object[] arrayUsuarios = chaves.toArray();
		return arrayUsuarios;
	}

	public void setUsuarios(Map<String, Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	/*
	public String[] getNomes(){
		String[] arrayNomes = new String[linhas.size()];
		for (int linha = 0; linha < linhas.size(); linha++) {
			String[] colunas = linhas.get(linha).split(";");
			tabelaOpinioes[linha][1] = colunas[1];
			arrayNomes[linha] = tabelaOpinioes[linha][1];
		}
		return arrayNomes;
	}
	
	public int getNumLinhas(){
		int numLinhas = linhas.size();
		return numLinhas;
	}
	*/
	
	
//	public String[] getEstabelecimentos(){
//		String[] arrayEstabelecimentos = new String[50];
//		String[] colunas;
//		for (int linha = 0; linha < linhas.size(); linha++) {
//			colunas = linhas.get(linha).split(";");
//		
//			for (int coluna = 0; coluna < colunas.length; coluna++){
//				tabelaOpinioes[0][coluna] = colunas[coluna];
//				arrayEstabelecimentos[linha] = tabelaOpinioes[0][coluna];
//			}
//		}	
//			
//		
//		return arrayEstabelecimentos;
//	}
	
	/*
	public String[] getOpinioes(){
		String[] opinioes = new String[colunas.length];
		for (int i = 2; i <= colunas.length; i++){
			opinioes[i] = colunas[i]; 
		}
		return opinioes;
	}
	*/
	
	/*
	public String linhas() {
		System.out.println("Imprimindo arraylist");

		for (int i = 0; i < 166; i++) {
			return linhas.get(i);
		}
		return "";

	}

	public String[][] getTabelaOpinioes() {
		return tabelaOpinioes;
	}

	public void setTabelaOpinioes(String[][] tabelaOpinioes) {
		this.tabelaOpinioes = tabelaOpinioes;
	}

	public Object retornaColunas() {
		String[] colunas = null;
		tabelaOpinioes = new String[linhas.size()][41];
		for (int linha = 0; linha < linhas.size(); linha++) {
			colunas = linhas.get(linha).split(";");
		}
		return colunas;
	}

	public void preencheTabelaOpinioes() {
		tabelaOpinioes = new String[linhas.size()][41];
		for (int linha = 0; linha < linhas.size(); linha++) {
			String[] colunas = linhas.get(linha).split(";");
			for (int coluna = 0; coluna < colunas.length; coluna++) {
				tabelaOpinioes[linha][coluna] = colunas[coluna];
			}
		}
	}
	
	public void mostraTabela() {
		for (int i = 0; i < tabelaOpinioes.length; i++) {
			for (int j = 0; j < tabelaOpinioes[i].length; j++) {
				System.out.print(tabelaOpinioes[i][j] + "; ");
			}
			System.out.println(i);
		}
	}
	*/
}
