package akPostfixCalc;
/**
 * Clase que implementa la estructura de datos Pila
 * @author ale
 * @param <E> Genérico. El tipo de datos que se desea contener en la pila.
 */
public class akPila<E> implements Pila<E>{
	
	// --------------------------------------------------
	// Atributos
	// --------------------------------------------------
	
	/** Los elementos que conforman la pila */
	private Object[] elementos;
	
	// --------------------------------------------------
	// Constructor
	// --------------------------------------------------
	
	/**
	 * Crea una nueva pila con 0 elementos.
	 * post: Se ha creado una pila vacía
	 */
	public akPila(){
		elementos = new Object[0];
	}
	
	// --------------------------------------------------
	// Metodos
	// --------------------------------------------------	

	@Override
	public boolean isEmpty() {
		return elementos.length == 0;
	}

	@Override
	public E peek() throws NullPointerException {
		if( isEmpty() ) throw new NullPointerException( "La lista se encuentra vacía" );
		else
			return (E) elementos[ size() -1 ];
	}

	@Override
	public E pop() throws NullPointerException {
		if( isEmpty() ) throw new NullPointerException( "La lista se encuentra vacía" );
		else{
			Object[] nuevos = new Object[ size() - 1 ];
			Object[] viejos = elementos;
			for( int i = 0; i < nuevos.length; i++ )
				nuevos[i] = elementos[i];
			elementos = nuevos;
			return (E) viejos[ size() ];
		}
	}
	@Override
	public void push( E elemento ) {
		Object[] nuevos = new Object[ size() + 1 ];
		for( int i = 0; i < size(); i++ )
			nuevos[i] = elementos[i];
		nuevos[ nuevos.length - 1 ] = elemento;
		elementos = nuevos;
	}

	@Override
	public int size() {
		return elementos.length;
	}

	@Override
	public void superPop() {
		while( ! isEmpty() ){
			pop();
		}
	}
	
}