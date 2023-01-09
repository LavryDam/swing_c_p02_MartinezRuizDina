/**
 * swing_c_p02_MartinezRuizDina-swing_c_p02_MartinezRuizDina-VentanaDialogo.java
 * 21 nov 2022 8:23:52
 * @author Dina Martínez Ruiz
 */
package swing_c_p02_MartinezRuizDina;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

/**
 * The Class VentanaDialogo.
 *
 * @author Dina
 */
public class VentanaDialogo extends JDialog {

	/** The panel titulo. */
	private PanelTitulo panelTitulo;
	
	/** The panel usuario. */
	private PanelUsuario panelUsuario;
	
	/** The panel habitaciones. */
	private PanelHabitaciones panelHabitaciones;
	
	/** The panel ficha. */
	private PanelFicha panelFicha;
	
	/** The boton nuevo. */
	private JButton botonImprimir, botonGuardar, botonNuevo;
	
	/** The c 1. */
	private Color c1;

	/** The layout. */
	private GridBagLayout layout;
	
	/** The constraints. */
	private GridBagConstraints constraints;

	/**
	 * Instantiates a new ventana dialogo.
	 *
	 * @param miVentanaPrincipal the mi ventana principal
	 * @param modal              the modal
	 */
	public VentanaDialogo(VentanaPrincipal miVentanaPrincipal, boolean modal) {
		super(miVentanaPrincipal, modal);

		iniciarComponentes();

		setTitle("Altas Reservas");

		Toolkit miPantalla = Toolkit.getDefaultToolkit();

		java.awt.Image miIcono = miPantalla.getImage(getClass().getResource("recursos/eyesauron.jpeg"));

		this.setIconImage((java.awt.Image) miIcono);

		// para que salga el tamaño total de la pantalla
		this.setSize(this.getToolkit().getScreenSize());

		setLocationRelativeTo(null);

	}

	/**
	 * Iniciar componentes.
	 */
	private void iniciarComponentes() {

		layout = new GridBagLayout();
		this.setLayout(layout); // set frame layout
		constraints = new GridBagConstraints(); // instantiate constraints

		c1 = new Color(222, 186, 206);

		botonImprimir = new JButton();
		botonImprimir.setToolTipText("Para imprimir la documentacion");
		botonImprimir.setIcon(new ImageIcon(getClass().getResource("recursos/imprimir.jpg")));
		botonGuardar = new JButton();
		botonGuardar.setToolTipText("Para guardar la documentacion");
		botonGuardar.setIcon(new ImageIcon(getClass().getResource("recursos/guardar.jpg")));
		botonNuevo = new JButton();
		botonNuevo.setToolTipText("Para crea nuevo cliente");
		botonNuevo.setIcon(new ImageIcon(getClass().getResource("recursos/usuario.jpg")));

		panelTitulo = new PanelTitulo();
		panelUsuario = new PanelUsuario();
		Border line1 = BorderFactory.createLineBorder(c1, 3);
		panelUsuario.setBorder(line1);
		panelHabitaciones = new PanelHabitaciones();
		panelHabitaciones.setBorder(line1);
		// meto por parametro panelUsuario y habitaciones para traer los datos
		panelFicha = new PanelFicha(panelUsuario, panelHabitaciones);
		panelFicha.setBorder(line1);

		this.addComponent(botonNuevo, 0, 3, 1, 1);
		this.addComponent(botonGuardar, 1, 3, 1, 1);
		this.addComponent(botonImprimir, 2, 3, 1, 1);

		// Copio contexto para poder usarlo dentro del actionPerformed
		VentanaDialogo ventanaDialogoContexto = this;

		botonNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Array que contiene los JPanel en los que quiero borrar los datos
				// paso a JPanel para que sea más genérico y acepte todos los paneles
				JPanel arrayJPanel[] = { (JPanel) panelUsuario, (JPanel) panelHabitaciones };

				ventanaDialogoContexto.limpiarFormulario(arrayJPanel);
			}
		});

		botonGuardar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JPanel arrayJPanel[] = { (JPanel) panelUsuario, (JPanel) panelHabitaciones };
				panelUsuario.comprobarDatos();
				ventanaDialogoContexto.limpiarFormulario(arrayJPanel);

			}
		});

		panelFicha.setVisible(true);

		botonImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// hacemos un set de panelUsuario por si hay datos nuevos
				panelFicha.setPanelUsuario(panelUsuario);
				panelFicha.setPanelHabitaciones(panelHabitaciones);
				panelFicha.setVisible(true);
			}
		});

		constraints.weighty = 1;
		constraints.weightx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		this.addComponent(panelTitulo, 0, 0, 3, 1);
		this.addComponent(panelUsuario, 0, 1, 1, 1);
		this.addComponent(panelHabitaciones, 1, 1, 1, 1);
		this.addComponent(panelFicha, 2, 1, 1, 1);

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

		constraints.gridx = column; // set gridx, La columna en la que se colocarᠥl .
		constraints.gridy = row; // set gridy, La fila en la que se colocarᠥl
		constraints.gridwidth = width; // set gridwidth, El nmero de columnas que
		constraints.gridheight = height; // set gridheight, El nmero de filas que
		// metelo en el layout con esas caracteristicas, pasarle los compnentes
		layout.setConstraints(component, constraints); // set constraints
		this.add(component); // add component
	}
	

	// Funcion que coge cualquier tipo de componente y dependiendo del tipo de
	// instancia que sea
	/**
	 * Limpiar formulario.
	 *
	 * @param componentes the componentes
	 */
	// ejecuta una funcionalidad u otra
	private void limpiarFormulario(Component[] componentes) {
		for (Component componente : componentes) {
			// Ejecuto con recursividad la misma función para que entre en ese JPanel y vaya
			// entrando en los demás componentes
			if (componente instanceof JPanel) {
				
				limpiarFormulario(((JPanel) componente).getComponents());
				
			} else if (componente instanceof JFormattedTextField) {
			
				((JFormattedTextField) componente).setText("");
				
			} else if (componente instanceof JCheckBox) {
				
				((JCheckBox) componente).setSelected(false);
				
			} else if (componente instanceof JSpinner) {

				((JSpinner) componente).setValue(0);

			} else if (componente instanceof JComboBox) {

				((JComboBox<?>) componente).setSelectedIndex(0);
				
			}else if(componente instanceof JRadioButton) {
				
				((JRadioButton) componente).setSelected(false);
			}
		}
	}

}
