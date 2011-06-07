package ahoradorango;

import java.io.File;

public class FiltroCSV extends javax.swing.filechooser.FileFilter {	
    public boolean accept(File file) {
        String filename = file.getName();
        return file.isDirectory() || filename.endsWith(".csv");
    }
    public String getDescription() {
        return "*.csv";
    }

}
