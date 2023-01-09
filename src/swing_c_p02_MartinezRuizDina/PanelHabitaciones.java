/**
 * swing_c_p02_MartinezRuizDina-swing_c_p02_MartinezRuizDina-PanelHabitaciones.java
 * 22 nov 2022 8:19:43
 * @author Dina Martínez Ruiz
 */
package swing_c_p02_MartinezRuizDina;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 * The Class PanelHabitaciones.
 *
 * @author Dina
 */
public class PanelHabitaciones extends JPanel implements FocusListener {

	/** The etiqueta extraninios. */
	private JLabel etiquetaHabitacion, etiquetaNumHabitaciones, etiquetaKids, etiquetaImporte, etiquetaImagenes,
			etiquetaExtraKids, etiquetaEdadNinios, etiquetaExtraninios;
	
	/** The combo. */
	private JComboBox<String> combo;
	
	/** The control. */
	private JSpinner control;
	
	/** The checkbox 2. */
	private JCheckBox checkbox1, checkbox2;
	
	/** The importe. */
	private JTextArea importe;

	/** The c 1. */
	private Color c1;
	
	/** The extra ninio. */
	private ExtraNinio extraNinio;

	/** The layout. */
	private GridBagLayout layout; // distribuye las cosas
	
	/** The constraints. */
	private GridBagConstraints constraints; // guarda las caracteristicas

	/**
	 * Instantiates a new panel habitaciones.
	 */
	public PanelHabitaciones() {
		
		c1 = new Color(152, 182, 177);
		this.setBackground(c1);

		layout = new GridBagLayout();
		this.setLayout(layout); // set frame layout
		constraints = new GridBagConstraints(); // instantiate constraints

		constraints.weighty = 1;
		constraints.weightx = 1;
		constraints.fill = GridBagConstraints.BOTH;

		etiquetaHabitacion = new JLabel("Tipo Habitacion: ");
		etiquetaHabitacion.setForeground(new Color(151,0,0));
		this.addComponent(etiquetaHabitacion, 0, 0, 1, 1);
		String[] opciones = { "Simple", "Double", "Suite" };
		combo = new JComboBox<String>(opciones);
		this.addComponent(combo, 1, 0, 1, 1);

		etiquetaNumHabitaciones = new JLabel("Nº Habitaciones: ");
		etiquetaNumHabitaciones.setForeground(new Color(151,0,0));
		this.addComponent(etiquetaNumHabitaciones, 0, 1, 1, 1);
		control = new JSpinner(new SpinnerNumberModel(0, 0, 50, 1));
		Dimension d = new Dimension(100, 20);
		control.setPreferredSize(d);
		this.addComponent(control, 1, 1, 1, 1);

		etiquetaKids = new JLabel("¿Niñas/os?");
		etiquetaKids.setForeground(new Color(151,0,0));
		checkbox1 = new JCheckBox();
		this.addComponent(etiquetaKids, 0, 2, 1, 1);
		this.addComponent(checkbox1, 1, 2, 1, 1);

		etiquetaExtraKids = new JLabel("Extra niñas/os");
		etiquetaExtraKids.setForeground(new Color(151,0,0));
		checkbox2 = new JCheckBox();
		this.addComponent(etiquetaExtraKids, 0, 3, 1, 1);
		this.addComponent(checkbox2, 1, 3, 1, 1);

		extraNinio = new ExtraNinio();
		this.addComponent(extraNinio, 1, 4, 1, 1);
		extraNinio.setVisible(false);

		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (checkbox2.isSelected()) {
					
					extraNinio.setVisible(true);
					
				} else {
					
					extraNinio.setVisible(false);
				}

			}
		};

		checkbox2.addActionListener(listener);

		etiquetaImporte = new JLabel("Importe habitacion: ");
		etiquetaImporte.setForeground(new Color(151,0,0));
		this.addComponent(etiquetaImporte, 0, 5, 1, 1);
		importe = new JTextArea();
		importe.setText("Precio por habitación/día: \n" + "Simple -------------------------- 50€ \n"
				+ "Doble---------------------------- 75€ \n" + "Suit----------------------------- 125€\n"
				+ "Cuna o cama supletoria-------------- 20€");
		importe.addFocusListener(this);
		this.addComponent(importe, 1, 5, 1, 1);

		etiquetaImagenes = new JLabel("Habitaciones: ");
		etiquetaImagenes.setForeground(new Color(151,0,0));
		this.addComponent(etiquetaImagenes, 0, 6, 1, 1);

		ImageIcon room1 = new ImageIcon(getClass().getResource("recursos/room1.jpeg"));
		ImageIcon room2 = new ImageIcon(getClass().getResource("recursos/room2.jpeg"));
		ImageIcon room3 = new ImageIcon(getClass().getResource("recursos/room3.jpeg"));
		JLabel im1 = new JLabel(room1);
		JLabel im2 = new JLabel(room2);
		JLabel im3 = new JLabel(room3);
		this.addComponent(im1, 0, 7, 1, 1);
		this.addComponent(im2, 1, 7, 1, 1);
		this.addComponent(im3, 2, 7, 1, 1);

	}
	
	
	/**
	 * Coger datos habitaciones.
	 *
	 * @return the string
	 */
	//metodo para coger los datos
	public String cogerDatosHabitaciones()
	{
		String retorno = "";
		int valor = (int)control.getValue();
	
		retorno += "Tipo Habitacion: " + combo.getSelectedItem() + "\n";
		retorno += "Nº Habitaciones: " + String.valueOf(valor) + "\n";
		retorno += "Niños/as: " + checkbox1.isSelected() + "\n";
		retorno += "Extra niños/as: " + checkbox2.isSelected() + "\n";
		
		return retorno;
	}

	/**
	 * Adds the component.
	 *
	 * @param component the component
	 * @param column    the column
	 * @param row       the row
	 * @param width     the width
	 * @param height    the height
	 */
	private void addComponent(Component component, int column, int row, int width, int height) {

		constraints.gridx = column; // set gridx, La columna en la que se colocarᠥl
		// componente.
		constraints.gridy = row; // set gridy, La fila en la que se colocarᠥl
		// componente.
		constraints.gridwidth = width; // set gridwidth, El nmero de columnas que
		// ocupa el componente.
		constraints.gridheight = height; // set gridheight, El nmero de filas que
		// ocupa el componente.

		// metelo en el layout con esas caracteristicas, pasarle los compnentes
		layout.setConstraints(component, constraints); // set constraints
		this.add(component); // add component
	} // end method addComponen

	/**
	 * Focus gained.
	 *
	 * @param e the e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == importe) {
			importe.setText("Precio por habitación/día: \n" + "Simple -------------------------- 50€ \n"
					+ "Doble---------------------------- 75€ \n" + "Suit----------------------------- 125€\n"
					+ "Cuna o cama supletoria-------------- 20€");
		}

	}

	/**
	 * Focus lost.
	 *
	 * @param e the e
	 */
	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource() == importe) {
			importe.setText("");
		}
	}

}
