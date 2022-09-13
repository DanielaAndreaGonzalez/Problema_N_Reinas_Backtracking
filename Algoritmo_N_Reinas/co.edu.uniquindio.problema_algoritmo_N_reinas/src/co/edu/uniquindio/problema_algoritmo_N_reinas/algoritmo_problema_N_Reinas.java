/**
 * 
 */
package co.edu.uniquindio.problema_algoritmo_N_reinas;

/**
 * @author GonzalezHDanielaA
 *
 */
public class algoritmo_problema_N_Reinas {

	
	
	public static final int NUMEROREINAS = 5;
	public static int[][] tablero = new int[NUMEROREINAS][NUMEROREINAS]; 
	public static String letras[] = {"A","B","C","D","E","F","G","H"}; 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			inicializar();
	}
	
	// Metodo que sirve para imprimir la matriz
	public static void imprimir() {

		// Imprime cabecera
		System.out.print("   ");

		for (int i = 0; i < NUMEROREINAS; i++) {
			System.out.print(" " + letras[i] + "    ");
		}

		System.out.print("\n");

		// Imprime tablero - filas 0 a (NUMEROREINAS -1)

		for (int i = 0; i < NUMEROREINAS; i++) {
			// Imprime indice de fila
			System.out.print((i + 1));

			// Imprime fila i columnas 0 a (NUMEROREINAS -1)
			for (int j = 0; j < NUMEROREINAS; j++) {
				System.out.print("   " + tablero[i][j] + "  ");
			}

			System.out.print("\n\n");
		}
	}
	
	
	public static boolean posicionVerdadera(int fila , int columna)
	{
		
		//verificar que fila actual sea segura, verificando cada columna de esta
        for (int j = 0; j < columna; j++) 
            if (tablero[fila][j]==1) 
                return false; 
      
        //verifica diagonal superior del lado izquierdo sea segura
        for (int i=fila, j=columna; i>=0 && j>=0; i--, j--) 
            if (tablero[i][j]==1) 
                return false; 
      
        //verifica diagonal inferior del lado izquierdo sea segura
        for (int i=fila, j=columna; j>=0 && i<NUMEROREINAS; i++, j--) 
            if (tablero[i][j]==1) 
                return false; 
      
        //verifica que no hayan atacantes ni en sus lados, ni en sus diagonales
        return true; 
        
		
	}
	
	
	//Metodo Solucion del algoritmo
	public static boolean solucion(int columna)
	{
		//Case base si la solución es la correcta
		
		if(columna>=NUMEROREINAS)
		{
			return true;
		}
		//Se considera la columna actual como una posible solución y se verifica
		for(int i=0; i <NUMEROREINAS;i++)
		{
			//Verifica si se puede colocar en el tablero [i][columna]
			
			if(posicionVerdadera(i, columna)) {
				
				tablero[i][columna]=1;
				
				//Se invoca la función recursiva para dar solución a las demás reinas del tablero 
				
				if(solucion(columna+1))
				{
					return true;
				}
				
				tablero[i][columna]=0;
			}
		}
		
		//si no hay solucion , la reina no se coloca en ninguna fila de esta columna
		return false;
		
	}
	
	
	public static boolean inicializar()
	{
		
		if(solucion(0) == false) {
			System.out.println("No hay solución");
		    return false;
		}
		imprimir();
		return true;
		
	}
	
	
	
	
	

}

