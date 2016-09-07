

package cliente;


/**
 * Esta clase representa un tablero de juego<br>
 * <b>inv:</b><br>
 * tablero es una matriz de 15x15casillas y ninguna es null<br>
 */
public class Tablero
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Son las casillas que constituyen el tablero de juego
     */
    protected Casilla[][] tablero;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa el tablero, dejando todas las casillas vacías.<br>
     */
    public Tablero( )
    {
        tablero = new Casilla[15][15];
        for( int i = 0; i < 15; i++ )
        {
            for( int j = 0; j < 15; j++ )
            {
                tablero[ i ][ j ] = new Casilla( );
            }
        }
        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el contenido del tablero (este método solo se debe llamar desde las pruebas)
     * @return contenido del tablero
     */
    public Casilla[][] darTablero( )
    {
        return tablero;
    }

    /**
     * Retorna una casilla del tablero
     * @param fila La fila donde está la casilla - 0 <= fila < 15
     * @param columna La columna donde está la casilla - 0 <= columna < 15
     * @return Retorna la casilla indicada en el tablero
     */
    public Casilla darCasilla( int fila, int columna )
    {
        return tablero[ fila ][ columna ];
    }

    /**
     * Marca una casilla en el tablero del oponente con el estado indicado
     * @param fila La fila donde se encuentra la casilla - 0 <= fila < 15
     * @param columna La columna donde se encuentra la casilla - 0 <= columna < 15
     * @param nuevoEstado El nuevo estado que tendrá la casilla marcada - nuevoEstado está en {Casilla.VACIA, Casilla.OCUPADA, Casilla.ATACADA, Casilla.IMPACTADA}
     */
    public void marcarCasilla( int fila, int columna, int nuevoEstado )
    {
        tablero[ fila ][ columna ].marcar( nuevoEstado );
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

   
    private void verificarInvariante( )
    {
        assert tablero != null && tablero.length == 15 : "Tablero inválido";
        for( int i = 0; i < 15; i++ )
        {
            assert tablero[ i ] != null && tablero[ i ].length == 15 : "Tablero inválido";
            for( int j = 0; j < 15; j++ )
            {
                assert tablero[ i ][ j ] != null : "Casilla nula";
            }
        }
    }
}
