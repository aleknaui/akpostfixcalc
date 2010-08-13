package akPostfixCalc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener {
	
	// --------------------------------------------------
	// Atributos
	// --------------------------------------------------
	
	/** Campo de texto que actua como pantalla de la calculadora */
	private JTextField display;
	/** Matriz de botones que contienen los números del 0 al 9,
	 * el boton de signo y el botón de decimal */
	private JButton[][] numeros;
	/** Arreglo de botones que ejecutan operaciones */
	private JButton[] operaciones;
	/**  Arreglo de botones que ejecutan opciones extra */
	private JButton[] opciones;
	
	/** La calculadora con la que se realizan los calculos */
	private PostfixCalc postfixCalc;
	/** Valor que indica que el valor desplegado en pantalla es la respuesta a
	 * una operación */
	private boolean mostrandoRespuesta;
	
	// --------------------------------------------------
	// Constructor
	// --------------------------------------------------
	
	public GUI(){
		setTitle( "AleKnaui Postfix Calculator" );
		setSize( 320, 330 );
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		setResizable(false);
		setBackground( new Color( 50,53,88 ) );
		setLayout( new GridBagLayout() );
		GridBagConstraints gb1 = new GridBagConstraints();
	    gb1.anchor = GridBagConstraints.CENTER;
	    gb1.fill = GridBagConstraints.BOTH;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = getSize().width;
	    int h = getSize().height;
	    int x = (dim.width-w)/2;
	    int y = (dim.height-h)/2;
	    setLocation(x, y);
	    
	    JPanel p1 = new JPanel();
	    p1.setLayout( new GridBagLayout() );
	    p1.setBackground( new Color( 50,53,88 ) );
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets( 5,5,5,5 );
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.fill = GridBagConstraints.BOTH;
	    
		postfixCalc = new PostfixCalc();
		mostrandoRespuesta = false;
		
		display = new JTextField("0");
		display.setEditable( false );
		display.setBackground(new Color( 157,233,108 ));
		display.setFont( new Font("Courier New", Font.BOLD, 30) );
			gbc.ipady = 50;
			gbc.gridwidth = 4;
		p1.add( display, gbc );
		
		gbc.ipady = 0;
		gbc.gridwidth = 1;
		gbc.gridy = 1;
		numeros = new JButton[4][3];
		numeros[0][0] = new JButton(" 7 ");
		numeros[0][0].setActionCommand("7");
		numeros[0][0].addActionListener( this );
		p1.add( numeros[0][0], gbc );
		numeros[0][1] = new JButton(" 8 ");
		numeros[0][1].setActionCommand("8");
		numeros[0][1].addActionListener( this );
		gbc.gridx = 1;
		p1.add( numeros[0][1], gbc );
		numeros[0][2] = new JButton("9");
		numeros[0][2].setActionCommand("9");
		numeros[0][2].addActionListener( this );
		gbc.gridx = 2;
		p1.add( numeros[0][2], gbc );
		numeros[1][0] = new JButton("4");
		numeros[1][0].setActionCommand("4");
		numeros[1][0].addActionListener( this );
		gbc.gridx = 0;
		gbc.gridy = 2;
		p1.add( numeros[1][0], gbc );
		numeros[1][1] = new JButton("5");
		numeros[1][1].setActionCommand("5");
		numeros[1][1].addActionListener( this );
		gbc.gridx = 1;
		p1.add( numeros[1][1], gbc );
		numeros[1][2] = new JButton("6");
		numeros[1][2].setActionCommand("6");
		numeros[1][2].addActionListener( this );
		gbc.gridx = 2;
		p1.add( numeros[1][2], gbc );
		numeros[2][0] = new JButton("1");
		numeros[2][0].setActionCommand("1");
		numeros[2][0].addActionListener( this );
		gbc.gridx = 0;
		gbc.gridy = 3;
		p1.add( numeros[2][0], gbc );
		numeros[2][1] = new JButton("2");
		numeros[2][1].setActionCommand("2");
		numeros[2][1].addActionListener( this );
		gbc.gridx = 1;
		p1.add( numeros[2][1], gbc );
		numeros[2][2] = new JButton("3");
		numeros[2][2].setActionCommand("3");
		numeros[2][2].addActionListener( this );
		gbc.gridx = 2;
		p1.add( numeros[2][2], gbc );
		numeros[3][0] = new JButton("0");
		numeros[3][0].setActionCommand("0");
		numeros[3][0].addActionListener( this );
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		p1.add( numeros[3][0], gbc );
		numeros[3][1] = new JButton(".");
		numeros[3][1].setActionCommand(".");
		numeros[3][1].addActionListener( this );
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		numeros[3][2] = new JButton("+/-");
		numeros[3][2].setActionCommand("sgn");
		numeros[3][2].addActionListener( this );
		gbc.gridx = 2;
		p1.add( numeros[3][2], gbc );
		
		for( int i = 0; i < 4; i++ ){
			for( int j = 0; j < 3; j++ ){
				numeros[i][j].setBackground( Color.BLACK );
				numeros[i][j].setForeground( Color.WHITE );
				numeros[i][j].setFont( new Font("Courier New", Font.BOLD, 20) );
			}
		}
		
		operaciones = new JButton[4];
		operaciones[0] = new JButton(" / ");
		operaciones[0].setActionCommand("/");
		operaciones[0].addActionListener( this );
		gbc.gridx = 3;
		gbc.gridy = 1;
		p1.add( operaciones[0], gbc );
		operaciones[1] = new JButton(" * ");
		operaciones[1].setActionCommand("*");
		operaciones[1].addActionListener( this );
		gbc.gridx = 3;
		gbc.gridy = 2;
		p1.add( operaciones[1], gbc );
		operaciones[2] = new JButton(" - ");
		operaciones[2].setActionCommand("-");
		operaciones[2].addActionListener( this );
		gbc.gridx = 3;
		gbc.gridy = 3;
		p1.add( operaciones[2], gbc );
		operaciones[3] = new JButton(" + ");
		operaciones[3].setActionCommand("+");
		operaciones[3].addActionListener( this );
		gbc.gridx = 3;
		gbc.gridy = 4;
		p1.add( operaciones[3], gbc );
		
		for( int i = 0; i < 4; i++ ){
			operaciones[i].setBackground( new Color( 27,27,56 ) );
			operaciones[i].setForeground( Color.WHITE );
			operaciones[i].setFont( new Font("Courier New", Font.BOLD, 20) );
		}
		
		add(p1, gb1);
		gb1.gridy = 1;
		
		JPanel p2 = new JPanel();
		p2.setLayout( new GridBagLayout() );
	    p2.setBackground( new Color( 50,53,88 ) );
	    gbc = new GridBagConstraints();
	    gbc.insets = new Insets( 5,5,5,5 );
	    gbc.anchor = GridBagConstraints.CENTER;
	    gbc.fill = GridBagConstraints.BOTH;
	    
	    opciones = new JButton[3];
		opciones[2] = new JButton("ENTER");
		opciones[2].setActionCommand("ENTER");
		opciones[2].addActionListener( this );
		gbc.gridx = 0;
		p2.add( opciones[2], gbc );
		opciones[1] = new JButton("CLEAR");
		opciones[1].setActionCommand("CLEAR");
		opciones[1].addActionListener( this );
		gbc.gridx = 1;
		p2.add( opciones[1], gbc );
		opciones[0] = new JButton("RESET");
		opciones[0].setActionCommand("RESET");
		opciones[0].addActionListener( this );
		gbc.gridx = 2;
		p2.add( opciones[0], gbc );
		
		for( int i = 0; i < 3; i++ ){
			opciones[i].setBackground( new Color( 175,30,50 ) );
			opciones[i].setForeground( Color.WHITE );
			opciones[i].setFont( new Font("Courier New", Font.BOLD, 20) );
		}
	    
	    add( p2, gb1 );
	}
	
	// --------------------------------------------------
	// Métodos
	// --------------------------------------------------
	
	/**
	 * Agrega a lo desplegado en pantalla el digito indicado
	 * @param digito El dígito a agregar
	 */
	public void agregarDigito( String digito ){
		if( ! mostrandoRespuesta ){
			if( ! display.getText().equals("0") )
				display.setText( display.getText() + digito );
			else
				display.setText( digito );
		} else{
			display.setText( digito );
			mostrandoRespuesta = false;
		}
	}
	
	/**
	 * Cambia el signo del número desplegado en pantalla
	 */
	public void cambiarSigno(){
		if( ! display.getText().equals("0") ){
			if( display.getText().startsWith("-") )
				display.setText( display.getText().substring(1) );
			else
				display.setText( "-" + display.getText() );
		}
	}
	
	/**
	 * Indica al PostfixCalc que realice una operación
	 * @param operador El signo de la operación deseada
	 */
	public void operar( char operador ){
		if( ! mostrandoRespuesta )
			enter();
		display.setText( postfixCalc.operar( operador ));
		mostrandoRespuesta = true;
	}
	
	/**
	 * Guarda el número en pantalla en la pila del PostfixCalc
	 */
	public void enter(){
		postfixCalc.ingresarOperando( Integer.parseInt( display.getText() ) );
		clear();
	}
	
	/**
	 * Borra la información en pantalla, dejando solamente un cero
	 */
	public void clear(){
		display.setText("0");
	}
	
	/**
	 * Resetea la PostfixCalc y el display
	 */
	public void reset(){
		clear();
		postfixCalc.reset();
	}
	
	
	
	// --------------------------------------------------
	// Método main
	// --------------------------------------------------
	
	/**
	 * Ejecuta el programa
	 * @param args No son necesarios
	 */
	public static void main(String[] args) {
		new GUI().setVisible(true);
	}
	
	// --------------------------------------------------
	// Respuesta a eventos
	// --------------------------------------------------

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if( Character.isDigit(comando.charAt(0)) || comando.charAt(0) == '.' )
			agregarDigito( comando );
		else if( comando.equals("sgn") )
			cambiarSigno();
		else if( comando.equals( "ENTER" ) )
			enter();
		else if( comando.equals( "CLEAR" ) )
			clear();
		else if( comando.equals( "RESET" ) )
			reset();
		else
			operar( comando.charAt(0) );
	}
}
