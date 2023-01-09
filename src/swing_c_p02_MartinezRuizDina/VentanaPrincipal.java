/**
 * swing_c_p02_MartinezRuizDina-swing_c_p02_MartinezRuizDina-VentanaPrincipal.java
 * 21 nov 2022 8:23:36
 * @author Dina Martínez Ruiz
 */
package swing_c_p02_MartinezRuizDina;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The Class VentanaPrincipal.
 *
 * @author Dina
 */
public class VentanaPrincipal extends JFrame implements ActionListener {
	
	/** The mi panel. */
	private JPanel miPanel;
	
	/** The boton bajas. */
	private JButton botonAltas, botonBajas;
	
	/** The mi ventana principal. */
	private VentanaPrincipal miVentanaPrincipal;
	
	
	/** The mi barra. */
	private JMenuBar miBarra;
	
	/** The ayuda. */
	private JMenu archivo, registro, ayuda;
	
	/** The bajas reservas. */
	private JMenuItem salir, acercaDe, altasReservas, bajasReservas;
	
	/** The informacion aplicacion. */
	private	String informacionAplicacion="";
	
	/** The informacion bajas. */
	private String informacionBajas="";

	/**
	 * Instantiates a new ventana principal.
	 */
	public VentanaPrincipal() {

		iniciarComponentes();

		setTitle("Gestión Hotel 'Sauron'");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamagnoPantalla = miPantalla.getScreenSize();

		int altoPantalla =  tamagnoPantalla.height;
		
		int anchoPantalla = tamagnoPantalla.width;
		
		this.setSize(anchoPantalla/2,altoPantalla/2);

		this.setLocation(anchoPantalla/4,altoPantalla/4);
		
		java.awt.Image miIcono= miPantalla.getImage(getClass().getResource("recursos/eyesauron.jpeg"));
		
		this.setIconImage((java.awt.Image) miIcono);
		
		setLocationRelativeTo(null);
	}
	
	/**
	 * Sets the ventana principal.
	 *
	 * @param miVentana the new ventana principal
	 */
	public void setVentanaPrincipal(VentanaPrincipal miVentana) {
		
		miVentanaPrincipal = miVentana;
	}

	/**
	 * Iniciar componentes.
	 */
	private void iniciarComponentes() {
		
		miPanel = new JPanel();

		informacionAplicacion="Esta es una aplicacion de la Gestión Hotel 'Sauron' \n";
		informacionAplicacion+="se pueden hacer altas y bajas de reservas \n";
		
		informacionBajas="Todavia no esta desarrollada esta opcion";
		
		//menu
		miBarra = new JMenuBar();	
		archivo = new JMenu("Archivo");
		registro = new JMenu("Registro");
		ayuda = new JMenu("Ayuda");
		
		
		//opciones de menu
		salir = new JMenuItem("Salir");
		altasReservas = new JMenuItem("Altas Reservas");
		bajasReservas = new JMenuItem("Bajas Reservas");
		acercaDe = new JMenuItem("Acerca de...");
		
		archivo.add(salir);
		registro.add(altasReservas);
		registro.add(bajasReservas);
		ayuda.add(acercaDe);
		
		//alt+R
		registro.setMnemonic(KeyEvent.VK_R);
		
        salir.addActionListener(this);
        acercaDe.addActionListener(this);
        altasReservas.addActionListener(this);
        bajasReservas.addActionListener(this);

        //se añade al JMenuBar
		miBarra.add(archivo);
		miBarra.add(registro);
		miBarra.add(ayuda);
		

		botonAltas = new JButton();
		botonAltas.setIcon(new ImageIcon(getClass().getResource("recursos/altaRegistro.png")));
		botonAltas.setMnemonic(KeyEvent.VK_A);
		botonAltas.setToolTipText("Para dar de alta un nuevo cliente");
		botonBajas = new JButton();
		botonBajas.setIcon(new ImageIcon(getClass().getResource("recursos/bajaRegistro.png")));
		botonBajas.setMnemonic(KeyEvent.VK_B);
		botonBajas.setToolTipText("Para dar de baja cliente existente");
		
	
		botonAltas.addActionListener(this);
		botonBajas.addActionListener(this);

		
		miPanel.add(botonAltas);
		miPanel.add(botonBajas);
		
		miPanel.add(miBarra);
		
		
		add(miPanel);
		
		this.setJMenuBar(miBarra);	
	}
	
	
	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == botonAltas) {
			
			VentanaDialogo miVentanaConfirmacion = new VentanaDialogo(miVentanaPrincipal, true);
			miVentanaConfirmacion.setVisible(true);
		}
		
		if (e.getSource() == botonBajas) {
			
			JOptionPane.showMessageDialog(null, informacionBajas,"INFORMACION",JOptionPane.INFORMATION_MESSAGE);
		
		}
				
		if(e.getSource()==salir){
			
			System.exit(0);
			
		}
		
		if (e.getSource() == altasReservas) {
			
			VentanaDialogo miVentanaConfirmacion = new VentanaDialogo(miVentanaPrincipal, true);
			miVentanaConfirmacion.setVisible(true);
		}
		
		
		if (e.getSource()==bajasReservas) {
			
			JOptionPane.showMessageDialog(null, informacionBajas,"INFORMACION",JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		if (e.getSource()==acercaDe) {
			
			JOptionPane.showMessageDialog(null, informacionAplicacion,"INFORMACION",JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
