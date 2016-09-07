

package cliente;

import interfazCliente.*;

/**
 * Esta clase implementa lo que se debe hacer en un hilo de ejecuci�n cuando se quiere enviar una jugada
 */
public class ThreadEnviarJugada extends Thread
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la referencia al juego
     */
    private Jugador jugador;

    /**
     * Es la referencia a la ventana principal de la aplicaci�n
     */
    private InterfazJugador principal;

    /**
     * Es la fila de la casilla donde se va a realizar el disparo
     */
    private int fila;

    /**
     * Es la columna de la casilla donde se va a realizar el disparo
     */
    private int columna;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constuye el nuevo hilo y lo deja listo para enviar la jugada
     * @param juego Es una referencia al juego - juego != null
     * @param interfaz Es una referencia a la ventana principal de la aplicaci�n - interfaz != null
     * @param filaJugada Es la fila de la casilla donde se va a realizar el disparo - 0 <= filaJugada < TablerosJuego.NUMERO_FILAS
     * @param columnaJugada Es la columna de la casilla donde se va a realizar el disparo - - 0 <= columnaJugada < TablerosJuego.NUMERO_COLUMNAS
     */
    public ThreadEnviarJugada( Jugador juego, InterfazJugador interfaz, int filaJugada, int columnaJugada )
    {
        super( );

        jugador = juego;
        principal = interfaz;
        fila = filaJugada;
        columna = columnaJugada;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicia la ejecuci�n del hilo que realiza el env�o del mensaje y espera la respuesta. <br>
     * Cuando se tiene informaci�n sobre el resultado de la jugada entonces se actualiza la interfaz.<br>
     * Si el juego debe terminar entonces muestra quien fue el ganador y termina el encuentro y la conexi�n al servidor.
     */
    @Override
	public void run( )
    {
       
            try {
				jugador.enviarJugada( fila, columna );
			} catch (BatallaNavalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            principal.actualizarInterfaz( );

            if( jugador.juegoTerminado( ) )
            {
                try {
					jugador.terminarEncuentro( );
				} catch (BatallaNavalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                principal.actualizarInterfaz( );
                principal.mostrarGanador( );
            }
            else
            {
                principal.esperarJugada( );
            }
        

       
    }
}
