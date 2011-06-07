package ahoradorango;

import java.io.File;

public class FiltroDATA extends javax.swing.filechooser.FileFilter{

	public boolean accept(File file) {
		String filename = file.getName();
		return file.isDirectory() || filename.endsWith(".data");
	}

	public String getDescription() {
		return "*.data";
	}
}
