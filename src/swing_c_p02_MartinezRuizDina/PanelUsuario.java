/**
 * swing_c_p02_MartinezRuizDina-swing_c_p02_MartinezRuizDina-PanelUsuario.java
 * 21 nov 2022 9:43:42
 * @author Dina Martínez Ruiz
 */
package swing_c_p02_MartinezRuizDina;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.text.MaskFormatter;

/**
 * The Class PanelUsuario.
 *
 * @author Dina
 */
public class PanelUsuario extends JPanel {
	
	/** The etiqueta estancia. */
	private JLabel etiquetaNombre, etiquetaApellidos, etiquetaDNI, etiquetaTelefono,
	etiquetaFechaEntrada, etiquetaFechaSalida, etiquetaEstancia;
	
	/** The caja de texto con formato fecha salida. */
	private JFormattedTextField cajaDeTextoConFormatoDNI, cajaDeTextoConFormatoFechaEntrada,
	cajaDeTextoConFormatoTelefono, cajaDeTextoConFormatoFechaSalida;
	
	/** The etiqueta radio button. */
	private JLabel etiquetaRadioButton;
	
	/** The radio. */
	private JRadioButton radio;
	
	/** The campo estancia. */
	private JFormattedTextField campoNombre, campoApellidos,campoEstancia;
	
	/** The mascara DNI. */
	private MaskFormatter mascaraTelefono, mascaraDNI;
	
	/** The c 1. */
	private Color c1;
	
	/** The layout. */
	private GridBagLayout layout; // distribuye las cosas
	
	/** The constraints. */
	private GridBagConstraints constraints; // guarda las caracteristicas
	
	
	/**
	 * Instantiates a new panel usuario.
	 */
	public PanelUsuario() {
		
		layout = new GridBagLayout();
		this.setLayout( layout ); // set frame layout
		constraints = new GridBagConstraints(); // instantiate constraints
		
		c1 = new Color(152, 182, 177);
		this.setBackground(c1);
		
		constraints.weighty = 1;
		constraints.weightx= 1;
		constraints.fill = GridBagConstraints.BOTH;
		
		etiquetaNombre = new JLabel("Nombre: ");
		etiquetaNombre.setForeground(new Color(98,37,209));
		this.addComponent(etiquetaNombre,0,0,1,1);
		
		campoNombre = new JFormattedTextField();
		this.addComponent(campoNombre,1,0,1,1);
		
		etiquetaApellidos = new JLabel("Apellidos: ");
		etiquetaApellidos.setForeground(new Color(98,37,209));
		this.addComponent(etiquetaApellidos,0,1,1,1);
		
		campoApellidos = new JFormattedTextField();
		this.addComponent(campoApellidos,1,1,1,1);
		
		etiquetaDNI = new JLabel("DNI: ");
		etiquetaDNI.setForeground(new Color(98,37,209));
		this.addComponent(etiquetaDNI,0,2,1,1);
		
		try 
		{
			mascaraDNI = new MaskFormatter("########A");
			cajaDeTextoConFormatoDNI = new JFormattedTextField(mascaraDNI);
			cajaDeTextoConFormatoDNI.setFocusLostBehavior(cajaDeTextoConFormatoDNI.COMMIT);
			this.addComponent(cajaDeTextoConFormatoDNI,1,2,1,1);
			
		} catch (ParseException e2) {
			
			e2.printStackTrace();
		}
		
		etiquetaTelefono=new JLabel("Telefono:");
		etiquetaTelefono.setForeground(new Color(98,37,209));
		this.addComponent(etiquetaTelefono,0,3,1,1);
		
		try 
		{
			mascaraTelefono = new MaskFormatter("#########");
			cajaDeTextoConFormatoTelefono = new JFormattedTextField(mascaraTelefono);
			cajaDeTextoConFormatoTelefono.setFocusLostBehavior(cajaDeTextoConFormatoTelefono.COMMIT);
			this.addComponent(cajaDeTextoConFormatoTelefono,1,3,1,1);
			
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		
		etiquetaFechaEntrada = new JLabel("Fecha de Entrada: ");
		etiquetaFechaEntrada.setForeground(new Color(98,37,209));
		this.addComponent(etiquetaFechaEntrada,0,4,1,1);
		
		DateFormat Date_Format = new SimpleDateFormat("dd/MM/YYYY");
		cajaDeTextoConFormatoFechaEntrada = new JFormattedTextField(Date_Format);
		Instant instanteAhora = Instant.now(); // Fecha ahora en tipo Instant (timestamp)
		Date fechaEntrada = Date.from(instanteAhora); // Misma fecha en diferente tipo de objeto para no perder precisión
		cajaDeTextoConFormatoFechaEntrada.setValue(fechaEntrada);
		cajaDeTextoConFormatoFechaEntrada.setEditable(false);
		this.addComponent(cajaDeTextoConFormatoFechaEntrada,1,4,1,1);
		
		etiquetaFechaSalida = new JLabel("Fecha de Salida: ");
		etiquetaFechaSalida.setForeground(new Color(98,37,209));
		this.addComponent(etiquetaFechaSalida,0,5,1,1);
		
		cajaDeTextoConFormatoFechaSalida = new JFormattedTextField(Date_Format);
		Instant instanteDiaDespues = instanteAhora.plus(Duration.ofDays(1)); // le añado 1 día
		Date fechaSalida = Date.from(instanteDiaDespues); // Transformo a Date para poder mostrarlo
		cajaDeTextoConFormatoFechaSalida.setValue(fechaSalida);
		cajaDeTextoConFormatoFechaSalida.setEditable(false);
		this.addComponent(cajaDeTextoConFormatoFechaSalida,1,5,1,1);
		
		// long porque puede ser que int se quede corto en el número de días de diferencia
	    long daysBetween = Duration.between(instanteAhora, instanteDiaDespues).toDays();
		etiquetaEstancia = new JLabel("Nº Estancia");
		etiquetaEstancia.setForeground(new Color(98,37,209));
		this.addComponent(etiquetaEstancia,0,6,1,1);
		campoEstancia = new JFormattedTextField();
		campoEstancia.setValue(daysBetween);
		this.addComponent(campoEstancia,1,6,1,1);
		
		//incorporacion de un componente con la gestion de un evento
		etiquetaRadioButton = new JLabel("¿Desayuno incluido?");
		etiquetaRadioButton.setToolTipText("Para saber si quiere desayuno");
		etiquetaRadioButton.setForeground(new Color(98,37,209));
		this.addComponent(etiquetaRadioButton,0,7,1,1);
		radio = new JRadioButton("Desayuno +10€");
		radio.addActionListener(listener);
		this.addComponent(radio,1,7,1,1);
	

		
	}
	
	/**
	 * Coger datos usuarios.
	 *
	 * @return the string
	 */
	//para coger los datos y mandarlos al panelFicha
	public String cogerDatosUsuarios()
	{
		String retorno = "";
		
		retorno += "Nombre: " + campoNombre.getText() + "\n";
		retorno += "Apellidos: " + campoApellidos.getText() + "\n";
		retorno += "DNI: " + cajaDeTextoConFormatoDNI.getText() + "\n";
		retorno += "Telefono: " + cajaDeTextoConFormatoTelefono.getText() + "\n";
		retorno += "Fecha de Entrada: " + cajaDeTextoConFormatoFechaEntrada.getText() + "\n";
		retorno += "Fecha de Salida: " + cajaDeTextoConFormatoFechaSalida.getText() + "\n";
		retorno += "Estancia: " + campoEstancia.getText() + "\n";
		retorno += "Desayuno: " + radio.isSelected() + "\n";

		return retorno;
	}
	
	/**
	 * Comprobar datos.
	 */
	public void comprobarDatos() {
		boolean ok = !(campoNombre.getText().equals("")) && !(campoApellidos.getText().equals(""));
		if (ok) {
			JOptionPane.showMessageDialog(this, "Registro guardado", "Datos del Formulario",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Faltan los datos de Nombre y Apellidos por cumplimentar", "Datos del Formulario",
					JOptionPane.ERROR_MESSAGE);
		}
		campoNombre.requestFocus();
	}// fin comprobarFormulario
	
	 /**
	 * Adds the component.
	 *
	 * @param component the component
	 * @param column    the column
	 * @param row       the row
	 * @param width     the width
	 * @param height    the height
	 */
 	private void addComponent(Component component,int column, int row, int width,int height ) {
			
		constraints.gridx = column; // set gridx, La columna en la que se colocarᠥl 
		//componente.
		constraints.gridy = row; // set gridy, La fila en la que se colocarᠥl 
		//componente.
		constraints.gridwidth = width; // set gridwidth, El nmero de columnas que 
		//ocupa el componente.
		constraints.gridheight = height; // set gridheight, El nmero de filas que 
		//ocupa el componente.
		
		//metelo en el layout con esas caracteristicas, pasarle los compnentes
		 layout.setConstraints(component, constraints ); // set constraints
		 this.add(component); // add component
	 } // end method addComponen


	    /** The listener. */
    	ActionListener listener = new ActionListener()
	    {
	        public void actionPerformed(ActionEvent event)
	        {
	             int mode = 0;
	             if (radio.isSelected()) {
	            	 
	            	 JOptionPane.showMessageDialog(radio, "Quiere desayuno incluido");
	            	 
	             }
	         }
	    };
	   
	  

   
}
