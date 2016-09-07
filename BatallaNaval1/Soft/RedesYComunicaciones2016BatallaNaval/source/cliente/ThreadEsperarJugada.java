
package cliente;

import interfazCliente.*;

/**
 * Esta clase implementa lo que se debe hacer en un hilo de ejecución cuando se quiere esperar la jugada del oponente.
 */
public class ThreadEsperarJugada extends Thread
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la referencia al juego
     */
    private Jugador jugador;

    /**
     * Es la referencia a la ventana principal de la aplicación
     */
    private InterfazJugador principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el nuevo hilo y lo deja listo para esperar la jugada
     * @param juego Es una referencia al juego - juego != null
     * @param interfaz Es una referencia a la ventana principal de la aplicación - interfaz != null
     */
    public ThreadEsperarJugada( Jugador juego, InterfazJugador interfaz )
    {
        super( );
        jugador = juego;
        principal = interfaz;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicia la ejecución del hilo que espera la jugada del oponente. <br>
     * Cuando se tiene información sobre el disparo del oponente entonces se actualiza la interfaz.<br>
     * Si el juego debe terminar entonces muestra quien fue el ganador y termina el encuentro y la conexión al servidor.
     */
    @Override
	public void run( )
    {
        try
        {
            jugador.esperarJugada( );
            principal.actualizarInterfaz( );

            if( jugador.juegoTerminado( ) )
            {
                jugador.terminarEncuentro( );
                principal.actualizarInterfaz( );
                principal.mostrarGanador( );
            }
        }
        catch( BatallaNavalException e )
        {
            e.printStackTrace( );
        }
    }
}
