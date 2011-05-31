/*
 * Rode esse programa para rodar toda a aplicacao
 */
package ahoradorango;

import java.util.GregorianCalendar;

/**
 *
 * @author Daniell
 */
public class Main {
	
	private static GregorianCalendar cal;
	public Main(GregorianCalendar cal) {
		this.cal = cal;
		// TODO Auto-generated constructor stub
	}

    /**
     * @param args the command line arguments
     * 
     */
	
	public void executaAhoradorango(){
		TelaPrincipal telaPrincipal = new TelaPrincipal(cal);
	    telaPrincipal.setLocationRelativeTo(null);
	    telaPrincipal.setVisible(true);
	}
	

    public static void main(String[] args) {
    	Main main = new Main(cal);
    	main.executaAhoradorango();
    }
}
