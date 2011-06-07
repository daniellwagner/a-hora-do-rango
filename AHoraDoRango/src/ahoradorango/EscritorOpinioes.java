package ahoradorango;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorOpinioes {
	public EscritorOpinioes(String novoPerfil) throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(
				"opinioes-dos-usuarios-v2.data", true));
		out.newLine();
		out.write(novoPerfil);
		out.close();
	}

}
