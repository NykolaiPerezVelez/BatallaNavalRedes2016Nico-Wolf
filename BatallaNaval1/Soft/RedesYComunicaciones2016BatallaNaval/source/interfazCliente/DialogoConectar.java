
package interfazCliente;

import javax.swing.JDialog;

/**
 * Es el di�logo usado para pedir los datos necesarios para iniciar una conexi�n
 */
public class DialogoConectar extends JDialog
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazJugador principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el panel donde se ingresan los datos
     */
    private PanelDatosJuego panelDatos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el di�logo
     * @param ventanaPrincipal Es una referencia a la clase principal de la interfaz
     * @param nombre Nombre con el que se va a inicializar el panel
     * @param direccion Direcci�n del servidor para inicializar el panel
     * @param puerto Puerto para inicializar el panel
     */
    public DialogoConectar( InterfazJugador ventanaPrincipal, String nombre, String direccion, int puerto )
    {
        super( ventanaPrincipal, true );

        principal = ventanaPrincipal;
        panelDatos = new PanelDatosJuego( this, nombre, direccion, puerto );
        getContentPane( ).add( panelDatos );

        setTitle( "Datos de la Conexi�n" );
        setSize( 400, 200 );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Intenta realizar una conexi�n
     * @param nombre El nombre del jugador
     * @param direccion Direcci�n donde se encuentra el servidor
     * @param puerto Puerto usado para la conexi�n
     */
    public void conectar( String nombre, String direccion, int puerto )
    {
        principal.conectar( this, nombre, direccion, puerto );
    }

}
