/**
 * swing_c_p02_MartinezRuizDina-swing_c_p02_MartinezRuizDina-ExtraNinio.java
 * 23 nov 2022 11:08:50
 * @author Dina Martínez Ruiz
 */
package swing_c_p02_MartinezRuizDina;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

/**
 * The Class ExtraNinio.
 *
 * @author Dina
 */
public class ExtraNinio extends JPanel {
	
	/** The informacion. */
	private JTextArea informacion;
	
	/** The edad. */
	private JSpinner edad;

	/**
	 * Instantiates a new extra ninio.
	 */
	public ExtraNinio() {
		
		informacion = new JTextArea();
		informacion.setText("Edad entre [0-3]---cuna,\n"
				+ "Edad entre [4-10]---cama supletoria pequeña \n"
				+ "Edad entre [11-14]---cama supletoria normal.");
		
		edad = new JSpinner(new SpinnerNumberModel(0,0,14,1));
		
		this.add(edad);
		this.add(informacion);
	}
}
