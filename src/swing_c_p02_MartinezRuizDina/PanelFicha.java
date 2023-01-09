/**
 * swing_c_p02_MartinezRuizDina-swing_c_p02_MartinezRuizDina-PanelFicha.java
 * 22 nov 2022 10:08:24
 * @author Dina Martínez Ruiz
 */
package swing_c_p02_MartinezRuizDina;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;


/**
 * The Class PanelFicha.
 *
 * @author Dina
 */
public class PanelFicha extends JPanel {
	
	/** The panel 1. */
	private JPanel miPanel,panel1;
	
	/** The titulo panel 1. */
	private JLabel labelTitulo, tituloPanel1;/*declaramos el objeto Label*/
	
	/** The area de texto 1. */
	private JTextArea areaDeTexto, areaDeTexto1;
	
	/** The texto. */
	private String texto;
	
	/** The c 1. */
	private Color c1;
	
	
	/** The panel usuario. */
	private PanelUsuario panelUsuario;
	
	/**
	 * Sets the panel usuario.
	 *
	 * @param panelUsuario the new panel usuario
	 */
	public void setPanelUsuario(PanelUsuario panelUsuario) {
		// Seteamos el nuevo panelUsuario por si hay datos nuevos
		this.panelUsuario = panelUsuario;
		// Ejecutamos la fución con true para que solo refresque los datos y no cree nuevas instancias
		componentesPanel1(true);
	}

	/** The panel habitaciones. */
	private PanelHabitaciones panelHabitaciones;
	
	/**
	 * Sets the panel habitaciones.
	 *
	 * @param panelHabitaciones the new panel habitaciones
	 */
	public void setPanelHabitaciones(PanelHabitaciones panelHabitaciones) {
		
		this.panelHabitaciones = panelHabitaciones;
		
		componentesPanel2(true);
	}
	
	/**
	 * Instantiates a new panel ficha.
	 *
	 * @param _panelUsuario      the panel usuario
	 * @param _panelHabitaciones the panel habitaciones
	 */
	public PanelFicha(PanelUsuario _panelUsuario, PanelHabitaciones _panelHabitaciones)
	{
		c1 = new Color(152, 182, 177);
		this.setBackground(c1);
		
		panelUsuario = _panelUsuario;
		panelHabitaciones = _panelHabitaciones;
		
	    JTabbedPane pestañas;	    
	    pestañas = new JTabbedPane();
	    
	    /*propiedades Panel1*/
	    //lo ponemos a false para que al iniciarse esten los datos vacios
	    componentesPanel1(false);
	   	/*propiedades Panel2*/
		componentesPanel2(false);
	    
	    pestañas.addTab ("Datos Cliente", miPanel);
	    pestañas.addTab ("Datos Habitacion", panel1);
	    
	    this.add (pestañas);
		
	}
	
	/**
	 * Componentes panel 1.
	 *
	 * @param nuevosDatos the nuevos datos
	 */
	private void componentesPanel1(boolean nuevosDatos) {
		
		texto = "";
		// Si recibo nuevos datos, se ponen en textarea
		if (nuevosDatos) {
			texto = panelUsuario.cogerDatosUsuarios();
			areaDeTexto1.setText(texto);
			return;
		}

		// Al no recibir nuevos datos (nuevosDatos es false), es la primera instanciación
		miPanel = new JPanel();
		
		/*Propiedades del Label, lo instanciamos, posicionamos y
		 * activamos los eventos*/
		labelTitulo = new JLabel();
		labelTitulo.setText("DATOS CLIENTE");
		
		areaDeTexto1 = new JTextArea();
		areaDeTexto1.setText(texto);
		
		/*Agregamos los componentes al Contenedor*/
		miPanel.add(labelTitulo);
		miPanel.add(areaDeTexto1);
		this.add(miPanel);
		
	}
	
	/**
	 * Componentes panel 2.
	 *
	 * @param nuevosDatos the nuevos datos
	 */
	private void componentesPanel2(boolean nuevosDatos) {
		
		texto = "";
		// Si recibo nuevos datos, se pone en textarea
		if (nuevosDatos) {
			texto = panelHabitaciones.cogerDatosHabitaciones();
			areaDeTexto.setText(texto);
			return;
		}
		
		panel1 = new JPanel();
		
		tituloPanel1= new JLabel();
		tituloPanel1.setText("DATOS HABITACION");
		
		areaDeTexto = new JTextArea();
		areaDeTexto.setText(texto);
		
		panel1.add(tituloPanel1);
		panel1.add(areaDeTexto);
		
		this.add(panel1);
	}

}
