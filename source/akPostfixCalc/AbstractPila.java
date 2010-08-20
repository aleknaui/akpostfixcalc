package akPostfixCalc;

/**
 * Clase abstracta que implementa los métodos que no dependen de la estructura de datos
 * utilizada para la implementación.
 * @author ale
 * @param <E> Genérico. El tipo de datos que se desea contener en la pila.
 */
public abstract class AbstractPila<E> implements Pila<E> {

	// --------------------------------------------------
	// Metodos
	// --------------------------------------------------	

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
	
	@Override
	public void superPop() {
		while( ! isEmpty() ){
			pop();
		}
	}
}
