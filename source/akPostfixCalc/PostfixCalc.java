package akPostfixCalc;
/**
 * Clase que realiza cálculos en notación postfix
 * @author ale
 */
public class PostfixCalc{
	
	// --------------------------------------------------
	// Atributos
	// --------------------------------------------------
	
	/** Pila que contiene los operandos de la calculadora */
	private Pila<Double> pila;
	
	// --------------------------------------------------
	// Constructor
	// --------------------------------------------------
	
	/**
	 * Instancia la clase.
	 * post: Se crea la calculadora con la pila vacía
	 */
	public PostfixCalc(){
		pila = new akPila<Double>();
	}
	
	// --------------------------------------------------
	// Metodos
	// --------------------------------------------------
	
	/**
	 * Ingresa un operando a la pila
	 * @param operando El operando a ingresar a la pila
	 */
	public void ingresarOperando( double operando ){
		pila.push( operando );
	}
	
	/**
	 * Opera de acuerdo al operador ingresado como caracter
	 * @param operador El signo de la operacion que se desea ejecutar
	 * @return Si hay errores, un mensaje indicando el error. Si no, el resultado de la operación.
	 */
	public String operar( char operador ){
		if( pila.isEmpty() ) return "0";
		double op1 = pila.pop();
		double op2;
		if( pila.size() == 1 ) op2 = 0;
		else op2 = pila.pop();
		double respuesta;
		switch( operador ){
		case '+':
			respuesta = op1 + op2;
			break;
		case '-':
			respuesta = op1 - op2;
			break;
		case '*':
			respuesta = op1 * op2;
			break;
		case '/':
			switch( (int)op2 ){
			case 0:
				return "E: Denominador 0";
			default:
				respuesta = op1 / op2;
			}
			break;
		default:
			return "Error desconocido";
		}
		return respuesta + "";
	}
	
	/**
	 * Reinicia la pila
	 */
	public void reset(){
		pila = new akPila<Double>();
	}
	
}