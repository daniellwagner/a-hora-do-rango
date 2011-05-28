package ahoradorango;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class TesteAbrirArquivo {

	public static void main(String[] args) {
		String caminhoArquivo = "";
		JFileChooser arquivo = new JFileChooser();
		int retorno = arquivo.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			caminhoArquivo = arquivo.getSelectedFile().getAbsolutePath();
			String[] nomeArquivo = caminhoArquivo.split("/");
			for (int i = 0; i < nomeArquivo.length; i++) {
				System.out.println(nomeArquivo[i]);
			}
			JOptionPane.showMessageDialog(null, nomeArquivo[0]);
		} else {
			// não abriu
		}
	}

}
