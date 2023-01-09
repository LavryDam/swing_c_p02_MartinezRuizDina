/**
 * swing_c_p02_MartinezRuizDina-swing_c_p02_MartinezRuizDina-PanelTitulo.java
 * 21 nov 2022 9:21:32
 * @author Dina Martínez Ruiz
 */
package swing_c_p02_MartinezRuizDina;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * The Class PanelTitulo.
 *
 * @author Dina
 */
public class PanelTitulo extends JPanel {
	
	/** The c 2. */
	private Color c1, c2;
	
	/**
	 * Instantiates a new panel titulo.
	 */
	public PanelTitulo() {
		
		 c1 = new Color(255, 251, 193);
		 c2 = new Color(182, 226, 161);
		 
		 this.setLayout(new BorderLayout());
		
		 JPanel p1 = new JPanel();
		 p1.setLayout(new FlowLayout());
		 p1.setBackground(c1);
		 
		 JLabel titulo = new JLabel("Gestión Hotel 'Sauron'*****");
		 p1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.BLUE, Color.GREEN, Color.BLACK, Color.RED));
		 
		 titulo.setFont(new Font("Serif", Font.BOLD, 100));
		 titulo.setForeground(c2);

		 p1.add(titulo);
		 
		 this.add(p1);
	
	}

}
